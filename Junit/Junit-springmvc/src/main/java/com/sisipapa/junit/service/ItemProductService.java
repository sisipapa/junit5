package com.sisipapa.junit.service;

import com.sisipapa.junit.domain.Item;
import com.sisipapa.junit.domain.dto.ProductDto;
import com.sisipapa.junit.mapper.ProductMapper;
import com.sisipapa.junit.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemProductService {

    private final ItemRepository itemRepository;
    private final ProductMapper productMapper;

    public Item itemSave(Item item){
        return itemRepository.save(item);
    }

    public List<ProductDto> findAll() {
        return productMapper.findAll();
    }

    public ProductDto findByName(String name) {
        return productMapper.findByName(name);
    }

    public ProductDto findByIdx(Long idx) {
        return productMapper.findByIdx(idx);
    }

    public int insertProduct(ProductDto productDto) {
        return productMapper.insertProduct(productDto);
    }

    public int updateProduct(ProductDto productDto) {
        return productMapper.updateProduct(productDto);
    }

    public int deleteProduct(Long idx) {
        return productMapper.deleteProduct(idx);
    }
}
