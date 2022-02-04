package com.sisipapa.junit.mapper;

import com.sisipapa.junit.domain.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    @Mock
    private ProductMapper productMapper;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        // given
        List<ProductDto> mockProducts = List.of(
                ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build()
                ,ProductDto.of().idx(2L).name("여름 토퍼").description("여름 토퍼 설명").build()
                ,ProductDto.of().idx(3L).name("페이크 삭스").description("페이크 삭스 설명").build()
                ,ProductDto.of().idx(4L).name("우산").description("우산 설명").build()
        );
        when(productMapper.findAll()).thenReturn(mockProducts);

        // when
        List<ProductDto> resultProducts = productMapper.findAll();

        // then
        verify(productMapper).findAll();
        assertThat(mockProducts.get(0).getName()).isEqualTo(resultProducts.get(0).getName());
    }

    @Test
    void findByName() {
        // given
        String name = "베베숲 물티슈";
        when(productMapper.findByName(name)).thenReturn(ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build());

        // when
        ProductDto mockProductDto = productMapper.findByName(name);

        //then
        verify(productMapper).findByName(name);
        assertThat(mockProductDto.getName()).isEqualTo("베베숲 물티슈");
        assertThat(mockProductDto.getDescription()).isEqualTo("베베숲 물티슈 설명");

    }

    @Test
    void insertProduct() {
        // given
        ProductDto dto = ProductDto.of().name("신규1").description("신규1 설명").build();
        when(productMapper.insertProduct(dto)).thenReturn(1);

        // when
        int cnt = productMapper.insertProduct(dto);

        // then
        verify(productMapper).insertProduct(dto);
        assertThat(cnt).isEqualTo(1);
    }

    @Test
    void updateProduct() {
        // given
        ProductDto dto = ProductDto.of().idx(1L).name("베베숲 물티슈 >> 수정").description("베베숲 물티슈 설명 >> 수정").build();
        when(productMapper.updateProduct(dto)).thenReturn(1);

        // when
        int cnt = productMapper.updateProduct(dto);

        // then
        verify(productMapper).updateProduct(dto);
        assertThat(cnt).isEqualTo(1);
    }

    @Test
    void deleteProduct() {
        // given
        Long idx = 1L;
        when(productMapper.deleteProduct(idx)).thenReturn(1);

        // when
        int cnt = productMapper.deleteProduct(idx);

        // then
        verify(productMapper).deleteProduct(idx);
        assertThat(cnt).isEqualTo(1);
    }
}