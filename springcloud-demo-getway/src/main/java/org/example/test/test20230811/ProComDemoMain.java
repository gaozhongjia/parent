package org.example.test.test20230811;

import java.util.LinkedList;
import java.util.Queue;

public class ProComDemoMain {

    public static void main(String[] args) throws InterruptedException {
        Queue<String> queue = new LinkedList<>();
        Produces produces = new Produces(queue, 10);
        Consumer consumer = new Consumer(queue, 10);
        Thread thread1 = new Thread(produces);
        Thread thread2 = new Thread(consumer);
        thread1.start();
     //   Thread.sleep(1000);
        thread2.start();
    }
}
