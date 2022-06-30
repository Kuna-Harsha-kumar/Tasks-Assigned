package com.example.signup.mapper;


import com.example.signup.dto.EmailValidationDto;
import com.example.signup.dto.SignupDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Optional;

@Mapper
public interface SignupMapper {

    @Insert("insert into login (email_id,otp,expires_on,created_at,updated_at)" +
            "values (#{emailId},#{otp},#{expiresOn},#{createdAt},#{updatedAt})")
    void verifyEmail(EmailValidationDto dto);

    @Select("Select * from login where email_id=#{email}")
    Optional<EmailValidationDto> getUserByEmail(String email);


    @Insert("Insert into signup (name,email,mobile_no,password,created_at,updated_at,is_active,wallet_balance,applanguage,customerserviceLanguage)" +
            "values (#{name},#{email},#{mobileNo},#{password},#{createdAt},#{updatedAt},#{isActive},#{walletBalance},#{appLanguage},#{customerserviceLanguage})")
    void addUser(SignupDto dto);

    @Select("Select email,password from signup where email=#{email}")
    Optional<SignupDto> checkUserByEmail(String email);

    @Update("update login set otp=#{dto.otp},expires_on=#{expiresOn},updated_at=#{updatedAt} where email_id=#{dto.emailId}")
    void updateOtp(EmailValidationDto dto);

}
