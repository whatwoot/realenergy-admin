package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.TraderMapper;
import com.ruoyi.project.business.domain.Trader;
import com.ruoyi.project.business.service.ITraderService;

/**
 * 策略Service业务层处理
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Service
public class TraderServiceImpl implements ITraderService {
    @Autowired
    private TraderMapper traderMapper;

    /**
     * 查询策略
     *
     * @param id 策略主键
     * @return 策略
     */
    @Override
    public Trader selectTraderById(Long id)
    {
        return traderMapper.selectTraderById(id);
    }

    /**
     * 查询策略列表
     *
     * @param trader 策略
     * @return 策略
     */
    @Override
    public List<Trader> selectTraderList(Trader trader)
    {
        return traderMapper.selectTraderList(trader);
    }

    /**
     * 新增策略
     *
     * @param trader 策略
     * @return 结果
     */
    @Override
    public int insertTrader(Trader trader) {
        trader.setCreateTime(null);
        return traderMapper.insertTrader(trader);
    }

    /**
     * 修改策略
     *
     * @param trader 策略
     * @return 结果
     */
    @Override
    public int updateTrader(Trader trader) {
        trader.setUpdateTime(null);
        return traderMapper.updateTrader(trader);
    }

    /**
     * 批量删除策略
     *
     * @param ids 需要删除的策略主键
     * @return 结果
     */
    @Override
    public int deleteTraderByIds(Long[] ids)
    {
        return traderMapper.deleteTraderByIds(ids);
    }

    /**
     * 删除策略信息
     *
     * @param id 策略主键
     * @return 结果
     */
    @Override
    public int deleteTraderById(Long id)
    {
        return traderMapper.deleteTraderById(id);
    }
}
