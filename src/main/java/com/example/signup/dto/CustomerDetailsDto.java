package com.example.signup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerDetailsDto {

    @NotNull
    private String proof;
    @NotNull
    private int address;
    @NotNull
    private String currentAddress;
}
