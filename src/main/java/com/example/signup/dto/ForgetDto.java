package com.example.signup.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ForgetDto {
    private int passwordId;
    private int customerId;
    private String password;
    private Date createdTimestamp;
}
