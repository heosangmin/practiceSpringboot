package dev.mamekun.springboot.jpa.data.repository;

import dev.mamekun.springboot.jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
