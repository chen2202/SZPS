package com.szps.web.mapper.dm;

import com.szps.web.domain.dm.DmFile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmFileMapper {

    /**
     * 保存文件信息
     *
     * @param list 文件信息
     * @return 结果
     */
    int insertFileList(List<DmFile> list);


    /**
     * 通过资料ID查询资料文件信息
     *
     * @param dataId 资料ID
     * @return 用户对象信息
     */
    List<DmFile> selectFileListByDataId(Long dataId);

    /**
     * 通过资料uuid查询资料文件信息
     *
     */
   List<DmFile> selectFileListByUuid(String uuid);


    /**
     * 删除资料文件
     *
     * @param fileId 需要删除的文件ID
     * @return 结果
     */
    int deleteFileById(Long fileId);

    DmFile selectFileById(Long fileId);

    List<DmFile> selectFileListByIds(Long[] ids);

    int deleteFileByUuid(String uuid);
}
