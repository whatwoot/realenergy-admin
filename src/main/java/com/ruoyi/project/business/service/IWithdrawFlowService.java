package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.WithdrawFlow;

/**
 * 提现流水Service接口
 *
 * @author gpthk
 * @date 2025-01-10
 */
public interface IWithdrawFlowService {
    /**
     * 查询提现流水
     *
     * @param id 提现流水主键
     * @return 提现流水
     */
    WithdrawFlow selectWithdrawFlowById(Long id);

    /**
     * 查询提现流水列表
     *
     * @param withdrawFlow 提现流水
     * @return 提现流水集合
     */
    List<WithdrawFlow> selectWithdrawFlowList(WithdrawFlow withdrawFlow);

    /**
     * 新增提现流水
     *
     * @param withdrawFlow 提现流水
     * @return 结果
     */
     int insertWithdrawFlow(WithdrawFlow withdrawFlow);

    /**
     * 修改提现流水
     *
     * @param withdrawFlow 提现流水
     * @return 结果
     */
     int updateWithdrawFlow(WithdrawFlow withdrawFlow);

    /**
     * 批量删除提现流水
     *
     * @param ids 需要删除的提现流水主键集合
     * @return 结果
     */
     int deleteWithdrawFlowByIds(Long[] ids);

    /**
     * 删除提现流水信息
     *
     * @param id 提现流水主键
     * @return 结果
     */
     int deleteWithdrawFlowById(Long id);

     List<WithdrawFlow> listWithChildren(WithdrawFlow entity);

     List<WithdrawFlow> listWithParents(WithdrawFlow entity);

    int updateAudit(WithdrawFlow update);
}
