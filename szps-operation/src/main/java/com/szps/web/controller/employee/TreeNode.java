package com.szps.web.controller.employee;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

/**
 * 组织结构图树形json转化节点类
 * @author zxc
 *
=======
import java.util.List;

/**
 * 组织结构图 树的节点类
 * @author zxc
>>>>>>> cc172c9ebff30d4594bca7e8bfd8d691701d16bb
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
