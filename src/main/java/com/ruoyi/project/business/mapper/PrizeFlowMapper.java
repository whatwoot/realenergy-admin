package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.PrizeFlow;

/**
 * 用户贡献明细Mapper接口
 *
 * @author gpthk
 * @date 2025-03-17
 */
public interface PrizeFlowMapper {
    /**
     * 查询用户贡献明细
     *
     * @param id 用户贡献明细主键
     * @return 用户贡献明细
     */
    PrizeFlow selectPrizeFlowById(Long id);

    /**
     * 查询用户贡献明细列表
     *
     * @param prizeFlow 用户贡献明细
     * @return 用户贡献明细集合
     */
    List<PrizeFlow> selectPrizeFlowList(PrizeFlow prizeFlow);

    /**
     * 新增用户贡献明细
     *
     * @param prizeFlow 用户贡献明细
     * @return 结果
     */
    int insertPrizeFlow(PrizeFlow prizeFlow);

    /**
     * 修改用户贡献明细
     *
     * @param prizeFlow 用户贡献明细
     * @return 结果
     */
    int updatePrizeFlow(PrizeFlow prizeFlow);

    /**
     * 删除用户贡献明细
     *
     * @param id 用户贡献明细主键
     * @return 结果
     */
    int deletePrizeFlowById(Long id);

    /**
     * 批量删除用户贡献明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePrizeFlowByIds(Long[] ids);

    List<PrizeFlow> listWithChildren(PrizeFlow entity);

    List<PrizeFlow> listWithParents(PrizeFlow entity);
}
