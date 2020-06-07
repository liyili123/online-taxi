package com.mashibing.servicesms.dao;

import com.mashibing.servicesms.entity.ServiceSmsTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceSmsTemplateCustomDao extends ServiceSmsTemplateDao {

    ServiceSmsTemplate selectByTemplateId(String templateId);
}
