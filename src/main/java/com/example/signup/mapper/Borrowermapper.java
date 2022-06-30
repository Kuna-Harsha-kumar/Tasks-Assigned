package com.example.signup.mapper;

import com.example.signup.dto.MyloanDto;
import com.example.signup.dto.borrowedto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface Borrowermapper {

    @Select("select * from borrower")
    List<borrowedto> getBorrowerdetails();

    @Select("select * from loan where loan_account_no=#{account_number}")
    List<MyloanDto> getloan(@Param("account_number") @Valid String account_number);

}