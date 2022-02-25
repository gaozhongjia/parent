package org.example.liucheng;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;


import java.util.Map;
import java.util.Set;

/**
 * @author gaozj
 * @date 2022年01月06日 13:57
 */
public class FlowNode {
    private Map<String,NodeConf> nodeMap = Maps.newLinkedHashMap();

    public void add(String groupName,Class nodeName,NodeConf nodeConf){
        String key = null;
        if (!StringUtils.isEmpty(groupName)){
            key = groupName + "_" +nodeName.getName();
        }else {
            key = nodeName.getName();
        }
        nodeMap.put(key,nodeConf);
    }

    public void add(Class nodeName,NodeConf nodeConf){
        add(nodeName.getName(),nodeName,nodeConf);
    }

    public void replace(String groupName,Class nodeName,NodeConf nodeConf){
        String key = null;
        if (!StringUtils.isEmpty(groupName)){
            key = groupName + "_" +nodeName.getName();
        }else {
            key = nodeName.getName();
        }
        nodeMap.put(key,nodeConf);
    }

    public void replace(Class nodeName,NodeConf nodeConf){
        replace(nodeName.getName(),nodeName,nodeConf);
    }

    public void remove(String groupName,Class nodeName){
        String key = null;
        if (!StringUtils.isEmpty(groupName)){
            key = groupName + "_" +nodeName.getName();
        }else {
            key = nodeName.getName();
        }
        nodeMap.remove(key);
    }

    public void remove(Class nodeName){
        remove(nodeName.getName(),nodeName);
    }

    public Set<String> getNodeList(){
        return nodeMap.keySet();
    }

    public Map<String,NodeConf> getNodeMap(){
        return nodeMap;
    }

    public static class NodeConf{
        private int timeOut = 100;

        public NodeConf(int timeOut) {
            this.timeOut = timeOut;
        }

        public int getTimeOut() {
            return timeOut;
        }

        public void setTimeOut(int timeOut) {
            this.timeOut = timeOut;
        }
    }
}
