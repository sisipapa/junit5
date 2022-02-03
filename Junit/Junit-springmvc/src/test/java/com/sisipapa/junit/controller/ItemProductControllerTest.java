package com.sisipapa.junit.controller;

import com.sisipapa.junit.domain.Item;
import com.sisipapa.junit.domain.dto.ProductDto;
import com.sisipapa.junit.service.ItemProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ItemProductController.class)
public class ItemProductControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ItemProductService itemProductService;

    @BeforeEach
    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new ItemProductController(itemProductService))
//                .addFilters(new CharacterEncodingFilter("UTF-8", true)) // utf-8 필터 추가
//                .build();
    }


    @Test
    void itemSave() throws Exception {

        // given
        Item mockItem = Item.builder()
                .idx(1L)
                .name("신상품1")
                .description("신상품1 설명")
                .build();
        given(itemProductService.itemSave(any())).willReturn(mockItem);

        // when
        final ResultActions actions =
                mvc.perform(post("/api/v1/item")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content("{" +
//                                        "\"idx\" : \"1\"," +
                                        "\"name\" : \"신상품1\"," +
                                        "\"description\" : \"신상품1 설명\"" +
                                        "}"));

        // then
        verify(itemProductService).itemSave(any());
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name").value("신상품1"))
                .andExpect(jsonPath("description").value("신상품1 설명"))
                .andDo(print());
    }

    @Test
    void findAll() throws Exception {
        // given
        List<ProductDto> mockProducts = List.of(
                ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build()
                ,ProductDto.of().idx(2L).name("여름 토퍼").description("여름 토퍼 설명").build()
                ,ProductDto.of().idx(3L).name("페이크 삭스").description("페이크 삭스 설명").build()
                ,ProductDto.of().idx(4L).name("우산").description("우산 설명").build()
        );
        given(itemProductService.findAll()).willReturn(mockProducts);

        // when
        final ResultActions actions =
                mvc.perform(get("/api/v1/products"));

        // then
        String expectByUsername = "$.[?(@.username == '%s')]";
        String addressByCity = "$..address[?(@.city == '%s')]";


        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[2]").exists())
                .andExpect(jsonPath("$[3]").exists())
                .andExpect(jsonPath("$[0].name").value("베베숲 물티슈"))
                .andExpect(jsonPath("$[0].description").value("베베숲 물티슈 설명"))
                .andDo(print());
    }

}
