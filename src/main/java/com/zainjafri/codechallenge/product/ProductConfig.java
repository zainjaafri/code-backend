package com.zainjafri.codechallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//Product Configuration Class
@Configuration
public class ProductConfig {
    private final ProductRepository productRepository;

    @Autowired
    public ProductConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //You can uncomment this when you start the application for very first time with empty database, inorder to populate the values in the database.
    //Make sure to comment this after first run on database, or else values will be repopulated with different set of ProductIds.
    @Bean
    CommandLineRunner commandLineRunnerForProduct(ProductRepository productRepository){
        return args -> {
            /*
            Product one = new Product("Commercial","A320","Passenger aircraft family",2);
            Product two = new Product("Commercial","A380","Passenger aircraft family",3);
            Product three = new Product("Space","Sentinel","Satellite family",1);
            Product four = new Product("Helicopter","H135","Light twin",2);
            Product five = new Product("Helicopter","H125","Intermediate single",3);

            productRepository.saveAll(List.of(one,two,three,four,five));
            */
        };

    }
}
