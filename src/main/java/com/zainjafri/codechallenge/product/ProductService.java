package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        Optional<Product> optionalProduct = productRepository
                .findProductsByProductName(product.getProductName());
        if(optionalProduct.isPresent()){
            throw new IllegalStateException("Product Name Already Present");
        }
        productRepository.save(product);
        //System.out.println(product);
    }

    public void deleteProduct(String s) {
        productRepository.deleteById(s);
    }

    public List<Product> getProductsOfParticularCategory(String category) {
        return productRepository.findProductByProductCategory(category);
    }
    @Transactional
    public void updateExistingProduct(String productId,String productCategory,String productDesc,String productName,Integer productUnit) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("product not exist"));
        if(productCategory!=null)
            product.setProductCategory(productCategory);
        if(productDesc!=null)
            product.setProductDesc(productDesc);
        if(productName!=null)
            product.setProductName(productName);
        if(productUnit!=null)
            product.setProductUnit(productUnit);
    }
}
