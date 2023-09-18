package org.example.danli;

/**
 * 懒汉式
 * 线程不安全的模式
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){}


    //线程不安全的模式
    public static Singleton2 getInstance() {
    if (instance == null) {
        instance = new Singleton2();
    }  
    return instance;
    }


    /**
     * 静态get方法
     * 线程安全
     */
    public static synchronized Singleton2 getInstance2(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }


    public static Singleton2 getInstance3(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(instance == null){
            //同步块，线程安全的创建实例
            synchronized (Singleton2.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }



    // 加入v  olatile
    private volatile static Singleton2 instance2 = null;

    public static Singleton2 getInstance4(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(instance2 == null){
            //同步块，线程安全的创建实例
            synchronized (Singleton2.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(instance2 == null){
                    instance2 = new Singleton2();
                }
            }
        }
        return instance2;
    }
}