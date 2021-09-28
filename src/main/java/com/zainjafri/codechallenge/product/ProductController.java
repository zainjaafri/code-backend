package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "/prodId/{productId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProductsByProdId(@PathVariable("productId") String prodId){
        return productService.getProductsByProdId(prodId);
    }

    @GetMapping(path = "/{productCategory}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProductsOfParticularCategory(@PathVariable("productCategory") String category){
        if(productService.getProductsOfParticularCategory(category).isEmpty())
                throw new MyResourceNotFoundException("Not Found");
        return productService.getProductsOfParticularCategory(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        //System.out.println(product);
        productService.addProduct(product);
    }

    /*@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{productId}")
    public void updateExistingProduct(@PathVariable("productId") String productId,
                                      @RequestParam(required = false) String productCategory,
                                      @RequestParam(required = false) String productDesc,
                                      @RequestParam(required = false) String productName,
                                      @RequestParam(required = false) Integer productUnit){
        productService.updateExistingProduct(productId, productCategory, productDesc, productName, productUnit);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{productId}")
    public void updateExistingProduct(@PathVariable("productId") String productId, @RequestBody Product product){
        productService.updateExistingProduct(productId, product);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") String prodId){
        productService.deleteProduct(prodId);
    }
}
