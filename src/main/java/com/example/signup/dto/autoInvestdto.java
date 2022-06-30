package com.example.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class autoInvestdto {

    @NotNull
    private String mobile_no;
    @JsonIgnore
    private int cust_id;
    @JsonIgnore
    private String cust_name;
    @JsonIgnore
    private int wallet_balance;
}
