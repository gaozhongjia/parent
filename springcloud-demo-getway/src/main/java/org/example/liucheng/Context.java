package org.example.liucheng;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 *  先创建一个Context 上下文，作为我们的调用下游服务的返回结果
 * @author gaozj
 * @date 2022年01月06日 13:45
 */
public class Context {
    // 结果缓存
    private Map<String,Object> resultMap = Maps.newHashMap();

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
