package dev.mamekun.springboot.jpa.service.impl;

import dev.mamekun.springboot.jpa.data.dao.ProductDAO;
import dev.mamekun.springboot.jpa.data.dto.ProductDto;
import dev.mamekun.springboot.jpa.data.dto.ProductResponseDto;
import dev.mamekun.springboot.jpa.data.entity.Product;
import dev.mamekun.springboot.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .number(product.getNumber())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .number(savedProduct.getNumber())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .stock(savedProduct.getStock())
                .build();

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .number(changedProduct.getNumber())
                .name(changedProduct.getName())
                .price(changedProduct.getPrice())
                .stock(changedProduct.getStock())
                .build();

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
