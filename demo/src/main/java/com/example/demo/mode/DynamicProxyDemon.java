package com.example.demo.mode;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemon {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String var1 = System.getProperty("java.class.path");
        System.out.println(var1);
        Subject realSubject = new RealSubject();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println("动态代理对象的类型：" + subject.getClass().getName());
        subject.SayHello();
        subject.SayGoodby();
        //生成字节码文件
//        createProxyClassFile();


//        Method m4 = Class.forName("com.example.demo.mode.Subject").getMethod("SayHello");
//        m4.invoke(realSubject,null);
    }

    private static void createProxyClassFile(){
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{Subject.class});
        FileOutputStream out =null;
        try {
            String path=DynamicProxyDemon.class.getClassLoader().getResource("").getFile();
            out = new FileOutputStream(path+"ProxySubject.class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
