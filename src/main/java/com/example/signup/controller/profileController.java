package com.example.signup.controller;

import com.example.signup.dto.CustomerDetailsDto;
import com.example.signup.dto.ProfileDto;
import com.example.signup.dto.employmentDto;
import com.example.signup.service.impl.Profilempl;
import com.example.signup.ums.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class profileController {

    @Autowired
    Profilempl service;

    @PostMapping("/profile")
    public ResponseEntity<?> profile(@Valid @RequestBody ProfileDto dto){
        Map<String,String> response=new HashMap<>();
        service.proof(dto);
        response.put("Success","added");
        return ResponseEntity.status(200).body(response);
    }
    @PostMapping("/employment")
    public ResponseEntity<?> employment(@Valid @RequestBody employmentDto dto){
        Map<String,String> response=new HashMap<>();
        service.employment(dto);
        response.put("Success","added");
        return ResponseEntity.status(200).body(response);
    }
    @PostMapping("/customer-details")
    public ResponseEntity<?> customer_details(@Valid @RequestBody CustomerDetailsDto dto){
        Map<String,String> response=new HashMap<>();
        service.customer_details(dto);
        response.put("Success","added");
        return ResponseEntity.status(200).body(response);
    }
}
