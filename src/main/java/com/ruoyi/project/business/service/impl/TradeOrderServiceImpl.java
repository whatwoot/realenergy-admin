package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.TradeOrderMapper;
import com.ruoyi.project.business.domain.TradeOrder;
import com.ruoyi.project.business.service.ITradeOrderService;

/**
 * 跟单订单Service业务层处理
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Service
public class TradeOrderServiceImpl implements ITradeOrderService {
    @Autowired
    private TradeOrderMapper tradeOrderMapper;

    /**
     * 查询跟单订单
     *
     * @param id 跟单订单主键
     * @return 跟单订单
     */
    @Override
    public TradeOrder selectTradeOrderById(Long id)
    {
        return tradeOrderMapper.selectTradeOrderById(id);
    }

    /**
     * 查询跟单订单列表
     *
     * @param tradeOrder 跟单订单
     * @return 跟单订单
     */
    @Override
    public List<TradeOrder> selectTradeOrderList(TradeOrder tradeOrder)
    {
        return tradeOrderMapper.selectTradeOrderList(tradeOrder);
    }

    /**
     * 新增跟单订单
     *
     * @param tradeOrder 跟单订单
     * @return 结果
     */
    @Override
    public int insertTradeOrder(TradeOrder tradeOrder) {
        tradeOrder.setCreateTime(null);
        return tradeOrderMapper.insertTradeOrder(tradeOrder);
    }

    /**
     * 修改跟单订单
     *
     * @param tradeOrder 跟单订单
     * @return 结果
     */
    @Override
    public int updateTradeOrder(TradeOrder tradeOrder) {
        tradeOrder.setUpdateTime(null);
        return tradeOrderMapper.updateTradeOrder(tradeOrder);
    }

    /**
     * 批量删除跟单订单
     *
     * @param ids 需要删除的跟单订单主键
     * @return 结果
     */
    @Override
    public int deleteTradeOrderByIds(Long[] ids)
    {
        return tradeOrderMapper.deleteTradeOrderByIds(ids);
    }

    /**
     * 删除跟单订单信息
     *
     * @param id 跟单订单主键
     * @return 结果
     */
    @Override
    public int deleteTradeOrderById(Long id)
    {
        return tradeOrderMapper.deleteTradeOrderById(id);
    }
}
