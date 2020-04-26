package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 树形结构建立 
 * @author zxc 
 *
 */
public class TreeBuild {
	/**
     * 方式一：使用两层循环实现
     * @param treeList
     * @return
     */
    /*public static List<TreeNode> toTree01(List<TreeNode> treeList,String pid) {
        List<TreeNode> retList = new ArrayList<TreeNode>();
        for (TreeNode parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(parent);
            }
            for (TreeNode child : treeList) {
                if (child.getPid() == parent.getId()) {
                    if (parent.getChildrens() == null) {
                        parent.setChildrens(new ArrayList<TreeNode>());
                    }
                    parent.getChildrens().add(child);
                }
            }
        }
        return retList;
    }*/

	/**
	 * 方式二：使用递归实现
	 * @param treeList 存放所有节点的List
	 * @param pid 树根节点的父id，因为没有父节点，随便一个字符即可，但是需要和初始化的根节点中pid相同
	 * @return
	 */
    public static List<TreeNode> toTree02(List<TreeNode> treeList,String pid) {
        List<TreeNode> retList = new ArrayList<TreeNode>();
        for (TreeNode parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }

    /**
     * 查询父节点下的所有子节点
     * 性能不是很好，因为子节点的子节点添加子节点时，仍然是寻找了整个treeList
     * @param parent 根节点
     * @param treeList 存放所有无序节点的List
     * @return
     */
     private static TreeNode findChildren(TreeNode parent, List<TreeNode> treeList) {
         for (TreeNode child : treeList) {
             if (parent.getId().equals(child.getPid())) { //某个父节点有子节点
                 if (parent.getChildrens() == null) { //查看父节点是否已经有添加子节点的节点数组
                     parent.setChildrens(new ArrayList<TreeNode>()); //没有的话，添加节点数组，最终子节点以数组元素形式存储到父节点中
                 }
                 parent.getChildrens().add(findChildren(child, treeList)); //当前的
             }
         }
         return parent;
     }
}
