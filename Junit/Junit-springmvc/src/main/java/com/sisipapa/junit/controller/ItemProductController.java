package com.sisipapa.junit.controller;

import com.sisipapa.junit.domain.Item;
import com.sisipapa.junit.domain.dto.ProductDto;
import com.sisipapa.junit.service.ItemProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ItemProductController {

    private final ItemProductService itemProductService;

    @PostMapping("/api/v1/item")
    ResponseEntity<?> itemSave(@RequestBody Item item) throws Exception {
        itemProductService.itemSave(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/products")
    ResponseEntity<?> findAll() throws Exception {
        List<ProductDto> products = itemProductService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/api/v1/products/{idx}")
    ResponseEntity<?> findByIdx(@PathVariable Long idx) throws Exception {
        ProductDto product = itemProductService.findByIdx(idx);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/api/v1/products")
    ResponseEntity<?> insertProduct(@RequestBody ProductDto productDto) throws Exception {
        int resultCount = itemProductService.insertProduct(productDto);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("resultCount", resultCount);
        return new ResponseEntity<>(resultMap, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/products")
    ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto) throws Exception {
        int resultCount = itemProductService.updateProduct(productDto);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("resultCount", resultCount);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/products/{idx}")
    ResponseEntity<?> deleteProduct(@PathVariable Long idx) throws Exception {
        int resultCount = itemProductService.deleteProduct(idx);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("resultCount", resultCount);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
