package com.szps.web.service.employee.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
import com.szps.web.domain.employee.Worker;
import com.szps.web.mapper.employee.WorkerMapper;
import com.szps.web.service.employee.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{
	@Autowired
	private WorkerMapper workerMapper;
	
	/**获得映射中所有Worker
	*参数：传递的Worker
	*返回值：获得所有Worker模型列表
	 */
	public List<Worker> selectAllWorker(Worker worker) {
		return workerMapper.selectAllWorker(worker);
	}
	
	/**插入新的Worker数据
	*参数：传递的Worker
	*返回值：
	*/
	public void insertWorker(Worker worker) {
		workerMapper.insertWorker(worker);
	}
	
	/**校验从业人员
	*参数：
	*返回值：如果从业人员身份证号唯一，返回"0"，不唯一返回"1"
	*/
	public String checkWorkerIdcardUnique(Worker worker) {
		Worker w = null; //提前赋值null，防止因为前端要输入的身份证号是数据库中没有的而缺失值，导致报错
		w = workerMapper.checkWorkerIdcardUnique(worker.getIdCard()); //如果数据库存在重复从业人员，w!=null
		if(w != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**
     * 通过从业人员身份证号查询从业人员
     * 
     * @param idCard 从业人员身份证号
     * @return 从业人员对象信息
     */
    @Override
    public Worker selectWorkerById(String idCard) {
    	return workerMapper.selectWorkerById(idCard);
    }
    
    /**
     * 通过身份证号 修改保存从业人员信息
     */
    public void updateWorker(Worker worker) {
    	workerMapper.updateWorker(worker);
    }
    
    /**
     * 通过身份证号删除从业人员信息
     */
    @Override
    public int deleteWorkerById(String ids) throws BusinessException {
    	String[] idCards = Convert.toStrArray(ids);
    	return workerMapper.deleteWorkerById(idCards);
    }
}
