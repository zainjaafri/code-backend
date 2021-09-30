package com.zainjafri.codechallenge.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    boolean existsByLoginEmailAndLoginPassword(String Email, String Password);
}
