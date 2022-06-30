package com.example.signup.controller;

import com.example.signup.dto.InvestType;
import com.example.signup.dto.autoInvestdto;
import com.example.signup.dto.preferencesdto;
import com.example.signup.dto.termsCondtionsdto;
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
public class autoinvestcontroller {

    @Autowired
    AutoInvestImpl autoInvest;

    @PostMapping("/getwalletbalance")
    public ResponseEntity<?> walletbalance(@Valid @RequestBody autoInvestdto dto) {
        Map<String, String> response = new HashMap<>();
        int wallet_balance=autoInvest.getwalletbalance(dto);
        response.put("status", "success");
        response.put("wallet", "balance");
        return ResponseEntity.status(200).body(wallet_balance);
    }
    @PostMapping("/updatepreferences")
    public ResponseEntity<?> updatepreferences(@Valid @RequestBody preferencesdto dto) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("preferences", "updated");
        autoInvest.updatepreference(dto);
        return ResponseEntity.status(200).body(response);
    }
    @PostMapping("isaccepted")
    public ResponseEntity<?> updatedtermsandcondtions(@Valid @RequestBody termsCondtionsdto dto){
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("preferences", "updated");
        autoInvest.updatetermsandcondtions(dto);
        return ResponseEntity.status(200).body(response);
    }

}
