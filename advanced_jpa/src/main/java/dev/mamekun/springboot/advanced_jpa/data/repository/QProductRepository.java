package dev.mamekun.springboot.advanced_jpa.data.repository;

import dev.mamekun.springboot.advanced_jpa.data.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {

}
