package com.zainjafri.codechallenge.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    //SELECT * FROM PRODUCT WHERE PRODUCT_CATEGORY = ?
    @Query("SELECT p FROM Product p WHERE p.ProductName = ?1")
    Optional<Product> findProductsByProductName(String productName);

    @Query("SELECT p FROM Product p WHERE p.ProductCategory = ?1")
    List<Product> findProductByProductCategory(String category);
}
