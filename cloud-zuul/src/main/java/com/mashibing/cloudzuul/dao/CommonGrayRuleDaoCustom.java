package com.mashibing.cloudzuul.dao;

import com.mashibing.cloudzuul.entity.CommonGrayRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonGrayRuleDaoCustom extends CommonGrayRuleDao {

    CommonGrayRule selectByUserId(Integer userId);
}
