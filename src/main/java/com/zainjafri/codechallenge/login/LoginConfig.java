package com.zainjafri.codechallenge.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoginConfig {
    private LoginRepository loginRepository;

    @Autowired
    public LoginConfig(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /*@Bean
    CommandLineRunner commandLineRunnerForLogin(LoginRepository loginRepository){
        return args -> {
            Login one = new Login("zainjafri19@gmail.com","gmailPass");
            Login two = new Login("zainjafri91@yahoo.com","yahooPass");

            loginRepository.saveAll(List.of(one,two));
        };

    }*/
}
