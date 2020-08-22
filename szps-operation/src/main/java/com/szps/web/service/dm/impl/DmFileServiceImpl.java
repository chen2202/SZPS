package com.szps.web.service.dm.impl;

import com.szps.web.domain.dm.DmFile;
import com.szps.web.mapper.dm.DmFileMapper;
import com.szps.web.service.dm.IDmFileService;
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
    public List<DmFile> selectFileListByIds(Long[] ids) {
        return fileMapper.selectFileListByIds(ids);
    }

    @Override
    public List<DmFile> selectFileListByUuid(String uuid) {
        return fileMapper.selectFileListByUuid(uuid);
    }

    @Override
    public int deleteFileById(Long fileId) {
        return fileMapper.deleteFileById(fileId);
    }

    @Override
    public DmFile selectFileById(Long fileId) {
        return fileMapper.selectFileById(fileId);
    }
}
