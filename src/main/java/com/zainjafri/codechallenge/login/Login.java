package com.zainjafri.codechallenge.login;

import javax.persistence.*;

@Entity
@Table
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer loginId;
    private String loginEmail;
    private String loginPassword;

    public Login() {
    }

    public Login(String loginEmail, String loginPassword) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
