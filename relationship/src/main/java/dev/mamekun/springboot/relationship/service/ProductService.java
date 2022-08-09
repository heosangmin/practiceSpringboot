package dev.mamekun.springboot.relationship.service;


import dev.mamekun.springboot.relationship.data.dto.ProductDto;
import dev.mamekun.springboot.relationship.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
