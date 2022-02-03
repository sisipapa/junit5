package com.sisipapa.junit.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class ProductDto {
    private Long idx;
    private String name;
    private String description;

    public ProductDto(String name, String description){
        this.name = name;
        this.description = description;
    }
}
