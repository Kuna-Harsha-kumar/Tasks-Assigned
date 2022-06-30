package com.example.signup.service.impl;

import com.example.signup.dto.*;
import com.example.signup.exceptions.BasicException;
import com.example.signup.mapper.AutoInvestmapper;
import com.example.signup.service.AutoInvest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@Slf4j
public class AutoInvestImpl implements AutoInvest {

    @Autowired
    AutoInvestmapper mapper;
    public int getwalletbalance(autoInvestdto dto) {
        String mobile_no=dto.getMobile_no();
        int wallet_balance=mapper.getwalletbalance(mobile_no);
        if(wallet_balance==0){
            throw new BasicException(404,"Balance Empty");
        }
        return wallet_balance;
    }
    public void updatepreference(preferencesdto dto){
        int risk=dto.getRisk();
        String type=dto.getType();
        String mobile_number=dto.getMobile_number();
        List<preferencesdto> preferences;
        mapper.updateCustomer(risk,dto.getAmount(),type,mobile_number);
    }
    public void updatetermsandcondtions(termsCondtionsdto dto){
        mapper.updatetermsandcontions(dto.getIsaccepted(),dto.getMobile_number());
    }
    public void updateInvestType(InvestType dto){
        String mobile_number= dto.getMobile_number();
        mapper.updateinvestType(dto.getInvestType(),dto.getMobile_number());
    }
}
