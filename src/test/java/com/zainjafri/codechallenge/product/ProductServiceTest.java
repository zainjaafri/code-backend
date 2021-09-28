package com.zainjafri.codechallenge.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

//Adding this @ExtendWith(MockitoExtension.class) annotation reduces the below first three commented lines of code.
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock private ProductRepository productRepository;
    //1-//private AutoCloseable autoCloseable;
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
    void deleteProduct() {
        //when
        productService.deleteProduct("P01");
        //then
        verify(productRepository);
    }
}