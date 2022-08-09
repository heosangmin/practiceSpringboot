package dev.mamekun.springboot.relationship.data.repository.support;

import dev.mamekun.springboot.relationship.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
