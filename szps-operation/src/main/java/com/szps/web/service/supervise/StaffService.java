package com.szps.web.service.supervise;

import com.szps.web.domain.supervise.TbStaff;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface StaffService
{

    public List<TbStaff> selectStaffList(TbStaff staff);


    public List<TbStaff> selectStaffByStaffNumber(String staffName);


    public List<TbStaff> selectStaffAll();


    public TbStaff selectStaffById(String staffNumber);

    //public TbStaff selectStaff();


    public int deleteStaffById(String staffNumber);

    /**
     * 批量删除角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteStaffByIds(String ids) throws Exception;


    public int insertStaff(TbStaff staff);

    public int updateStaff(TbStaff staff);

    public  int checkStaff(String staffNumber);

    public List<TbStaff> selectStaffOne();
    public List<TbStaff> selectStaffSecond();

    public List<String> selectStaffName(String a);
}
