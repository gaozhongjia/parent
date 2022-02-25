package org.example.liucheng;

/**
 * @author gaozj
 * @date 2022年01月07日 11:04
 */
public class NodeTwo implements FlowNodeInterface{
    @Override
    public Object invokeNode(FlowEngine.RunData nodeData, Context context) {
        System.out.println("执行方法："+nodeData.getParamTwo());
        return nodeData.getParamTwo();
    }

    @Override
    public void afterInvoke(FlowEngine.RunData nodeData, Context context) {

    }

    @Override
    public String resultKey() {
        return "NodeTwo";
    }
}
