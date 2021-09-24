package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "/{productCategory}")
    public List<Product> getProductsOfParticularCategory(@PathVariable("productCategory") String category){
        return productService.getProductsOfParticularCategory(category);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        //System.out.println(product);
        productService.addProduct(product);
    }

    @PutMapping(path = "/{productId}")
    public void updateExistingProduct(@PathVariable("productId") String productId,
                                      @RequestParam(required = false) String productCategory,
                                      @RequestParam(required = false) String productDesc,
                                      @RequestParam(required = false) String productName,
                                      @RequestParam(required = false) Integer productUnit){
        productService.updateExistingProduct(productId, productCategory, productDesc, productName, productUnit);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") String prodId){
        productService.deleteProduct(prodId);
    }
}
