package dev.mamekun.springboot.security.data.repository;

import dev.mamekun.springboot.security.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
