package com.example.research.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 16:32 2019/9/30
 * @ Description：java CAS多线程
 * @ Modified By：
 * @Version: $version$
 */
public class CASThreadDemo implements Runnable{
    private AtomicInteger num = new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        increase();
        //num++;
        System.out.println(Thread.currentThread().getName()+"num="+num);
    }

    /**
     * 对公共数据加上synchronized进行原子性的控制
     */
    private void increase(){
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        /*CASThreadDemo demo = new CASThreadDemo();
        for (int i = 1; i <=20 ; i++) {
            new Thread(demo,"线程"+i).start();
            *//*ThreadDemo demo = new ThreadDemo();
            demo.start();*//*
        }*/
        String a = "123";
        String b = null;
        System.out.println(a.equals(b));
    }
}
class ThreadDemo extends Thread{
    private int num = 0;
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"num="+num);
    }
}
