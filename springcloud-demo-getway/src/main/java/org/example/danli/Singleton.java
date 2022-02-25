package org.example.danli;

/**
 * 饿汉式
 */
public class Singleton {
  // 创建一个实例对象
    private static Singleton instance = new Singleton();
    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton(){}
    /**
     * 静态get方法
     */
    public static Singleton getInstance(){
        return instance;
    }
}