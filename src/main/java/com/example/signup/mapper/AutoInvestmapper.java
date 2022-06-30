package com.example.signup.mapper;

import com.example.signup.dto.autoInvestdto;
import com.example.signup.ums.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

@Mapper
@Repository
public interface AutoInvestmapper {

    @Select("select wallet_balance from customer_details where mobile_number=#{mobile_number}")
    int getwalletbalance(@Param("mobile_number") @Valid String mobile_number);

    @Update("update customer_details set risk = #{risk},amount = #{amount},type = #{type} where mobile_number = #{mobile_number}")
    void updateCustomer(@Param("risk") int risk, @Param("amount")int  amount,@Param("type")String type,@Param("mobile_number")String mobile_number);

    @Update("update customer_details set isaccepted=#{isaccepted} where mobile_number = #{mobile_number}")
    void updatetermsandcontions(@Param("isaccepted") int isaccepted,@Param("mobile_number") String mobile_number);

    @Update("update customer_details set investType=#{investType} where mobile_number=#{mobile_number}")
    void updateinvestType(@Param("investType") int investType,@Param("mobile_number") String mobile_number);


}
