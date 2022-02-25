package org.example;

import org.example.test.linpaitong.BucketUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@EnableScheduling
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        // 为了方便测试这里定义1容量  1增长速率
        BucketUtil bucketUtil = new BucketUtil(1,1);
        // 生成名为：bucket的令牌桶
        BucketUtil.buckets.put("bucket",bucketUtil);
        SpringApplication.run(App.class, args);
        System.out.println( "Hello word!" );
    }
}
