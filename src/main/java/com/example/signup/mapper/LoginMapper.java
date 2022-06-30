package com.example.signup.mapper;

import com.example.signup.dto.SignupDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface LoginMapper {
    @Select("Select password from signup where email=#{email}")
    String checkUserByEmail(String email);
}
