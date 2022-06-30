package com.example.signup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BankDto {

    @NotNull
    public String UserName;
    @NotNull
    public String bankName;
    @NotNull
    public String password;
}
