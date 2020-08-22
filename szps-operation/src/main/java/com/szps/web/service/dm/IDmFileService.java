package com.szps.web.service.dm;

import com.szps.web.domain.dm.DmFile;

import java.util.List;

public interface IDmFileService {
    int insertFileList(List<DmFile> list);

    List<DmFile> selectFileListByIds(Long[] ids);

    List<DmFile> selectFileListByUuid(String uuid);

    int deleteFileById(Long fileId);

    DmFile selectFileById(Long fileId);
}
