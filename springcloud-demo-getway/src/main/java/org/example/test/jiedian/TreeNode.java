package org.example.test.jiedian;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode<T> {
    /**
     * 数据库表的任意一行权限
     */
    private T data;
    /**
     * data节点下所有的权限集合
     */
    private List<TreeNode<T>> childrenNode = new ArrayList<>();
 
    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }
 
    public List<TreeNode<T>> getChildrenNode() {
        return childrenNode;
    }
 
    public void setChildrenNode(List<TreeNode<T>> childrenNode) {
        this.childrenNode = childrenNode;
    }
 
    public TreeNode(T data, List<TreeNode<T>> childrenNode) {
        this.data = data;
        this.childrenNode = childrenNode;
    }
 
    public TreeNode() {
    }


    //通过data的id和每条数据的父id对比相同的放入子节点的集合中，并且从数据集合中删除（这样做只要权限数据集合变成空了就可以算是树遍历完成）
    public List<TreeNode<T>> childrenNode(List<T> datas, String idName, String fidName) {
        ConvertTree<T> convertTree = new ConvertTree<>();
        String idValue = convertTree.getFieldValue(data, idName);
        List<T> collect = datas.stream()
                .filter(date -> idValue.equals(convertTree.getFieldValue(date, fidName)))
                .collect(Collectors.toList());
        datas.removeAll(collect);
        for (T node : collect) {
            TreeNode<T> treeNode = new TreeNode<>();
            treeNode.setData(node);
            childrenNode.add(treeNode);
        }
        return childrenNode;
    }


    // 使用
/*    public List<TreeNode<AuthResource>> toTree() {
        //获取数据集合
        List<AuthResource> list = authResourceRepository.findAll();
        //创建工具类
        ConvertTree<AuthResource> convertTree = new ConvertTree<>();
        //生成森林
        List<TreeNode<AuthResource>> forest = convertTree.getForest(list, "id", "parentId");
        return convertTree.getForest(list);
    }*/
}