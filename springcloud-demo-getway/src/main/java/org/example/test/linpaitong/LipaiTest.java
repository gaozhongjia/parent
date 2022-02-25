package org.example.test.linpaitong;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaozj
 * @date 2022年01月24日 16:17
 */
@RestController
public class LipaiTest {

    @Scheduled(fixedRate = 1000)// 定时1s
    public void timer() {
        if (BucketUtil.buckets.containsKey("bucket")){
            //名为：bucket的令牌桶 开始不断生成令牌
            BucketUtil.buckets.get("bucket").incrTokens();
        }
    }


    //上面的限流只是一个demo还有很多不足的地方，如：
    //
    //分布式环境下不适用
    //令牌桶可以有多个，不同的接口采用不同令牌桶的时候，拦截器无法分开限流
    //一次请求消耗一个令牌，可以被恶意消耗
    //改进方法：
    //
    //令牌桶实现采用redis集群存取
    //注解添加value参数，可以给对应接口打上对应的令牌桶参数，拦截器需对注解参数校验，实现多个接口多个令牌桶的限流
    //对用户IP校验限制次数，防止恶意攻击
    @BucketAnnotation
    @RequestMapping(value = "/bucket")
    public  String bucket(){
        return "SUCCESS";
    }

}
