package org.example.liucheng;

/**
 * @author gaozj
 * @date 2022年01月07日 10:07
 */
public interface FlowNodeInterface <T>{
    // node的执行方法
    T invokeNode(FlowEngine.RunData nodeData,Context context);
    // node执行完后执行的方法
    void afterInvoke(FlowEngine.RunData nodeData,Context context);

    // 从content中获取此node结果的key
    String resultKey();
}
