package com.shardingjdbc.service;

import com.shardingjdbc.service.dto.ReqDto;
import com.shardingjdbc.service.dto.RspDto;

public interface UserInfoService {

    public RspDto saveUserInfo(ReqDto req);

}
