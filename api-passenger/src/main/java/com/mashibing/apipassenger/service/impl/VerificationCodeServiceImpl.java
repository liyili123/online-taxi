package com.mashibing.apipassenger.service.impl;

import com.mashibing.apipassenger.service.ServiceSmsRestTemplateService;
import com.mashibing.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.constant.IdentityConstant;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.servicepassengeruser.T;
import com.mashibing.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;
import com.netflix.discovery.converters.Auto;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServiceSmsRestTemplateService serviceSmsRestTemplateService;

    @Override
    public ResponseResult send(String phoneNumber) {

        // 获取验证码
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.generatorCode(IdentityConstant.PASSENGER,phoneNumber);
        VerifyCodeResponse verifyCodeResponse = null;
        if (responseResult.getCode() == CommonStatusEnum.SUCCESS.getCode()){
            JSONObject data = JSONObject.fromObject(responseResult.getData().toString());
            verifyCodeResponse = (VerifyCodeResponse)JSONObject.toBean(data,VerifyCodeResponse.class);

        }else {
            return ResponseResult.fail("获取验证码失败");
        }

        String code = verifyCodeResponse.getCode();

        ResponseResult result = serviceSmsRestTemplateService.sendSms(phoneNumber,code);
        if (result.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("发送短信 失败");
        }

        return ResponseResult.success("");

    }

    @Override
    public ResponseResult verify(String phoneNumber, String code) {

        return serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER,phoneNumber,code);
    }

}
