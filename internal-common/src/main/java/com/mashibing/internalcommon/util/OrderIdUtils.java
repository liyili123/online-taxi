package com.mashibing.internalcommon.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderIdUtils {

    public synchronized static String getOrderNumber(){

        StringBuffer sb = new StringBuffer();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);

        String mcode = System.getProperty("mcode");
        String randomString = RandomStringUtils.randomNumeric(4);

        return sb.append(dateTime).append("*"+mcode).append("*"+randomString).toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(getOrderNumber());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        AtomicInteger ai = new AtomicInteger();
//        for (int i = 0; i < 100; i++) {
//            ai.incrementAndGet();
//            System.out.println(ai.get());
//        }
//        System.out.println(ai.get());


    }
}
