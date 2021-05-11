package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;

public interface VerificationCodeService {

    public ResponseResult send(String phoneNumber);

    public ResponseResult verify(String phoneNumber, String code);
}
