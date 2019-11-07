package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbPicture;

import java.util.List;

public interface TbPictureMapper {
    int deleteByPrimaryKey(String pictureId);

    int insert(TbPicture record);

    List<TbPicture>  selectByPrimaryKey(String pictureId);

    List<TbPicture> selectAll();

    int updateByPrimaryKey(TbPicture record);
    int Checkdpc(String pictureId);
}