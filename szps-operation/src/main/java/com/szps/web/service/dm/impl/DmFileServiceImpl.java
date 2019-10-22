package com.szps.web.service.dm.impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dm.DmFile;
import com.szps.web.mapper.dm.DmFileMapper;
import com.szps.web.service.dm.IDmFileService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmFileServiceImpl implements IDmFileService {

    @Autowired
    private DmFileMapper fileMapper;

    @Override
    public int insertFileList(List<DmFile> list) {
        return fileMapper.insertFileList(list);
    }

    @Override
    public List<DmFile> selectFileListByDataId(Long dataId) {
        return fileMapper.selectFileListByDataId(dataId);
    }

    @Override
    public List<DmFile> selectFileListByFileIds(String ids) {
        Long[] fileIds = Convert.toLongArray(ids);
        return fileMapper.selectFileListByFileIds(fileIds);
    }

    @Override
    public int deleteFileById(Long fileId) {
        return fileMapper.deleteFileById(fileId);
    }



}
