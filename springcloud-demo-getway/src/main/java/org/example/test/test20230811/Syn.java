package org.example.test.test20230811;

public class Syn {

    int i= 0;
    public void test1() {
      synchronized (this){
          for (int j = 0; j < 10000; j++) {
              i++;
          }
      }
    }

   /* public static void main(String[] args) throws InterruptedException {
        Syn syn = new Syn();
        new Thread(()->{
            syn.test1();
        }).join();
        new Thread(()->{
            syn.test1();
        }).join();
        new Thread(()->{
            syn.test1();
        }).join();
        new Thread(()->{
            syn.test1();
        }).join();
        System.out.println(syn.i);
    }*/

        public static volatile boolean stop=false;
        public static void main(String[] args) throws InterruptedException {

            Thread t1=new Thread(()->{

                int i=0;

                while(!stop){
                    i++; }

            }); t1.start();
            System.out.println("begin start thread");
            Thread.sleep(1000);
            stop=true;

        }


}
