package com.mashibing.cloudzuul;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test_reentrantLock {

    static volatile int i = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Test_reentrantLock object = new Test_reentrantLock();
        Thread thread1 = new Thread(() -> {
            object.man2();
        }, "thread01");
        Thread thread2 = new Thread(() -> {
            object.man2();
        }, "thread02");
        Thread thread3 = new Thread(() -> {
            object.man2();
        }, "thread03");

        new Thread(() -> {
            thread1.start();
            thread2.start();
            thread3.start();
        }).start();


    }

    public void man2() {
        reentrantLock.lock();
        i++;
        System.out.println("i: " + i);
        reentrantLock.unlock();
    }


}
