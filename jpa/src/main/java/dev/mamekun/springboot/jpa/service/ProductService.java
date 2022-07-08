package dev.mamekun.springboot.jpa.service;

import dev.mamekun.springboot.jpa.data.dto.ProductDto;
import dev.mamekun.springboot.jpa.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
