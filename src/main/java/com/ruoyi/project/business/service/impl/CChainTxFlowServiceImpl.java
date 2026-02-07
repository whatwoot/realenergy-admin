package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.CChainTxFlowMapper;
import com.ruoyi.project.business.domain.CChainTxFlow;
import com.ruoyi.project.business.service.ICChainTxFlowService;

/**
 * 扫块记录Service业务层处理
 *
 * @author gpthk
 * @date 2024-11-01
 */
@Service
public class CChainTxFlowServiceImpl implements ICChainTxFlowService {
    @Autowired
    private CChainTxFlowMapper cChainTxFlowMapper;

    /**
     * 查询扫块记录
     *
     * @param id 扫块记录主键
     * @return 扫块记录
     */
    @Override
    public CChainTxFlow selectCChainTxFlowById(Long id)
    {
        return cChainTxFlowMapper.selectCChainTxFlowById(id);
    }

    /**
     * 查询扫块记录列表
     *
     * @param cChainTxFlow 扫块记录
     * @return 扫块记录
     */
    @Override
    public List<CChainTxFlow> selectCChainTxFlowList(CChainTxFlow cChainTxFlow)
    {
        return cChainTxFlowMapper.selectCChainTxFlowList(cChainTxFlow);
    }

    /**
     * 新增扫块记录
     *
     * @param cChainTxFlow 扫块记录
     * @return 结果
     */
    @Override
    public int insertCChainTxFlow(CChainTxFlow cChainTxFlow) {
        cChainTxFlow.setCreateTime(null);
        return cChainTxFlowMapper.insertCChainTxFlow(cChainTxFlow);
    }

    /**
     * 修改扫块记录
     *
     * @param cChainTxFlow 扫块记录
     * @return 结果
     */
    @Override
    public int updateCChainTxFlow(CChainTxFlow cChainTxFlow) {
        cChainTxFlow.setUpdateTime(null);
        return cChainTxFlowMapper.updateCChainTxFlow(cChainTxFlow);
    }

    /**
     * 批量删除扫块记录
     *
     * @param ids 需要删除的扫块记录主键
     * @return 结果
     */
    @Override
    public int deleteCChainTxFlowByIds(Long[] ids)
    {
        return cChainTxFlowMapper.deleteCChainTxFlowByIds(ids);
    }

    /**
     * 删除扫块记录信息
     *
     * @param id 扫块记录主键
     * @return 结果
     */
    @Override
    public int deleteCChainTxFlowById(Long id)
    {
        return cChainTxFlowMapper.deleteCChainTxFlowById(id);
    }
}
