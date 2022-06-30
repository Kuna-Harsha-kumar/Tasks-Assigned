package com.example.signup.ums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {

    private Integer id;
    private String uid;

    @JsonIgnore
    private Integer role;
    private String roleName;
    private String mobileNumber;
    private Integer customerId;

    @JsonIgnore
    private int status;
}
