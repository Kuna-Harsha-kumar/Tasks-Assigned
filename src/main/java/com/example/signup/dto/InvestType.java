package com.example.signup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InvestType {

    @NotNull
    private String mobile_number;
    @NotNull
    private int investType;
}
