package dev.mamekun.springboot.advanced_jpa.data.repository.support;

import dev.mamekun.springboot.advanced_jpa.data.entity.Product;
import dev.mamekun.springboot.advanced_jpa.data.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct product = QProduct.product;

        List<Product> productList = from(product)
                .where(product.name.eq(name))
                .select(product)
                .fetch();

        return productList;
    }
}
