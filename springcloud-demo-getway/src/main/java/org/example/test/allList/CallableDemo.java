package org.example.test.allList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableDemo implements Callable<List<String>>
{
    private List<String> list;
    //构造函数，用于传送数据进来
    public CallableDemo(List<String> list)
    {
        this.list = list;
    }
     public List<String> call() throws Exception
    {
        // 标记子线程开始
        System.out.println(Thread.currentThread().getName()+" Callable 子线程开始...");
        //结果存储
        List<String> resultList = new ArrayList<String>();

        // 业务逻辑处理
        for (String single:list)
        {
            if(Integer.parseInt(single)%2==0){
                resultList.add(single);
            }
        }
        // 标记子线程结束
        System.out.println(Thread.currentThread().getName()+" Callable 子线程结束...");
        return resultList;
    }
}
