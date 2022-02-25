package org.example.liucheng;

/**
 * @author gaozj
 * @date 2022年01月07日 11:06
 */
public class Controller {
    public static class Flow{
        private static FlowNode testFlow = new FlowNode();
        static {
            testFlow.add(NodeOne.class,new FlowNode.NodeConf(1));
            testFlow.add(NodeTwo.class,new FlowNode.NodeConf(1));
        }
    }


    public static void main(String[] args) {

    }
}
