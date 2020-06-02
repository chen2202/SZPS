package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.mapper.supervise.TbStaffMapper;
import com.szps.web.service.supervise.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private TbStaffMapper staffMapper;
    @Override

    public List<TbStaff> selectStaffList(TbStaff staff) {

        return staffMapper.selectStaffList(staff);
    }

    @Override
    public List<TbStaff> selectStaffByStaffNumber(String staffName) {
        return staffMapper.selectStaffByStaffName(staffName);
    }

    @Override
    public List<TbStaff> selectStaffAll() {
        return  staffMapper.selectAll();
    }

    @Override
    public TbStaff selectStaffById(String staffNumber) {
        return staffMapper.selectByPrimaryKey(staffNumber);
    }

   /* @Override
    public TbStaff selectStaff() {
        return staffMapper.selectStaff();
    }*/

    @Override
    public int  deleteStaffById(String staffNumber) {
        return staffMapper.deleteByPrimaryKey(staffNumber);
    }

    @Override
    public int deleteStaffByIds(String ids) throws Exception {
        Long[] Ids = Convert.toLongArray(ids);
        return staffMapper.deleteUserByIds(Ids);
    }

    @Override
    public int insertStaff(TbStaff staff) {

        return staffMapper.insert(staff);
    }

    @Override
    public int updateStaff(TbStaff staff) {
        return staffMapper.updateByPrimaryKey(staff);
    }

    @Override
    public int checkStaff(String staffNumber) {
        return staffMapper.CheckdStaff(staffNumber);
    }

    @Override
    public List<TbStaff> selectStaffOne() {
        return staffMapper.selectStaffOne();
    }

    @Override
    public List<TbStaff> selectStaffSecond() {
        return staffMapper.selectStaffSecond();
    }
}
