package dev.mamekun.springboot.valid_exception.service.impl;

import dev.mamekun.springboot.valid_exception.data.dto.ProductDto;
import dev.mamekun.springboot.valid_exception.service.ProductService;
import dev.mamekun.springboot.valid_exception.data.dto.ProductResponseDto;
import dev.mamekun.springboot.valid_exception.data.entity.Product;
import dev.mamekun.springboot.valid_exception.data.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        LOGGER.info("[getProduct] input number : {}", number);
        Product product = productRepository.findById(number).get();

        ProductResponseDto productResponseDto = new ProductResponseDto(
                product.getNumber(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        LOGGER.info("[saveProduct] productDTO : {}", productDto.toString());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] saveProduct : {}", savedProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                savedProduct.getNumber(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getStock()
        );

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                changedProduct.getNumber(),
                changedProduct.getName(),
                changedProduct.getPrice(),
                changedProduct.getStock()
        );

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
