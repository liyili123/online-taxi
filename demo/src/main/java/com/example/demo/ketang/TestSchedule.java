package com.example.demo.ketang;

import java.util.concurrent.*;

public class TestSchedule {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },2, TimeUnit.SECONDS);


    }
}
