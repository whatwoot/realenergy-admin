package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Trader;

/**
 * 策略Service接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface ITraderService {
    /**
     * 查询策略
     *
     * @param id 策略主键
     * @return 策略
     */
    Trader selectTraderById(Long id);

    /**
     * 查询策略列表
     *
     * @param trader 策略
     * @return 策略集合
     */
    List<Trader> selectTraderList(Trader trader);

    /**
     * 新增策略
     *
     * @param trader 策略
     * @return 结果
     */
     int insertTrader(Trader trader);

    /**
     * 修改策略
     *
     * @param trader 策略
     * @return 结果
     */
     int updateTrader(Trader trader);

    /**
     * 批量删除策略
     *
     * @param ids 需要删除的策略主键集合
     * @return 结果
     */
     int deleteTraderByIds(Long[] ids);

    /**
     * 删除策略信息
     *
     * @param id 策略主键
     * @return 结果
     */
     int deleteTraderById(Long id);
}
