package com.zainjafri.codechallenge.product;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Product {
    /*@SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )*/
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "product_sequence"
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @GenericGenerator(
            name = "product_sequence",
            strategy = "com.zainjafri.codechallenge.product.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1")
            })
    private String ProductId;
    private String ProductCategory;
    private String ProductName;
    private String ProductDesc;
    private Integer ProductUnit;

    public Product() {
    }

    /*public Product(String productId, String productCategory, String productName, String productDesc, Integer productUnit) {
        ProductId = productId;
        ProductCategory = productCategory;
        ProductName = productName;
        ProductDesc = productDesc;
        ProductUnit = productUnit;
    }*/

    public Product(String productCategory, String productName, String productDesc, Integer productUnit) {
        ProductCategory = productCategory;
        ProductName = productName;
        ProductDesc = productDesc;
        ProductUnit = productUnit;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String productDesc) {
        ProductDesc = productDesc;
    }

    public Integer getProductUnit() {
        return ProductUnit;
    }

    public void setProductUnit(Integer productUnit) {
        ProductUnit = productUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductCategory='" + ProductCategory + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDesc='" + ProductDesc + '\'' +
                ", ProductUnit=" + ProductUnit +
                '}';
    }
}
