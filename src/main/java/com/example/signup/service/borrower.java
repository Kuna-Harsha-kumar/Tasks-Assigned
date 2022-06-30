package com.example.signup.service;

import com.example.signup.dto.MyloanDto;
import com.example.signup.dto.borrowedto;

import java.util.List;

public interface borrower {

     List<borrowedto> borrowerdetails();

     List<MyloanDto> loan_details(MyloanDto dto);
}
