package dev.mamekun.springboot.security.service;

import dev.mamekun.springboot.security.data.dto.ProductDto;
import dev.mamekun.springboot.security.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
