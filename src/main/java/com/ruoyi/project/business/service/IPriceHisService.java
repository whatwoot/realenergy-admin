package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.PriceHis;

/**
 * 价格历史Service接口
 *
 * @author gpthk
 * @date 2025-12-31
 */
public interface IPriceHisService {
    /**
     * 查询价格历史
     *
     * @param id 价格历史主键
     * @return 价格历史
     */
    PriceHis selectPriceHisById(Long id);

    /**
     * 查询价格历史列表
     *
     * @param priceHis 价格历史
     * @return 价格历史集合
     */
    List<PriceHis> selectPriceHisList(PriceHis priceHis);

    /**
     * 新增价格历史
     *
     * @param priceHis 价格历史
     * @return 结果
     */
     int insertPriceHis(PriceHis priceHis);

    /**
     * 修改价格历史
     *
     * @param priceHis 价格历史
     * @return 结果
     */
     int updatePriceHis(PriceHis priceHis);

    /**
     * 批量删除价格历史
     *
     * @param ids 需要删除的价格历史主键集合
     * @return 结果
     */
     int deletePriceHisByIds(Long[] ids);

    /**
     * 删除价格历史信息
     *
     * @param id 价格历史主键
     * @return 结果
     */
     int deletePriceHisById(Long id);
}
