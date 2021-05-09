package com.example.demo.ketang;

public class OptionTest {
    static final String string="123";



    public static void main(String[] args) {


        System.out.println(OptionTest.class.getClassLoader().getParent());
        String property = System.getProperty("sun.boot.class.path");
        System.out.println(property.replaceAll(":",System.lineSeparator()));
        System.out.println("-----------------------------------------------");
        String property1 = System.getProperty("java.ext.dirs");
        System.out.println(property1.replaceAll(":",System.lineSeparator()));
        System.out.println("-----------------------------------------------");
        String property2 = System.getProperty("java.class.path");
        System.out.println(property2.replaceAll(":",System.lineSeparator()));
        System.out.println("-----------------------------------------------");



    }
}
