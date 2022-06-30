package com.example.signup.controller;

import com.example.signup.dto.MyloanDto;
import com.example.signup.dto.autoInvestdto;
import com.example.signup.dto.borrowedto;
import com.example.signup.dto.employmentDto;
import com.example.signup.service.borrower;
import com.example.signup.service.impl.AutoInvestImpl;
import com.example.signup.service.impl.Profilempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class borrowerController {

    @Autowired
    borrower borrower;

    @Autowired
    AutoInvestImpl autoInvest;

    @Autowired
    Profilempl service;

    @PostMapping("/getwalletbalance1")
    public ResponseEntity<?> walletbalance1(@Valid @RequestBody autoInvestdto dto) {
        Map<String, String> response = new HashMap<>();
        int wallet_balance=autoInvest.getwalletbalance(dto);
        return ResponseEntity.status(200).body(wallet_balance);
    }

    @GetMapping("/getBorrwerDetails")
    public ResponseEntity<?> borrowerdetails() {
        Map<String, String> response = new HashMap<>();
        List<borrowedto> details=borrower.borrowerdetails();
        response.put("status", "success");
        response.put("borrower", "details");
        return ResponseEntity.status(200).body(details);
    }
    @PostMapping("/getloandetails")
    public ResponseEntity<?> loandetails(@Valid @RequestBody MyloanDto dto){
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("loan", "details");
        return ResponseEntity.status(200).body(borrower.loan_details(dto));
    }
}
