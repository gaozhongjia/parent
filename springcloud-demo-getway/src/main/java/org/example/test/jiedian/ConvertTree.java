package org.example.test.jiedian;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaozj
 * @date 2022年01月24日 13:38
 */
public class ConvertTree<T> {

    //由于无法知道具体的类也就不知道id字段和父id字段，采用反射的方式获取字段的值
    public String getFieldValue(T o, String fieldName) {
        //得到class
        Class cls = o.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            try {
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                if (field.getName().equals(fieldName)) {
                    Object result = field.get(o);
                    if (result == null) {
                        return null;
                    }
                    return result.toString();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("获取属性值失败");
    }

    public TreeNode<T> getRootNode(List<T> datas, String idName, String fidName) {
        if (datas.isEmpty()) {
            return null;
        }
        T node = datas.get(0);
        T rootNode = getRootNode(datas, idName, fidName, node);
        TreeNode<T> rootTreeNode = new TreeNode<>();
        datas.remove(rootNode);
        rootTreeNode.setData(rootNode);
        rootTreeNode.childrenNode(datas, idName, fidName);
        return rootTreeNode;
    }


    private T getRootNode(List<T> datas, String idName, String fidName, T node) {
        T fNode = null;
        String fieldValue = getFieldValue(node, fidName);
        for (T data : datas) {
            if (getFieldValue(data, idName).equals(fieldValue)) {
                fNode = data;
                break;
            }
        }
        if (fNode == null) {
            return node;
        } else {
            return getRootNode(datas, idName, fidName, fNode);
        }
    }

    private TreeNode<T> getTree(List<T> datas, String idName, String fidName) {
        //获取树根
        TreeNode<T> rootNode = getRootNode(datas, idName, fidName);
        //遍历树根的子集
        List<TreeNode<T>> childrenNode = rootNode.getChildrenNode();
        forChildren(datas, idName, fidName, childrenNode);
        //此时树已经形成
        return rootNode;
    }

    private void forChildren(List<T> datas, String idName, String fidName, List<TreeNode<T>> childrenNode) {
        //需要遍历的集合
        List<TreeNode<T>> needForList = new ArrayList<>();
        for (TreeNode<T> tTreeNode : childrenNode) {
            List<TreeNode<T>> treeNodes = tTreeNode.childrenNode(datas, idName, fidName);
            needForList.addAll(treeNodes);
        }
        if (!needForList.isEmpty()) {
            forChildren(datas, idName, fidName, needForList);
        }
    }


    public List<TreeNode<T>> getForest(List<T> datas, String idName, String fidName) {
        List<TreeNode<T>> forest = new ArrayList<>();
        while (!datas.isEmpty()) {
            TreeNode<T> tree = getTree(datas, idName, fidName);
            forest.add(tree);
        }
        return forest;
    }
}
