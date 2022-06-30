package com.example.signup.mapper;

import com.example.signup.ums.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into users(mobile_number, password, uid, role, customer_id, status) " +
            "values(#{user.mobileNumber}, crypt(#{password}, gen_salt('bf')), #{user.uid}, #{user.role}, #{user.customerId}, #{user.status})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    int insertUser(@Param("user") User user, @Param("password") String password);

    @Update("update users set status = 0,updated_timestamp=now() where uid = #{uid}")
    int deleteUser(@Param("uid") String uid);

    @Update("update users set password = crypt(#{password}, password),updated_timestamp=now() where uid = #{uid}")
    int updatePassword(@Param("uid") String uid, @Param("password") String password);

    @Update("update users set status = 1,updated_timestamp=now() where id = #{userId}")
    int updateUserAsVerified(@Param("userId") Integer userId);

    @Select("select u.id id, u.mobile_number mobile_number, u.uid uid, u.role, r.name role_name, u.status from users u " +
            "INNER JOIN role r ON (r.id = u.role) " +
            "where " +
            "u.mobile_number = #{mobileNumber} and u.password = crypt(#{password}, u.password) and (u.status = 1 or u.status = -1)")
    User getUserByMobileNumberAndPassword(@Param("mobileNumber") String mobileNumber,
                                          @Param("password") String password);

    @Select("select u.id id, u.mobile_number mobile_number, u.uid uid, u.role, r.name role_name from users u " +
            "INNER JOIN role r ON (r.id = u.role)" +
            "where " +
            "u.mobile_number = #{mobileNumber} and (u.status = 1 or u.status = -1)")
    User getUserByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Select("select u.id, u.mobile_number, uid, u.role, r.name as role_name from users u " +
            "INNER JOIN role r ON (r.id = u.role) " +
            "where uid = #{uid}")
    User getUserByUid(@Param("uid") String uid);

    @Select("select count(1) from users where mobile_number = #{mobileNumber} AND status = 1")
    int getUserCountByMobileNumber(@Param("mobileNumber") String mobileNumber);


    /*Current Status*/
    @Select({"SELECT s.status_key FROM customer c JOIN statuses s ON s.status_id = c.status_id " +
            "WHERE customer_id = #{customerId}"})
    String fetchCustomerStatus(int customerId);

    @Select({"SELECT s.status_key FROM guarantor g JOIN statuses s ON s.status_id = g.status_id " +
            "WHERE guarantor_id = #{guarantorId}"})
    String fetchGuarantorStatus(int guarantorId);


}
