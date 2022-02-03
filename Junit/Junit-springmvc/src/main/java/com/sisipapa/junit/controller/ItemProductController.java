package com.sisipapa.junit.controller;

import com.sisipapa.junit.domain.Item;
import com.sisipapa.junit.domain.dto.ProductDto;
import com.sisipapa.junit.service.ItemProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    ResponseEntity<?> itemSave() throws Exception {
        List<ProductDto> products = itemProductService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
