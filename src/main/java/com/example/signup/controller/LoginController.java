package com.example.signup.controller;

import com.example.signup.dto.LoginDto;
import com.example.signup.mapper.LoginMapper;
import com.example.signup.service.LoginService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    @Autowired
    LoginMapper mapper;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto dto) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String password = dto.getPassword();
        Map<String, String> response = new HashMap<>();
        String Originalpassword = mapper.checkUserByEmail(dto.getEmail());
        if (b.matches(password, Originalpassword)) ;
        {
            response.put("status", "success");
            response.put("Login", "successfully");
        }
        return ResponseEntity.status(200).body(response);
    }

}


