package com.example.signup.service.impl;

import com.example.signup.dto.MyloanDto;
import com.example.signup.dto.borrowedto;
import com.example.signup.mapper.Borrowermapper;
import com.example.signup.service.borrower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class borroweImpl  implements borrower {

    @Autowired
    Borrowermapper mapper;

    @Override
    public List<borrowedto> borrowerdetails(){
        List<borrowedto> details=mapper.getBorrowerdetails();
        return details;
    }

    @Override
    public List<MyloanDto> loan_details(MyloanDto dto) {
        String account_number = dto.getLoanAccountNo();
        List<MyloanDto> loan_details=mapper.getloan(account_number);
        return loan_details;
    }
}
