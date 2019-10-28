package com.szps.web.mapper.dm;

import com.szps.web.domain.dm.DmCost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmCostMapper {


    /**
     * 根据条件分页查询污水费资料信息
     *
     * @param dmCost 污水费资料信息
     * @return 资料信息集合信息
     */
    public List<DmCost> selectCostList(DmCost dmCost);


    /**
     * 保存资料信息
     *
     * @param dmCost 污水费资料信息
     * @return 结果
     */
    public int insertCost(DmCost dmCost);


    /**
     * 批量删除资料
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteCostByIds(Long[] ids) throws Exception;

    /**
     * 通过资料ID查询资料
     *
     * @param costId 资料ID
     * @return 用户对象信息
     */
    public DmCost selectCostById(Long costId);

    /**
     * 通过资料编码查询资料
     *
     * @param costCode 资料编码
     * @return 用户对象信息
     */
    public DmCost selectCostByCode(String costCode);

}
