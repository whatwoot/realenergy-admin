package com.ruoyi.project.business.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.InvestFlowMapper;
import com.ruoyi.project.business.domain.InvestFlow;
import com.ruoyi.project.business.service.IInvestFlowService;

/**
 * 理财记录Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-05
 */
@Service
public class InvestFlowServiceImpl implements IInvestFlowService {
    @Autowired
    private InvestFlowMapper investFlowMapper;

    /**
     * 查询理财记录
     *
     * @param id 理财记录主键
     * @return 理财记录
     */
    @Override
    public InvestFlow selectInvestFlowById(Long id)
    {
        return investFlowMapper.selectInvestFlowById(id);
    }

    /**
     * 查询理财记录列表
     *
     * @param investFlow 理财记录
     * @return 理财记录
     */
    @Override
    public List<InvestFlow> selectInvestFlowList(InvestFlow investFlow)
    {
        return investFlowMapper.selectInvestFlowList(investFlow);
    }

    /**
     * 新增理财记录
     *
     * @param investFlow 理财记录
     * @return 结果
     */
    @Override
    public int insertInvestFlow(InvestFlow investFlow) {
        investFlow.setCreateTime(null);
        return investFlowMapper.insertInvestFlow(investFlow);
    }

    /**
     * 修改理财记录
     *
     * @param investFlow 理财记录
     * @return 结果
     */
    @Override
    public int updateInvestFlow(InvestFlow investFlow)
    {
        investFlow.setUpdateTime(null);
        return investFlowMapper.updateInvestFlow(investFlow);
    }

    /**
     * 批量删除理财记录
     *
     * @param ids 需要删除的理财记录主键
     * @return 结果
     */
    @Override
    public int deleteInvestFlowByIds(Long[] ids)
    {
        return investFlowMapper.deleteInvestFlowByIds(ids);
    }

    /**
     * 删除理财记录信息
     *
     * @param id 理财记录主键
     * @return 结果
     */
    @Override
    public int deleteInvestFlowById(Long id)
    {
        return investFlowMapper.deleteInvestFlowById(id);
    }

    @Override
    public List<InvestFlow> listWithChildren(InvestFlow entity) {
        return investFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<InvestFlow> listWithParents(InvestFlow  entity) {
        return investFlowMapper.listWithParents(entity);
    }

    @Override
    public List<InvestFlow> listByIds(Collection<Long> ids) {
        return investFlowMapper.listByIds(ids);
    }
}
