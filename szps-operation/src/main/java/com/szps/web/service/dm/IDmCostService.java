package com.szps.web.service.dm;


import com.szps.web.domain.dm.DmCost;

import java.util.List;

/**
 * 污水费管理业务层
 *
 * @author vic
 */
public interface IDmCostService {

    /**
     * 根据条件分页查询污水费资料信息
     *
     * @param dmCost 污水费资料信息
     * @return 资料信息集合信息
     */
    List<DmCost> selectCostList(DmCost dmCost);


    /**
     * 保存资料信息
     *
     * @param dmCost 污水费资料信息
     * @return 结果
     */
    int insertCost(DmCost dmCost);


    /**
     * 批量删除资料
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    int deleteCostByIds(Long[] ids);


    /**
     * 通过资料ID查询资料
     *
     * @param costId 资料ID
     * @return 用户对象信息
     */
    DmCost selectCostById(Long costId);

    /**
     * 修改资料
     * @param dmCost
     * @return
     */
    int updateCost(DmCost dmCost);
}
