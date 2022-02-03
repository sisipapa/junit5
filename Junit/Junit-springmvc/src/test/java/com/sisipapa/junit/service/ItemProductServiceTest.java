package com.sisipapa.junit.service;

import com.sisipapa.junit.domain.Item;
import com.sisipapa.junit.domain.dto.ProductDto;
import com.sisipapa.junit.mapper.ProductMapper;
import com.sisipapa.junit.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemProductServiceTest {

    @Mock
    ItemRepository itemRepository;

    @Mock
    ProductMapper productMapper;

    @InjectMocks
    ItemProductService itemProductService;

    @Test
    @DisplayName("ITEM 테이블 등록")
    void itemSave(){
        // given
        Item mockItem = Item.builder().name("test-item1").description("test-item1-description").build();
        when(itemRepository.save(mockItem)).thenReturn(Item.builder().idx(5L).name("test-item1").description("test-item1-description").build());
//        given(itemRepository.save(item)).willReturn(Item.builder().idx(5L).name("test-item1").description("test-item1-description").build());

        // when
        Item resultItem = itemProductService.itemSave(mockItem);

        // then
        verify(itemRepository).save(mockItem);
        assertThat(resultItem.getName()).isEqualTo(mockItem.getName());

    }

    @Test
    @DisplayName("Product 테이블 전체 조회")
    void findAll(){
        // given
        List<ProductDto> mockProducts = List.of(
                ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build()
                ,ProductDto.of().idx(2L).name("여름 토퍼").description("여름 토퍼 설명").build()
                ,ProductDto.of().idx(3L).name("페이크 삭스").description("페이크 삭스 설명").build()
                ,ProductDto.of().idx(4L).name("우산").description("우산 설명").build()
        );
        when(productMapper.findAll()).thenReturn(mockProducts);

        // when
        List<ProductDto> resultProducts = itemProductService.findAll();

        // then
        verify(productMapper).findAll();
        assertThat(resultProducts.size()).isEqualTo(mockProducts.size());
    }

    @Test
    @DisplayName("Product 테이블 Name컬럼으로 조회")
    void findByName(){
        // given
        String name = "베베숲 물티슈";
        ProductDto mockProductDto = ProductDto.of().idx(1L).name("베베숲 물티슈").description("베베숲 물티슈 설명").build();
        given(productMapper.findByName(name)).willReturn(mockProductDto);

        // when
        ProductDto resultProductDto = itemProductService.findByName(name);

        // then
        verify(productMapper).findByName(name);
        assertThat(mockProductDto).isEqualTo(resultProductDto);
        assertThat(mockProductDto.getIdx()).isEqualTo(resultProductDto.getIdx());
        assertThat(mockProductDto.getName()).isEqualTo(resultProductDto.getName());
        assertThat(mockProductDto.getDescription()).isEqualTo(resultProductDto.getDescription());
    }

    @Test
    @DisplayName("Product 테이블 idx 필드로 조회")
    void findByIdx(){
        // given
        Long idx = 2L;
        ProductDto mockProductDto = ProductDto.of().idx(idx).name("여름 토퍼").description("여름 토퍼 설명").build();
        when(productMapper.findByIdx(idx)).thenReturn(mockProductDto);

        // when
        ProductDto resultProductDto = itemProductService.findByIdx(idx);

        // then
        verify(productMapper).findByIdx(idx);
        assertThat(mockProductDto).isEqualTo(resultProductDto);
        assertThat(mockProductDto.getIdx()).isEqualTo(resultProductDto.getIdx());
        assertThat(mockProductDto.getName()).isEqualTo(resultProductDto.getName());
        assertThat(mockProductDto.getDescription()).isEqualTo(resultProductDto.getDescription());
    }

    @Test
    @DisplayName("Product 테이블 등록")
    void insertProduct(){
        // given
        ProductDto mockProductDto = ProductDto.of().idx(5L).name("상품5").description("상품5").build();
        given(productMapper.insertProduct(mockProductDto)).willReturn(1);

        // when
        int cnt = itemProductService.insertProduct(mockProductDto);

        // then
        verify(productMapper).insertProduct(mockProductDto);
        assertThat(1).isEqualTo(cnt);
    }

    @Test
    @DisplayName("Product 테이블 수정")
    void updateProduct(){
        // given
        ProductDto mockProductDto = ProductDto.of().idx(1L).name("베베숲 물티슈 > 수정").description("베베숲 물티슈 설명 > 수정").build();
        when(productMapper.updateProduct(mockProductDto)).thenReturn(1);

        // when
        int cnt = itemProductService.updateProduct(mockProductDto);

        // then
        verify(productMapper).updateProduct(mockProductDto);
        assertThat(1).isEqualTo(cnt);
    }

    @Test
    @DisplayName("Product 테이블 삭제")
    void deleteProduct(){
        // given
        Long idx = 4L;
        when(productMapper.deleteProduct(idx)).thenReturn(1);

        // when
        int cnt = itemProductService.deleteProduct(idx);

        // then
        verify(productMapper).deleteProduct(idx);
        assertThat(1).isEqualTo(cnt);
    }
}
