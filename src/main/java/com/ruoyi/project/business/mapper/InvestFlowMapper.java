package com.ruoyi.project.business.mapper;

import java.util.Collection;
import java.util.List;
import com.ruoyi.project.business.domain.InvestFlow;

/**
 * 理财记录Mapper接口
 *
 * @author gpthk
 * @date 2025-11-05
 */
public interface InvestFlowMapper {
    /**
     * 查询理财记录
     *
     * @param id 理财记录主键
     * @return 理财记录
     */
    InvestFlow selectInvestFlowById(Long id);

    /**
     * 查询理财记录列表
     *
     * @param investFlow 理财记录
     * @return 理财记录集合
     */
    List<InvestFlow> selectInvestFlowList(InvestFlow investFlow);

    /**
     * 新增理财记录
     *
     * @param investFlow 理财记录
     * @return 结果
     */
    int insertInvestFlow(InvestFlow investFlow);

    /**
     * 修改理财记录
     *
     * @param investFlow 理财记录
     * @return 结果
     */
    int updateInvestFlow(InvestFlow investFlow);

    /**
     * 删除理财记录
     *
     * @param id 理财记录主键
     * @return 结果
     */
    int deleteInvestFlowById(Long id);

    /**
     * 批量删除理财记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteInvestFlowByIds(Long[] ids);

    List<InvestFlow> listWithChildren(InvestFlow entity);

    List<InvestFlow> listWithParents(InvestFlow entity);

    List<InvestFlow> listByIds(Collection<Long> ids);
}
