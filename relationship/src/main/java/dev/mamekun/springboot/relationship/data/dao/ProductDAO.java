package dev.mamekun.springboot.relationship.data.dao;

import dev.mamekun.springboot.relationship.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
