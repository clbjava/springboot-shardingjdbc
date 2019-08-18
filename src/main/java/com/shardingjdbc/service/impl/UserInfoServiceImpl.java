package com.shardingjdbc.service.impl;

import com.shardingjdbc.dao.UserInfoMapper;
import com.shardingjdbc.dto.UserInfo;
import com.shardingjdbc.service.UserInfoService;
import com.shardingjdbc.service.dto.ReqDto;
import com.shardingjdbc.service.dto.RspDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("com.shardingjdbc.service.UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    @Qualifier("com.shardingjdbc.dao.UserInfoMapper")
    UserInfoMapper userInfoMapper;

    public RspDto saveUserInfo(ReqDto req) {
        RspDto rsp=new RspDto();
        rsp.setCode("0000");
        rsp.setMsg("S");

        UserInfo userInfo=new UserInfo();
        /*userInfo.setUserId();
        userInfo.setUserName();
        userInfo.setIdCardNo();
        userInfo.setIdCardName();
        userInfo.setIdCardSex();
        userInfo.setOccupation();
        userInfo.setDesc();
        userInfo.setSlot();*/
        userInfoMapper.insert(userInfo);

        return rsp;
    }

}
