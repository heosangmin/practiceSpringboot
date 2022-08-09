package dev.mamekun.springboot.relationship.data.dao.impl;

import dev.mamekun.springboot.relationship.data.dao.ProductDAO;
import dev.mamekun.springboot.relationship.data.entity.Product;
import dev.mamekun.springboot.relationship.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);
        // getById()는 내부적으로 EntityManager의 getReference() 메서드를 호출한다.
        // getReference() 메서드를 호출하면 프락시 객체를 리턴한다.
        // 실제 프락시 객체를 통해 최초로 데이터에 접근하는 시점에 실행된다.

        // findById()는 내부적으로 EntityManager의 find() 메서드를 호출한다.
        // 이 메서드는 영속성 컨텍스트의 캐시에서 값을 조회한 후 영속성 컨텍스트에 값이 존재하지 않는다면
        // 제 데이터베이스에서 데이터를 조회한다. 리턴 값으로 Optional 객체를 전달한다.

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
