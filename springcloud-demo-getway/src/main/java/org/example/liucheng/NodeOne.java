package org.example.liucheng;

/**
 * @author gaozj
 * @date 2022年01月07日 10:58
 */
public class NodeOne  implements FlowNodeInterface{
    @Override
    public Object invokeNode(FlowEngine.RunData nodeData, Context context) {
        System.out.println("执行方法："+nodeData.getParamOne());
        return nodeData.getParamOne();
    }

    @Override
    public void afterInvoke(FlowEngine.RunData nodeData, Context context) {

    }

    @Override
    public String resultKey() {
        return "NodeOne";
    }
}
