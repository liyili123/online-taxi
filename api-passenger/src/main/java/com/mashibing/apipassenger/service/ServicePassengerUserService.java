package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.servicepassengeruser.request.LoginRequest;

public interface ServicePassengerUserService {

    public ResponseResult login(String passengerPhone);
}
