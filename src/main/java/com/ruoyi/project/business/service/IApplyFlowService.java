package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.ApplyFlow;

/**
 * 申请审核Service接口
 *
 * @author gpthk
 * @date 2025-11-06
 */
public interface IApplyFlowService {
    /**
     * 查询申请审核
     *
     * @param id 申请审核主键
     * @return 申请审核
     */
    ApplyFlow selectApplyFlowById(Long id);

    /**
     * 查询申请审核列表
     *
     * @param applyFlow 申请审核
     * @return 申请审核集合
     */
    List<ApplyFlow> selectApplyFlowList(ApplyFlow applyFlow);

    /**
     * 新增申请审核
     *
     * @param applyFlow 申请审核
     * @return 结果
     */
     int insertApplyFlow(ApplyFlow applyFlow);

    /**
     * 修改申请审核
     *
     * @param applyFlow 申请审核
     * @return 结果
     */
     int updateApplyFlow(ApplyFlow applyFlow);

    /**
     * 批量删除申请审核
     *
     * @param ids 需要删除的申请审核主键集合
     * @return 结果
     */
     int deleteApplyFlowByIds(Long[] ids);

    /**
     * 删除申请审核信息
     *
     * @param id 申请审核主键
     * @return 结果
     */
     int deleteApplyFlowById(Long id);

     List<ApplyFlow> listWithChildren(ApplyFlow entity);

     List<ApplyFlow> listWithParents(ApplyFlow entity);

    int updateAudit(ApplyFlow applyFlow);
}
