package com.example.signup.ums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class Customer {

    @JsonIgnore
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String fatherName;
    @JsonIgnore
    private String mobileNumber;
    private Integer customerServiceLanguage;
    private Integer appLanguage;
    private Integer isActive;
    private Integer gender;
    @JsonIgnore
    private String password;
    private Integer whatsappAlerts;
    private Integer loanPurpose;
    private Integer educationalQualification;
    private Integer maritalStatus;
    private Integer dependents;
    private Integer vehicleOwned;
    private String permanentAddress;
    private Integer residentialType;
    private Integer paPincode;
    private String paCity;
    private Integer paState;
    private Integer paCountry;
    private Integer permanantIsCurrentAddress;
    private String currentAddress;
    private Integer caPincode;
    private String caCity;
    private Integer caState;
    private Integer caCountry;
    private String aadhaarNumber;
    private String panNumber;
    private String emailid;
    private LocalDateTime currentAddressProofDate;
    private Integer loanCount;
    private Integer guarantorLinkCount;
    private Integer creditScore;

    private Integer requiredLoanAmount;

    private Integer permanentAddressType;
    private Integer currentAddressType;
    @JsonIgnore
    private Date salaryCreditDate;
    private Integer maxLoanWoGuarantor;
    private Integer customerMaxLoanAmount;

    private String dateOfBirth;

    private Integer guarantorStatus;

    private Integer currentGrossSalary;

}
