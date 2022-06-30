package com.example.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class employmentDto {
     private int cust_id;
     @JsonIgnore
     private String industryType;
     @JsonIgnore

     private String companyname;
     @JsonIgnore
     private String address;

     @JsonIgnore
     private String country;

     @JsonIgnore
     private String state;

     @JsonIgnore
     private String city;

     @JsonIgnore
     private int pincode;

     @JsonIgnore
     private int currentexperienceYears;

     @JsonIgnore
     private int currentexperienceMonths;

     @JsonIgnore
     private int overallexperienceYears;

     @JsonIgnore
     private int overallexperienceMonths;
}
