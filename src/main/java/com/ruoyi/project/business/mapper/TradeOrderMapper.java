package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.TradeOrder;

/**
 * 跟单订单Mapper接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface TradeOrderMapper {
    /**
     * 查询跟单订单
     *
     * @param id 跟单订单主键
     * @return 跟单订单
     */
    TradeOrder selectTradeOrderById(Long id);

    /**
     * 查询跟单订单列表
     *
     * @param tradeOrder 跟单订单
     * @return 跟单订单集合
     */
    List<TradeOrder> selectTradeOrderList(TradeOrder tradeOrder);

    /**
     * 新增跟单订单
     *
     * @param tradeOrder 跟单订单
     * @return 结果
     */
    int insertTradeOrder(TradeOrder tradeOrder);

    /**
     * 修改跟单订单
     *
     * @param tradeOrder 跟单订单
     * @return 结果
     */
    int updateTradeOrder(TradeOrder tradeOrder);

    /**
     * 删除跟单订单
     *
     * @param id 跟单订单主键
     * @return 结果
     */
    int deleteTradeOrderById(Long id);

    /**
     * 批量删除跟单订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTradeOrderByIds(Long[] ids);
}
