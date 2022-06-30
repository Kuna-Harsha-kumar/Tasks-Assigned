package com.example.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MyloanDto {

    private String loanAccountNo;
    private String loanAmount;
    private int monthyEmi;
    private String nextDue;
    private int outstandingAmount;

}
