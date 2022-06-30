package com.example.signup.mapper;

import com.example.signup.dto.ForgetDto;
import com.example.signup.ums.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthMapper {

    @Insert("insert into customer(mobile_number, password,app_language,customer_service_language,whatsapp_alerts,is_active, status_id) " +
            "values(#{customer.mobileNumber}, crypt(#{password}, gen_salt('bf')),#{customer.appLanguage},#{customer.customerLanguage},#{customer.whatsappAlerts},#{customer.isActive}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "customer.customerId", keyColumn = "customer_id")
    void insertCustomerFirst(@Param("customer") Customer customer, @Param("password") String password);

    @Select("select count(1) from customer where mobile_number = #{mobileNumber} AND is_active = 1")
    int getUserCountByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Select("select count(1) from customer where mobile_number = #{mobileNumber} AND is_active = 0")
    int getCustomerInActiveByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Select("select c.app_language, c.customer_service_language,c.customer_id customer_id, c.mobile_number mobile_number, c.is_active from customer c " +
            "where c.mobile_number = #{mobileNumber} and c.password = crypt(#{password}, c.password) and (c.is_active = 1 or c.is_active = -1)")
    Customer getCustomerByMobileNumberAndPassword(@Param("mobileNumber") String mobileNumber,
                                                  @Param("password") String password);

    @Select("select customer_id, mobile_number,password, is_active,app_language,customer_service_language,whatsapp_alerts from customer " +
            "where mobile_number = #{mobileNumber} and (is_active = 1 or is_active = -1)")
    Customer getCustomerByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Select("select * from customer " +
            "where customer_id = #{customerId} and (is_active = 1 or is_active = -1)")
    Customer getCustomerByCustomerId(int customerId);

    @Insert("insert into customer(mobile_number,is_active, status_id) " +
            "values(#{mobileNumber},#{isActive}, 1)")
    int insertCustomer(String mobileNumber, int isActive);

    @Select("select default_value from config " +
            "where " +
            "config_key = #{otpConfigKey}")
    String getConfigValue(String otpConfigKey);

    @Update("update customer set password = crypt(#{password}, gen_salt('bf')),app_language = #{customer.appLanguage},customer_service_language = #{customer.customerServiceLanguage},whatsapp_alerts = #{customer.whatsappAlerts},is_active = #{customer.isActive},updated_timestamp=now() where mobile_number = #{customer.mobileNumber}")
    void updateCustomer(@Param("customer")Customer customer, @Param("password")String password);

    @Update("update customer set is_active = 1,updated_timestamp=now()  where mobile_number = #{mobileNumber}")
    int updateCustomerAsVerified(String mobileNumber);

    @Select({"SELECT * FROM customer WHERE mobile_number = #{mobileNumber} "})
    Customer getUserByMobileNumber(String mobileNumber);

    @Update("update customer set password = crypt(#{password}, password),updated_timestamp=now() where customer_id = #{customerId}")
    int updatePassword(@Param("customerId") int customerId, @Param("password") String password);



    @Select("select password   from customer where customer_id =#{customerId} AND is_active= 1")
    String getCustomerPassword(Integer customerId);

    @Select("select password   from guarantor where guarantor_id =#{guarantorId} AND is_active= 1")
    String getGuarantorPassword(Integer guarantorId);

    @Select("select crypt(#{setPassword},#{changePassword})")
    String password(String setPassword, String changePassword);

    @Select("select * from password where customer_id = #{customerId}")
    List<ForgetDto> getPassword(int customerId);

    @Insert("insert into password (customer_id,password,created_timestamp)values(#{customerId},crypt(#{password}, gen_salt('bf')),now())")
    void addCustomerPassword(int customerId,String password);

    @Insert("insert into password (guarantor_id,password,created_timestamp) values(#{guarantorId},crypt(#{password}, gen_salt('bf')),now())")
    void addGuarantorPassword(int guarantorId, String password);

    @Delete("delete from password where password = #{password}")
    void deletePassword(String password);

    @Select("select * from password where guarantor_id = #{guarantorId}")
    List<ForgetDto> getPasswordGuarantor(int guarantorId);
}
