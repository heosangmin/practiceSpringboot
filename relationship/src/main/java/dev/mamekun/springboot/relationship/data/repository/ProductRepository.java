package dev.mamekun.springboot.relationship.data.repository;

import dev.mamekun.springboot.relationship.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // find..By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);
    List<Product> findByName(String name, Sort sort);
    Page<Product> findByName(String name, Pageable pageable);

    // 파라미터를 순서대로 받기 ?1, ?2...
    @Query("select p from Product as p where p.name = ?1")
    List<Product> findByName(String name);

    // @Query, @Param 어노테이션 사용
    @Query("select p from Product as p where p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    // 특정 칼럼만 추출하는 쿼리
    @Query("select p.name, p.price, p.stock From Product p where p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);

}
