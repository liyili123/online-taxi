package com.example.demo.mode;

public class RealSubject implements Subject{
    @Override
    public void SayHello() {
        System.out.println("hello...");
    }

    @Override
    public void SayGoodby() {
        System.out.println("goodbay...");
    }
}
