package com.szps.web.service.supervise;

import com.szps.web.domain.supervise.TbEnclosure;
import com.szps.web.domain.supervise.TbPicture;
import com.szps.web.domain.supervise.TbRule;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface EnclosureService
{

    public List<TbEnclosure> selectEnclosureList(TbEnclosure enclosure);


    public List<TbEnclosure> selectRuleAll();


    public List<TbEnclosure> selectEnclosureById(String feedbackNumber);

    public TbEnclosure selectEnclosureByIds(String enclosureId);

    public int deleteEnclosureById(String enclosureNumber);

    /**
     * 批量删除角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteEnclosureByIds(String ids) throws Exception;


    public int insertEnclosure(TbEnclosure enclosure);

    public int updateEnclosure(TbRule rule);


    public int checkEnclosure(String s);
}
