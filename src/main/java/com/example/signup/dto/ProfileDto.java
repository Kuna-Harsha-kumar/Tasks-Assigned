package com.example.signup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ProfileDto {

    @NotNull
    private String proof;
    @NotNull
    private int address;
    @NotNull
    private String resedentialType;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Enter valid email")
    private String email;
}
