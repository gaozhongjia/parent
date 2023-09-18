package org.example.test.test20230811;


import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<String> queue;

    private int maxSize;

    public Consumer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i =0;
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("队列已空，等待数据");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                i++;
                System.out.println("消费者消费数据"    + i);
                queue.poll();
                queue.notifyAll();
            }
        }
    }
}
