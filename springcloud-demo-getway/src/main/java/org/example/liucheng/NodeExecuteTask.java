package org.example.liucheng;

import java.util.concurrent.Callable;

/**
 * @author gaozj
 * @date 2022年01月07日 10:11
 */
public class NodeExecuteTask implements Callable {

    private FlowNodeInterface flowNodeInterface;

    private FlowEngine.RunData runData;

    private Context context;

    public NodeExecuteTask(FlowNodeInterface flowNodeInterface, FlowEngine.RunData runData, Context context) {
        this.flowNodeInterface = flowNodeInterface;
        this.runData = runData;
        this.context = context;
    }

    public Object execute(){
        Object o = flowNodeInterface.invokeNode(runData, context);
        flowNodeInterface.afterInvoke(runData,context);
        return o;
    }

    @Override
    public Object call() throws Exception {
        return execute();
    }
}
