package com.example.signup.controller;

import com.example.signup.dto.InvestType;
import com.example.signup.dto.autoInvestdto;
import com.example.signup.service.impl.AutoInvestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InvestController {

    @Autowired
    AutoInvestImpl autoInvest;


    @PostMapping("wallet")
    public ResponseEntity<?> getwalletbalance(@Valid @RequestBody autoInvestdto dto){
        Map<String,String> response=new HashMap<>();
        int balance=autoInvest.getwalletbalance(dto);
        response.put("wallet","balance");
        return ResponseEntity.status(200).body(balance);
    }
    @PostMapping("typeofInvest")
    public ResponseEntity<?> updateInvestType(@Valid @RequestBody InvestType dto){
        Map<String,String> response=new HashMap<>();
        autoInvest.updateInvestType(dto);
        response.put("updated","successfully");
        return ResponseEntity.status(200).body(response);
    }
}
