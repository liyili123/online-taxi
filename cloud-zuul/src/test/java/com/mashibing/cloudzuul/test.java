package com.mashibing.cloudzuul;

import java.util.concurrent.*;

public class test  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println(test.class.getClassLoader());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(new llThread());
        Future future1 = executorService.submit(new llThread1());
        int i= (int) future.get();
        int j= (int) future1.get();
        System.out.println("i:"+i+"+j:"+j+"="+(i+j));

        FutureTask futureTask = new FutureTask<>(new llThread());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();

    }



}
class llThread implements Callable{


    @Override
    public Object call() throws Exception {
        int i=1;
        int result=0;
        while(i++<=50){
               result+=i;
           }
        return result;
    }
}
class llThread1 implements Callable{


    @Override
    public Object call() throws Exception {
        int i=51;
        int result=0;
        while(i++<=100){
            result+=i;
        }
        return result;
    }
}

