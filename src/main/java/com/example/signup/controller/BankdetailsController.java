package com.example.signup.controller;

import com.example.signup.dto.BankDto;
import com.example.signup.service.impl.BankImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankdetailsController {

    @Autowired
    BankImpl service;

    @PostMapping("bankdetails")
    public ResponseEntity<?> bankdetails(@Valid @RequestBody BankDto dto){
        Map<String,String> response = new HashMap<>();
        service.bankdetails(dto);
        response.put("added","successfully");
        return ResponseEntity.status(200).body(response);
    }
}
