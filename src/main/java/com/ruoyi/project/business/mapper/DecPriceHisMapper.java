package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.DecPriceHis;

/**
 * 价格历史DMapper接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface DecPriceHisMapper {
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
     * 删除价格历史D
     *
     * @param id 价格历史D主键
     * @return 结果
     */
    int deleteDecPriceHisById(Long id);

    /**
     * 批量删除价格历史D
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteDecPriceHisByIds(Long[] ids);
}
