package dev.mamekun.springboot.test.service;

import dev.mamekun.springboot.test.data.dto.ProductDto;
import dev.mamekun.springboot.test.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
