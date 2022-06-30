package com.example.signup.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class LoginDto {

    private String Email;
    private String password;
    @JsonIgnore
    private String accesstoken;
    @JsonIgnore
    private String refreshtoken;
}
