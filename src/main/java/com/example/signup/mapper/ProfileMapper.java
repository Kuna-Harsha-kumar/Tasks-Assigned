package com.example.signup.mapper;

import com.example.signup.dto.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface ProfileMapper {

    @Insert("insert into profile (proof,address,resedential_type,email)" +
            "values(#{proof},#{address},#{resedentialType},#{email})")
    void profile(ProfileDto dto);

    @Insert("insert into employment (industry_type,companyname,address,country,state,city,pincode,currentexperience_years,currentexperience_months,overallexperience_years,overallexperience_months)" +
            "values(#{industryType},#{companyname},#{address},#{country},#{state},#{city},#{pincode},#{currentexperienceYears},#{currentexperienceMonths},#{overallexperienceYears},#{overallexperienceMonths})")
    void emaployee(employmentDto dto);

    @Insert("insert into bank (bank_name,user_name,password)" +
            "values(#{bankname},#{username},#{password})")
    void bank(BankDto dto);

    @Insert("insert into current_address (proof,address,current_address)" +
            "values(#{proof},#{address},#{currentAddress})")
    void customer_details(CustomerDetailsDto dto);

}