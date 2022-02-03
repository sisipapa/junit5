package com.sisipapa.junit.mapper;

import com.sisipapa.junit.domain.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@Import({MapperConfig.class})
//@MybatisTest
@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        List<ProductDto> products = productMapper.findAll();
        assertEquals(products.size(), 4);
        assertEquals(products.get(0).getName(), "베베숲 물티슈");
        assertEquals(products.get(0).getDescription(), "베베숲 물티슈 설명");
    }


    @Test
    void findByName() {
        ProductDto dto = productMapper.findByName("베베숲 물티슈");
        assertEquals(dto.getName(), "베베숲 물티슈");
        assertEquals(dto.getDescription(), "베베숲 물티슈 설명");
    }

    @Test
    void insertProduct() {
        ProductDto dto = ProductDto.of().name("신규1").description("신규1 설명").build();
        int cnt = productMapper.insertProduct(dto);
        assertThat(cnt).isEqualTo(1);

        List<ProductDto> products = productMapper.findAll();
        assertThat(products.size()).isEqualTo(5);
    }

    @Test
    void updateProduct() {
        ProductDto dto = ProductDto.of().idx(1L).name("베베숲 물티슈 >> 수정").description("베베숲 물티슈 설명 >> 수정").build();
        productMapper.updateProduct(dto);
        ProductDto findDto = productMapper.findByIdx(1L);
        assertThat(findDto.getName()).isEqualTo("베베숲 물티슈 >> 수정");
        assertThat(findDto.getDescription()).isEqualTo("베베숲 물티슈 설명 >> 수정");
    }

    @Test
    void deleteProduct() {
        productMapper.deleteProduct(1L);
        ProductDto dto = productMapper.findByName("베베숲 물티슈");
        assertThat(dto).isNull();
    }
}