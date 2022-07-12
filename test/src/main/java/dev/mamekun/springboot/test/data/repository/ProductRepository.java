package dev.mamekun.springboot.test.data.repository;

import dev.mamekun.springboot.test.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
