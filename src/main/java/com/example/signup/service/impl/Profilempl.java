package com.example.signup.service.impl;

import com.example.signup.dto.CustomerDetailsDto;
import com.example.signup.dto.ProfileDto;
import com.example.signup.dto.employmentDto;
import com.example.signup.mapper.ProfileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
@Slf4j
public class Profilempl {

    @Autowired
    ProfileMapper mapper;

    public void proof(ProfileDto dto) {
        if (dto.getProof() == "Aadhaar Card") {
            if(dto.getAddress()==1) {
                mapper.profile(dto);
            }
            }
    }
    public void employment(employmentDto dto){
        mapper.emaployee(dto);
    }
    public void customer_details(CustomerDetailsDto dto){
        mapper.customer_details(dto);
    }
}
