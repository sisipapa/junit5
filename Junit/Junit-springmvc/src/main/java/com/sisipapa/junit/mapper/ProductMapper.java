package com.sisipapa.junit.mapper;

import com.sisipapa.junit.domain.dto.ProductDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT idx" +
            "             ,name\n" +
            "             ,description\n" +
            "        FROM product")
    List<ProductDto> findAll();

    @Select("SELECT idx\n" +
            "             ,name\n" +
            "             ,description\n" +
            "        FROM product\n" +
            "        WHERE name = #{name}")
    ProductDto findByName(String name);

    @Select("SELECT idx\n" +
            "             ,name\n" +
            "             ,description\n" +
            "        FROM product\n" +
            "        WHERE idx = #{idx}")
    ProductDto findByIdx(long l);

    @Insert("INSERT INTO product (name, description)\n" +
            "        VALUES (#{name}, #{description})")
    int insertProduct(ProductDto product);

    @Update("UPDATE product SET\n" +
            "            name = #{name}\n" +
            "           ,description = #{description}\n" +
            "        WHERE idx = #{idx}")
    int updateProduct(ProductDto product);

    @Delete("DELETE FROM item WHERE id = #{id}")
    int deleteProduct(Long id);
}
