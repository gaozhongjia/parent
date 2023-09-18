package org.example.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.example.executor.ThreadPoolUtils.waitFinish;

public class test {

    public static void main(String[] args) {
     /*   //1.创建一个大小为10的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//给线程池添加任务
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public synchronized void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }*/



      /*  //1.创建一个大小为10的线程池
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor= new ThreadPoolExecutor(10,Integer.MAX_VALUE,10L, TimeUnit.SECONDS,queue);
        //给线程池添加任务
        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public synchronized void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
*/System.out.println("线程池中活跃线程数：" + ThreadPoolUtils.getActiveCount());
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
        futures.add(ThreadPoolUtils.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("线程名：" + Thread.currentThread().getName());
                return null;
            }
        }));
        }
       // waitFinish(futures);


       /* ThreadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" + Thread.currentThread().getName());
            }
        });*/
        System.out.println("线程池中活跃线程数：" + ThreadPoolUtils.getActiveCount());
    }





}
