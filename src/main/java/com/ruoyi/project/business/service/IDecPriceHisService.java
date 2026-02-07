package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.DecPriceHis;

/**
 * 价格历史DService接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface IDecPriceHisService {
    /**
     * 查询价格历史D
     *
     * @param id 价格历史D主键
     * @return 价格历史D
     */
    DecPriceHis selectDecPriceHisById(Long id);

    /**
     * 查询价格历史D列表
     *
     * @param decPriceHis 价格历史D
     * @return 价格历史D集合
     */
    List<DecPriceHis> selectDecPriceHisList(DecPriceHis decPriceHis);

    /**
     * 新增价格历史D
     *
     * @param decPriceHis 价格历史D
     * @return 结果
     */
     int insertDecPriceHis(DecPriceHis decPriceHis);

    /**
     * 修改价格历史D
     *
     * @param decPriceHis 价格历史D
     * @return 结果
     */
     int updateDecPriceHis(DecPriceHis decPriceHis);

    /**
     * 批量删除价格历史D
     *
     * @param ids 需要删除的价格历史D主键集合
     * @return 结果
     */
     int deleteDecPriceHisByIds(Long[] ids);

    /**
     * 删除价格历史D信息
     *
     * @param id 价格历史D主键
     * @return 结果
     */
     int deleteDecPriceHisById(Long id);
}
