package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Worker;

public interface WorkerService {
	
	/**
	 * 全部从业人员信息 list
	 * @param worker
	 * @return
	 */
	public List<Worker> selectAllWorker(Worker worker);
	
	/**
	 * 插入从业人员信息
	 * @param worker
	 */
	public void insertWorker(Worker worker);
	
	/**
	 * 校验从业人员身份证号是否唯一
	 * @param worker
	 * @return
	 */
	public String checkWorkerIdcardUnique(Worker worker);
	
	/**
     * 通过身份证号查询从业人员
     * @param 查询的身份证号
     * @return 从业人员对象信息
     */
    public Worker selectWorkerById(String idCard);
    
    /**
     * 修改从业人员信息
     */
    public void updateWorker(Worker worker);
    
    /**
     * 通过身份证号删除从业人员信息
     * @param 选中的身份证号数组
     */
    public int deleteWorkerById(String ids) throws Exception;
}
