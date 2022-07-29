package dev.mamekun.springboot.test.data.repository;

import dev.mamekun.springboot.test.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void basicCRUDTest() {
        /* create */
        // given
        Product givenProduct = Product.builder()
                .name("노트")
                .price(1000)
                .stock(500)
                .build();

        // when
        Product savedProduct = productRepository.save(givenProduct);

        // then
        Assertions.assertEquals(savedProduct.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(savedProduct.getName(), givenProduct.getName());
        Assertions.assertEquals(savedProduct.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(savedProduct.getStock(), givenProduct.getStock());

        /* read */
        // when
        Product selectedProduct = productRepository.findById(savedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        // then
        Assertions.assertEquals(selectedProduct.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(selectedProduct.getName(), givenProduct.getName());
        Assertions.assertEquals(selectedProduct.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(selectedProduct.getStock(), givenProduct.getStock());

        /* update */
        // when
        Product foundProduct = productRepository.findById(selectedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        foundProduct.setName("toy");

        Product updatedProduct = productRepository.save(foundProduct);

        // then
        Assertions.assertEquals(updatedProduct.getName(), "toy");

        /* delete */
        // when
        productRepository.delete(updatedProduct);

        // then
        Assertions.assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());
    }
}
