package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.DecPriceHisMapper;
import com.ruoyi.project.business.domain.DecPriceHis;
import com.ruoyi.project.business.service.IDecPriceHisService;

/**
 * 价格历史DService业务层处理
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Service
public class DecPriceHisServiceImpl implements IDecPriceHisService {
    @Autowired
    private DecPriceHisMapper decPriceHisMapper;

    /**
     * 查询价格历史D
     *
     * @param id 价格历史D主键
     * @return 价格历史D
     */
    @Override
    public DecPriceHis selectDecPriceHisById(Long id)
    {
        return decPriceHisMapper.selectDecPriceHisById(id);
    }

    /**
     * 查询价格历史D列表
     *
     * @param decPriceHis 价格历史D
     * @return 价格历史D
     */
    @Override
    public List<DecPriceHis> selectDecPriceHisList(DecPriceHis decPriceHis)
    {
        return decPriceHisMapper.selectDecPriceHisList(decPriceHis);
    }

    /**
     * 新增价格历史D
     *
     * @param decPriceHis 价格历史D
     * @return 结果
     */
    @Override
    public int insertDecPriceHis(DecPriceHis decPriceHis) {
        decPriceHis.setCreateTime(null);
        return decPriceHisMapper.insertDecPriceHis(decPriceHis);
    }

    /**
     * 修改价格历史D
     *
     * @param decPriceHis 价格历史D
     * @return 结果
     */
    @Override
    public int updateDecPriceHis(DecPriceHis decPriceHis) {
        return decPriceHisMapper.updateDecPriceHis(decPriceHis);
    }

    /**
     * 批量删除价格历史D
     *
     * @param ids 需要删除的价格历史D主键
     * @return 结果
     */
    @Override
    public int deleteDecPriceHisByIds(Long[] ids)
    {
        return decPriceHisMapper.deleteDecPriceHisByIds(ids);
    }

    /**
     * 删除价格历史D信息
     *
     * @param id 价格历史D主键
     * @return 结果
     */
    @Override
    public int deleteDecPriceHisById(Long id)
    {
        return decPriceHisMapper.deleteDecPriceHisById(id);
    }
}
