package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.CChainTxFlow;

/**
 * 扫块记录Service接口
 *
 * @author gpthk
 * @date 2024-11-01
 */
public interface ICChainTxFlowService {
    /**
     * 查询扫块记录
     *
     * @param id 扫块记录主键
     * @return 扫块记录
     */
    CChainTxFlow selectCChainTxFlowById(Long id);

    /**
     * 查询扫块记录列表
     *
     * @param cChainTxFlow 扫块记录
     * @return 扫块记录集合
     */
    List<CChainTxFlow> selectCChainTxFlowList(CChainTxFlow cChainTxFlow);

    /**
     * 新增扫块记录
     *
     * @param cChainTxFlow 扫块记录
     * @return 结果
     */
     int insertCChainTxFlow(CChainTxFlow cChainTxFlow);

    /**
     * 修改扫块记录
     *
     * @param cChainTxFlow 扫块记录
     * @return 结果
     */
     int updateCChainTxFlow(CChainTxFlow cChainTxFlow);

    /**
     * 批量删除扫块记录
     *
     * @param ids 需要删除的扫块记录主键集合
     * @return 结果
     */
     int deleteCChainTxFlowByIds(Long[] ids);

    /**
     * 删除扫块记录信息
     *
     * @param id 扫块记录主键
     * @return 结果
     */
     int deleteCChainTxFlowById(Long id);
}
