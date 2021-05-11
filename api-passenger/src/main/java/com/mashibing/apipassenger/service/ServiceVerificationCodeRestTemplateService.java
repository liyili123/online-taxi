package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.servicesms.request.SmsSendRequest;

public interface ServiceVerificationCodeRestTemplateService {

    public ResponseResult generatorCode(int identity, String phoneNumber);

    public ResponseResult verifyCode(int identity, String phoneNumber , String code);
}
