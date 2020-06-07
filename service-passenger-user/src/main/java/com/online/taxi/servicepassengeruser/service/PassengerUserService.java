package com.online.taxi.servicepassengeruser.service;

import com.mashibing.internalcommon.dto.ResponseResult;

public interface PassengerUserService {

    public ResponseResult login(String passengerPhone);

    public ResponseResult logout(String token);
}
