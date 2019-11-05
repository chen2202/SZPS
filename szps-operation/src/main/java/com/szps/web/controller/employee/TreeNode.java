package com.szps.web.controller.employee;

import java.util.List;

/**
 * 组织结构图 树的节点类
 * @author zxc
 */
public class TreeNode {
	private String id;
	 
    private String name;
 
    private String pid;
 
    private List<TreeNode> childrens;
 
    public TreeNode(String id,String name,String pid){
        this.id = id;
        this.name = name;
        this.pid = pid;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPid() {
        return pid;
    }
 
    public void setPid(String pid) {
        this.pid = pid;
    }
 
    public List<TreeNode> getChildrens() {
        return childrens;
    }
 
    public void setChildrens(List<TreeNode> childrens) {
        this.childrens = childrens;
    }
 
    @Override
    public String toString() {
    	return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"pid\":\"" + pid + "\", \"childrens\":" + childrens +"}";
    }

}
