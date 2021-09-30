package com.zainjafri.codechallenge.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

//Adding this @ExtendWith(MockitoExtension.class) annotation reduces the below first three commented lines of code.
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;
    //1-//private AutoCloseable autoCloseable;
    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        //2-//autoCloseable =MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    //3
    /*@AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    //Testing Delete Product Service Method
    @Test
    @Disabled
    void deleteProduct() {
        //when
        productService.deleteProduct("P01");
        //then
        verify(productRepository);
    }

    @Test
    void getProductsByProdIdTest(){
        String prodIdTest = "P01";
        Product product = new Product("Commercial","A350","LHA",1);
        productRepository.save(product);
        List<Product> product1 = productService.getProductsByProdId(product.getProductId());
        //System.out.println(productRepository.save(new Product("Commercial","A350","LHA",1)));
        System.out.println(product1.toString());
        Assertions.assertThat(product1.toString()).isEqualTo(product.getProductId());
    }
}