package org.example.test.test20230811;

import org.apache.commons.io.input.TaggedReader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    static   Lock lock = new ReentrantLock();
      static int i = 0;
      public static void incr() {
          lock.lock();
          try {
              Thread.sleep(1);
              i++;
          } catch (InterruptedException e) {
                e.printStackTrace();
          }
          lock.unlock();
      }
    public static void main(String[] args) throws InterruptedException {
       for (int j = 0; j < 1000; j++) {
           new Thread(()->Test.incr()).start();
       }
        Thread.sleep(5000);
        System.out.println("result:"+i);
    }

}
