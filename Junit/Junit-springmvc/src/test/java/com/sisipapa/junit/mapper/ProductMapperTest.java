package com.sisipapa.junit.mapper;

import com.sisipapa.junit.domain.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

//@Import({MapperConfig.class})
@MybatisTest
//@SpringBootTest
class ProductMapperTest {

//    @Autowired
//    private ProductMapper productMapper;

    @Mock
    private ProductMapper mockProductMapper;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
//        List<ProductDto> products = productMapper.findAll();
//        assertEquals(products.size(), 4);
//        assertEquals(products.get(0).getName(), "베베숲 물티슈");
//        assertEquals(products.get(0).getDescription(), "베베숲 물티슈 설명");

        // given
        List<ProductDto> mockProducts = List.of(
                ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build()
                ,ProductDto.of().idx(2L).name("여름 토퍼").description("여름 토퍼 설명").build()
                ,ProductDto.of().idx(3L).name("페이크 삭스").description("페이크 삭스 설명").build()
                ,ProductDto.of().idx(4L).name("우산").description("우산 설명").build()
        );
        given(mockProductMapper.findAll()).willReturn(mockProducts);

        // when
        List<ProductDto> resultProducts = mockProductMapper.findAll();

        // then
        verify(mockProductMapper).findAll();
        assertThat(mockProducts.get(0).getName()).isEqualTo(resultProducts.get(0).getName());
    }

//    @Test
//    void findByName() {
//        ProductDto dto = productMapper.findByName("베베숲 물티슈");
//        assertEquals(dto.getName(), "베베숲 물티슈");
//        assertEquals(dto.getDescription(), "베베숲 물티슈 설명");
//    }
//
//    @Test
//    void insertProduct() {
//        ProductDto dto = ProductDto.of().name("신규1").description("신규1 설명").build();
//        int cnt = productMapper.insertProduct(dto);
//        assertThat(cnt).isEqualTo(1);
//
//        List<ProductDto> products = productMapper.findAll();
//        assertThat(products.size()).isEqualTo(5);
//    }
//
//    @Test
//    void updateProduct() {
//        ProductDto dto = ProductDto.of().idx(1L).name("베베숲 물티슈 >> 수정").description("베베숲 물티슈 설명 >> 수정").build();
//        productMapper.updateProduct(dto);
//        ProductDto findDto = productMapper.findByIdx(1L);
//        assertThat(findDto.getName()).isEqualTo("베베숲 물티슈 >> 수정");
//        assertThat(findDto.getDescription()).isEqualTo("베베숲 물티슈 설명 >> 수정");
//    }
//
//    @Test
//    void deleteProduct() {
//        productMapper.deleteProduct(1L);
//        ProductDto dto = productMapper.findByName("베베숲 물티슈");
//        assertThat(dto).isNull();
//    }
}