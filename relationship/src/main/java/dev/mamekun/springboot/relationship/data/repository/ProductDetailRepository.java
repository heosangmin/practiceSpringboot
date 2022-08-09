package dev.mamekun.springboot.relationship.data.repository;

import dev.mamekun.springboot.relationship.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

}
