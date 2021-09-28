package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Controller Class
@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //To Get All Products from Database
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //To Get Product of corresponding ProductId from Database
    @GetMapping(path = "/prodId/{productId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProductsByProdId(@PathVariable("productId") String prodId){
        return productService.getProductsByProdId(prodId);
    }

    //To Get Products of a particular Category from Database
    @GetMapping(path = "/{productCategory}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProductsOfParticularCategory(@PathVariable("productCategory") String category){
        if(productService.getProductsOfParticularCategory(category).isEmpty())
                throw new MyResourceNotFoundException("Not Found");
        return productService.getProductsOfParticularCategory(category);
    }

    //To Register and Add New Product to Database
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    //To Update an Already Existing Product to Database with corresponding ProductId
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{productId}")
    public void updateExistingProduct(@PathVariable("productId") String productId, @RequestBody Product product){
        productService.updateExistingProduct(productId, product);
    }

    //To Delete a Product from Database with corresponding ProductId
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") String prodId){
        productService.deleteProduct(prodId);
    }
}
