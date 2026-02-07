package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.TradeFlow;

/**
 * 交易流水Service接口
 *
 * @author gpthk
 * @date 2025-11-07
 */
public interface ITradeFlowService {
    /**
     * 查询交易流水
     *
     * @param id 交易流水主键
     * @return 交易流水
     */
    TradeFlow selectTradeFlowById(Long id);

    /**
     * 查询交易流水列表
     *
     * @param tradeFlow 交易流水
     * @return 交易流水集合
     */
    List<TradeFlow> selectTradeFlowList(TradeFlow tradeFlow);

    /**
     * 新增交易流水
     *
     * @param tradeFlow 交易流水
     * @return 结果
     */
     int insertTradeFlow(TradeFlow tradeFlow);

    /**
     * 修改交易流水
     *
     * @param tradeFlow 交易流水
     * @return 结果
     */
     int updateTradeFlow(TradeFlow tradeFlow);

    /**
     * 批量删除交易流水
     *
     * @param ids 需要删除的交易流水主键集合
     * @return 结果
     */
     int deleteTradeFlowByIds(Long[] ids);

    /**
     * 删除交易流水信息
     *
     * @param id 交易流水主键
     * @return 结果
     */
     int deleteTradeFlowById(Long id);
}
