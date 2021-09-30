package com.zainjafri.codechallenge.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path = "/login")
    public boolean checkIfLoginCredentialsExists(@RequestBody Login login){
        if(loginService.checkIfLoginCredentialsExists(login))
            return true;
        return false;
    }
}
