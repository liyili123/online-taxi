package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.servicesms.request.SmsSendRequest;

public interface ServiceSmsRestTemplateService {

    public ResponseResult sendSms(String phoneNumber , String code);
}
