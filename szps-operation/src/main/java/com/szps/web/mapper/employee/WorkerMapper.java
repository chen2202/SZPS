package com.szps.web.mapper.employee;

import java.util.List;

import com.szps.web.domain.employee.Worker;

/**
 * Worker持久层
 * */
public interface WorkerMapper {
	/**
	 * 获取所有的Worker对象
     *
     * @return
     */
    public List<Worker> selectAllWorker(Worker worker);
    
    /**
     * 新增Worker信息
     * 
     * @param  Worker信息
     * @return 结果
     */
    public void insertWorker(Worker worker);
    
    /**
     * 校验从业人员身份证号是否唯一
     */
    public Worker checkWorkerIdcardUnique(String idCard);
    
    /**
     * 通过身份证号查询从业人员
     * @param 查询的身份证号
     */
    public Worker selectWorkerById(String idCard);
 
    /**
     * 修改从业人员信息
     */
    public void updateWorker(Worker worker);
    
    /**
     * 通过身份证号删除从业人员信息
     */
    public int deleteWorkerById(String[] ids);
}
