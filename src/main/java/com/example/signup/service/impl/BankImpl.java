package com.example.signup.service.impl;

import com.example.signup.dto.BankDto;
import com.example.signup.mapper.ProfileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class BankImpl {

    @Autowired
    ProfileMapper mapper;

    public void bankdetails(BankDto dto){
        dto.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        mapper.bank(dto);
    }
}
