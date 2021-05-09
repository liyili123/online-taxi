package com.mashibing.servicepassengeruser;


import com.online.taxi.servicepassengeruser.dao.ServicePassengerUserInfoCustomDao;
import com.online.taxi.servicepassengeruser.entity.ServicePassengerUserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PassengerInfoDaoTest {

    @Autowired
    ServicePassengerUserInfoCustomDao servicePassengerUserInfoCustomDao ;

//    @Test
//    @Rollback
//    public void selectByPhone(){
//
//        PassengerInfo passengerInfo =  dao.selectByPhoneNumber("1111");
//        System.out.println("性别"+passengerInfo.getGender());
//    }


    @Test
    // 不回滚
//    @Rollback(value = false)
    // 回滚
    @Rollback(value = true)
    public void save(){
        ServicePassengerUserInfo user = new ServicePassengerUserInfo();
        user.setPassengerName("姓名");
        user.setCreateTime(new Date());
        user.setPassengerGender((byte)1);
        user.setPassengerPhone("17678987654");
        user.setRegisterDate(new Date());
        user.setUserState((byte)1);
        int i =  servicePassengerUserInfoCustomDao.insertSelective(user);
        System.out.println("id..."+user.getId());

        ServicePassengerUserInfo passengerUserInfo = servicePassengerUserInfoCustomDao.selectByPhoneNumber("17678987654");
        System.out.println(passengerUserInfo);
        Assert.assertEquals("姓名",passengerUserInfo.getPassengerName());
    }

}