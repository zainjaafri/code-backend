package com.zainjafri.codechallenge.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepositoryTest;

    @Test
    void saveProduct(){
        Product product = new Product("Commercial","A350","LHA",1);
        productRepositoryTest.save(product);
        System.out.println(product.getProductId());
        Assertions.assertThat(product.getProductId()).isNotEmpty();
    }

    @Test
    void findProductByProductCategory() {
        Product product = new Product("Commercial","A350","LHA",1);
        productRepositoryTest.save(product);
        System.out.println(product.getProductId());
        Assertions.assertThat(product.getProductId()).isNotEmpty();
    }
}