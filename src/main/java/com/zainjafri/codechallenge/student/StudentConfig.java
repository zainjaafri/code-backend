package com.zainjafri.codechallenge.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student shafi = new Student("ShafiJafri");
            Student yesa = new Student("YesaJafri");

            studentRepository.saveAll(List.of(shafi,yesa));
        };

    }

}
