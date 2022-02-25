package org.example.test.allList;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DealListDemo
{

    /**
     * @param list     待处理集合
     * @param nThreads 线程数量
     * @return
     */
    public List<String> dealListMulti(List<String> list, int nThreads)
    {
        if (list == null || list.size() < 1)
        {
            throw new NullPointerException("the collection is null");
        }
        //计算每个分组存多个数据
        int capactiy = list.size()%nThreads>0?list.size()/nThreads:list.size()/nThreads+1;
        //进行数据分组(分任务)
        List<List<String>> partions =  Lists.partition(list,capactiy);
        CallableDemo callTask;
        // 创建一个临时的局部线程池（固定大小）
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        // 保存结果
        List<Future<List<String>>> futures = new ArrayList<Future<List<String>>>(partions.size());

        // 分配任务
        for (int i = 0; i < partions.size(); i++)
        {
            // 小任务
            callTask = new CallableDemo(partions.get(i));
            //同步执行多个小任务
            futures.add(executorService.submit(callTask));
        }
        // 关闭线程池
        executorService.shutdown();
        // 合并
        List<String> result = new ArrayList<String>();
        for (Future<List<String>> future : futures)
        {
            try
            {
                // 合并
                result.addAll(future.get());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("主线程结束");
        return result;
    }


    public static void main(String[] args) {
        final int size = 12; // 处理的集合大小
        final int nThreads = 4; // 线程数
        List<String> list = new ArrayList<String>(size);
        for (int i = 0; i < size; i++)
        {
            list.add(i + "");
        }
        List<String> list2 = new DealListDemo().dealListMulti(list, nThreads);
        System.out.println(list2);
    }
}