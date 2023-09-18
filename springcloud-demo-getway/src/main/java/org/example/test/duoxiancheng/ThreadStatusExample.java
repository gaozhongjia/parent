package org.example.test.duoxiancheng;

import java.util.concurrent.TimeUnit;

public class ThreadStatusExample {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                   // Thread.sleep(1000000);
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timewaiting").start();

       new Thread(()->{
           while (true){
               synchronized (ThreadStatusExample.class){
                   try {
                       ThreadStatusExample.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       },"watting");


       new Thread(new TimeWaiting(),"TimeWaitingThread-01").start();
       new Thread(new TimeWaiting(),"TimeWaitingThread-02").start();
    }


    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            synchronized (TimeWaiting.class) {
                while (true) {
                    try {
                        //Thread.sleep(1000000);
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
