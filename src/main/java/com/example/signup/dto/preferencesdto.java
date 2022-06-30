package com.example.signup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class preferencesdto {

    @NotNull
    private String type;

    @NotNull
    private int risk;

    @NotNull
    private int amount;

    @NotNull
    private String mobile_number;
}
