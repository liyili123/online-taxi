package com.example.demo.ketang.schedule;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest03 {
	Timer timer;
    public TimerTest03(){
        timer = new Timer();
        timer.schedule(new TimerTaskTest03(), 1000, 2000);        
    }
    public static void main(String[] args) {
        new TimerTest03();
    }
    public class TimerTaskTest03 extends TimerTask {
    	int count=0;
        @Override
        public void run() {
            LocalDateTime ldt = LocalDateTime.now();
            System.out.println("本次执行"+count+"该线程的时间为：" + ldt);
            count++;
            if(count==3) {
                System.out.println("取消"+count);
            	this.cancel();
            }
        }
    }
}