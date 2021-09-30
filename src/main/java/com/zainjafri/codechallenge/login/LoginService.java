package com.zainjafri.codechallenge.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean checkIfLoginCredentialsExists(Login login){
        if(loginRepository.existsByLoginEmailAndLoginPassword(login.getLoginEmail(),login.getLoginPassword()))
            return true;
        return false;
    }
}
