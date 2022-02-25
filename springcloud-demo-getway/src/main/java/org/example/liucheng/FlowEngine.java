package org.example.liucheng;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.lucene.util.NamedThreadFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author gaozj
 * @date 2022年01月06日 13:48
 */
public class FlowEngine {

    //创建我们的流程节点，
    // 这相当于就是保存我们整个流程中需要执行下游服务的节点，
    // 以Map作为保存数据，NodeConf 节点设置参数，自定义请求服务超时时间
    // （因为并行我们是用的线程池或者通过get设置时间get返回值结果）

    public void execute(FlowNode flowNode,RunData runData,Context context) throws Exception{
        Map<String, List<String>> nodeGroup  = groupByGroupName(flowNode);
        Map<String,FlowNode.NodeConf> nodeMap = flowNode.getNodeMap();
        for (String groupName : nodeGroup.keySet()){
            boolean needThrowExp = false;
            List<String> nodeNameList = nodeGroup.get(groupName);
            // 只有一个节点的情况，串行执行
            if (nodeNameList.size() == 1){
                String nodeName = nodeNameList.get(0);
                FlowNodeInterface detailNode = (FlowNodeInterface) BaseService.getSingleBeanByType(Class.forName(nodeName));
                NodeExecuteTask nodeExecuteTask = new NodeExecuteTask(detailNode,runData,context);
                Object execute = nodeExecuteTask.execute();
                context.getResultMap().put(detailNode.resultKey(),execute);
            }else {
                //多个节点
                List<Future> resultList = new ArrayList<>();
                List<String> executedNodeNameList = new ArrayList<>();
                List<NodeExecuteTask> executeTaskList = new ArrayList<>();
                for (String nodeName :nodeNameList){
                    FlowNodeInterface detailNode = (FlowNodeInterface) BaseService.getSingleBeanByType(Class.forName(nodeName));
                    NodeExecuteTask nodeExecuteTask = new NodeExecuteTask(detailNode,runData,context);
                    executeTaskList.add(nodeExecuteTask);
                    executedNodeNameList.add(nodeName);
                    resultList.add(threadPool.submit(nodeExecuteTask));
                }
                for (int i = 0; i < resultList.size(); i++) {
                    String nodeName = executedNodeNameList.get(i);
                    String nodeKey = groupName + "_" + nodeName;
                    FlowNodeInterface detailNode = (FlowNodeInterface) BaseService.getSingleBeanByType(Class.forName(nodeName));
                    FlowNode.NodeConf nodeConf = nodeMap.get(nodeKey);
                    int timeOut = nodeConf.getTimeOut();
                    Future future = resultList.get(i);
                    Object o = future.get(timeOut, TimeUnit.MILLISECONDS);
                    context.getResultMap().put(detailNode.resultKey(),o);
                }
            }
        }
    }

    public Map<String, List<String>> groupByGroupName(FlowNode flowNode) {
        Map<String, List<String>> nodeGroup = Maps.newLinkedHashMap();
        for (String nodeKey: flowNode.getNodeList()) {
                String groupName = getGroupName(nodeKey);
                String nodeName = getNodeName(nodeKey);
                if (StringUtils.isEmpty(groupName)){
                    List<String> nodeNameList = Lists.newArrayList();
                    nodeNameList.add(nodeName);
                    nodeGroup.put(nodeName,nodeNameList);
                }else {
                    List<String> nodeNameList = nodeGroup.get(groupName);
                    if (nodeNameList == null){
                        nodeNameList = Lists.newArrayList();
                    }
                    nodeNameList.add(nodeName);
                    nodeGroup.put(groupName,nodeNameList);

                }
        }
        return nodeGroup;

    }

    public String getNodeName(String nodeKey) {
        String[] arr = nodeKey.split("_");
        return arr.length ==2?arr[0]:null;
    }

    public String getGroupName(String nodeKey) {
        String[] arr = nodeKey.split("_");
        return arr.length ==2?arr[0]:null;
    }


    public static class RunData{
        private String paramOne;

        private String paramTwo;

        public String getParamOne() {
            return paramOne;
        }

        public void setParamOne(String paramOne) {
            this.paramOne = paramOne;
        }

        public String getParamTwo() {
            return paramTwo;
        }

        public void setParamTwo(String paramTwo) {
            this.paramTwo = paramTwo;
        }
    }

    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,60L, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(500),new NamedThreadFactory("engine proccessor"),
            new ThreadPoolExecutor.AbortPolicy(){
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                    throw new RejectedExecutionException("Task " + r.toString() +
                            " rejected from " +
                            e.toString());
                }
            });


}

