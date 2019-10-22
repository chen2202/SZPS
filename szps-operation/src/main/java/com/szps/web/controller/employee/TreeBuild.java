package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;

public class TreeBuild {
	/**
     * 方式一：使用两层循环实现
     * @param treeList
     * @return
     */
    public static List<TreeNode> toTree01(List<TreeNode> treeList,String pid) {
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
    }

	
	
    /**
     * 方式二：使用递归实现
     * @param treeList
     * @return
    **/
    public static List<TreeNode> toTree02(List<TreeNode> treeList,String pid) {
        List<TreeNode> retList = new ArrayList<TreeNode>();
        for (TreeNode parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }

    /*
     * 查询父节点下的所有子节点
     * */
     private static TreeNode findChildren(TreeNode parent, List<TreeNode> treeList) {
         for (TreeNode child : treeList) {
             if (parent.getId().equals(child.getPid())) {
                 if (parent.getChildrens() == null) {
                     parent.setChildrens(new ArrayList<TreeNode>()); //子节点以数组形式存储
                 }
                 parent.getChildrens().add(findChildren(child, treeList));
             }
         }
         return parent;
     }
}
