package org.example.test.test20230811;

import java.util.Queue;

public class Produces implements Runnable {

    private Queue<String> queue;

    private int maxSize;

    public Produces(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i =0;
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("队列已满，等待有空余空间");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i++;
                System.out.println("生产者生产数据"    + i);
                queue.add("data"+i);
                queue.notifyAll();
            }
        }

    }
}
