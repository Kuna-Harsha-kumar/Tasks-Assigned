package com.example.signup.service;

import com.example.signup.dto.LoginDto;
import com.example.signup.dto.SignupDto;
import org.springframework.stereotype.Service;


public interface LoginService {


    void isValid(LoginDto dto);
}
