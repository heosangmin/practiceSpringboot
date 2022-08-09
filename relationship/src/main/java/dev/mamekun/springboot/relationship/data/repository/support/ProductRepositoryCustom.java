package dev.mamekun.springboot.relationship.data.repository.support;

import dev.mamekun.springboot.relationship.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);
}
