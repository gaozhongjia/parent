package org.example.test.shunxutiaoyong;


import java.util.concurrent.CompletableFuture;

/**
 * @author gaozj
 * @date 2022年01月11日 14:25
 */
public class A {

    public static String doA(){
        System.out.println("执行A");
        return "a";
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> doA());
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> B.doB());
        CompletableFuture.allOf(futureA,futureB);

        C.doC(futureA.join(), futureB.join());

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> D.doD());
        CompletableFuture<String> futureE = CompletableFuture.supplyAsync(() -> E.doE());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futureD, futureE);
        //直到所有任务结束
        voidCompletableFuture.join();

    }
}
