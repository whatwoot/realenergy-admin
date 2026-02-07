package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.PriceHisMapper;
import com.ruoyi.project.business.domain.PriceHis;
import com.ruoyi.project.business.service.IPriceHisService;

/**
 * 价格历史Service业务层处理
 *
 * @author gpthk
 * @date 2025-12-31
 */
@Service
public class PriceHisServiceImpl implements IPriceHisService {
    @Autowired
    private PriceHisMapper priceHisMapper;

    /**
     * 查询价格历史
     *
     * @param id 价格历史主键
     * @return 价格历史
     */
    @Override
    public PriceHis selectPriceHisById(Long id)
    {
        return priceHisMapper.selectPriceHisById(id);
    }

    /**
     * 查询价格历史列表
     *
     * @param priceHis 价格历史
     * @return 价格历史
     */
    @Override
    public List<PriceHis> selectPriceHisList(PriceHis priceHis)
    {
        return priceHisMapper.selectPriceHisList(priceHis);
    }

    /**
     * 新增价格历史
     *
     * @param priceHis 价格历史
     * @return 结果
     */
    @Override
    public int insertPriceHis(PriceHis priceHis) {
        priceHis.setCreateTime(null);
        return priceHisMapper.insertPriceHis(priceHis);
    }

    /**
     * 修改价格历史
     *
     * @param priceHis 价格历史
     * @return 结果
     */
    @Override
    public int updatePriceHis(PriceHis priceHis) {
        return priceHisMapper.updatePriceHis(priceHis);
    }

    /**
     * 批量删除价格历史
     *
     * @param ids 需要删除的价格历史主键
     * @return 结果
     */
    @Override
    public int deletePriceHisByIds(Long[] ids)
    {
        return priceHisMapper.deletePriceHisByIds(ids);
    }

    /**
     * 删除价格历史信息
     *
     * @param id 价格历史主键
     * @return 结果
     */
    @Override
    public int deletePriceHisById(Long id)
    {
        return priceHisMapper.deletePriceHisById(id);
    }
}
