package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.TradeFlowMapper;
import com.ruoyi.project.business.domain.TradeFlow;
import com.ruoyi.project.business.service.ITradeFlowService;

/**
 * 交易流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-07
 */
@Service
public class TradeFlowServiceImpl implements ITradeFlowService {
    @Autowired
    private TradeFlowMapper tradeFlowMapper;

    /**
     * 查询交易流水
     *
     * @param id 交易流水主键
     * @return 交易流水
     */
    @Override
    public TradeFlow selectTradeFlowById(Long id)
    {
        return tradeFlowMapper.selectTradeFlowById(id);
    }

    /**
     * 查询交易流水列表
     *
     * @param tradeFlow 交易流水
     * @return 交易流水
     */
    @Override
    public List<TradeFlow> selectTradeFlowList(TradeFlow tradeFlow)
    {
        return tradeFlowMapper.selectTradeFlowList(tradeFlow);
    }

    /**
     * 新增交易流水
     *
     * @param tradeFlow 交易流水
     * @return 结果
     */
    @Override
    public int insertTradeFlow(TradeFlow tradeFlow) {
        tradeFlow.setCreateTime(null);
        return tradeFlowMapper.insertTradeFlow(tradeFlow);
    }

    /**
     * 修改交易流水
     *
     * @param tradeFlow 交易流水
     * @return 结果
     */
    @Override
    public int updateTradeFlow(TradeFlow tradeFlow) {
        return tradeFlowMapper.updateTradeFlow(tradeFlow);
    }

    /**
     * 批量删除交易流水
     *
     * @param ids 需要删除的交易流水主键
     * @return 结果
     */
    @Override
    public int deleteTradeFlowByIds(Long[] ids)
    {
        return tradeFlowMapper.deleteTradeFlowByIds(ids);
    }

    /**
     * 删除交易流水信息
     *
     * @param id 交易流水主键
     * @return 结果
     */
    @Override
    public int deleteTradeFlowById(Long id)
    {
        return tradeFlowMapper.deleteTradeFlowById(id);
    }
}
