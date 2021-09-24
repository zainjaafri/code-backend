package com.zainjafri.codechallenge.product;

import com.zainjafri.codechallenge.student.Student;
import com.zainjafri.codechallenge.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    private final ProductRepository productRepository;

    @Autowired
    public ProductConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    CommandLineRunner commandLineRunnerForProduct(ProductRepository productRepository){
        return args -> {
            /*Product one = new Product("Commercial","A320","Passenger aircraft family",2);
            Product two = new Product("Commercial","A380","Passenger aircraft family",3);

            productRepository.saveAll(List.of(one,two));*/
        };

    }
}
