package com.zainjafri.codechallenge.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

//Data Access or Repository Interface
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    //Finds and returns Products by Product Name
    @Query("SELECT p FROM Product p WHERE p.ProductName = ?1")
    Optional<Product> findProductsByProductName(String productName);

    //Finds and returns Products by Product Category
    @Query("SELECT p FROM Product p WHERE p.ProductCategory = ?1")
    List<Product> findProductByProductCategory(String category);

    //Finds and returns Products by ProductId
    @Query("SELECT p FROM Product p WHERE p.ProductId = ?1")
    List<Product> findProductByProductId(String prodId);
}
