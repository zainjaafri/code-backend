package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

//Service Class
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Returns All Products from Database
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //To Register and Add New Product to Database
    public void addProduct(Product product){
        Optional<Product> optionalProduct = productRepository
                .findProductsByProductName(product.getProductName());
        if(optionalProduct.isPresent()){
            throw new IllegalStateException("Product Name Already Present");
        }
        productRepository.save(product);
    }

    //To Delete a Product from Database with corresponding ProductId
    public void deleteProduct(String s) {
        productRepository.deleteById(s);
    }

    //Returns Products of a particular Category from Database
    public List<Product> getProductsOfParticularCategory(String category) {
        return productRepository.findProductByProductCategory(category);
    }

    //To persist the updated changes in the database for already existing product
    @Transactional
    public void updateExistingProduct(String productId, Product product) {
        Product productFromRepository = productRepository.findById(productId)
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exists!");});
        if(product.getProductCategory()!=null && product.getProductCategory()!="")
            productFromRepository.setProductCategory(product.getProductCategory());
        if(product.getProductDesc()!=null && product.getProductDesc()!="")
            productFromRepository.setProductDesc(product.getProductDesc());
        if(product.getProductName()!=null && product.getProductName()!="")
            productFromRepository.setProductName(product.getProductName());
        if(product.getProductUnit()!=null && product.getProductUnit().toString()!="")
            productFromRepository.setProductUnit(product.getProductUnit());
    }

    //Returns Product of corresponding ProductId from Database
    public List<Product> getProductsByProdId(String prodId) {
        return productRepository.findProductByProductId(prodId);
    }
}
