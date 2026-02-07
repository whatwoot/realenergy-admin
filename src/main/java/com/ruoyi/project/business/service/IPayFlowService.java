package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.PayFlow;

/**
 * CNY支付流水Service接口
 *
 * @author gpthk
 * @date 2025-11-12
 */
public interface IPayFlowService {
    /**
     * 查询CNY支付流水
     *
     * @param id CNY支付流水主键
     * @return CNY支付流水
     */
    PayFlow selectPayFlowById(Long id);

    /**
     * 查询CNY支付流水列表
     *
     * @param payFlow CNY支付流水
     * @return CNY支付流水集合
     */
    List<PayFlow> selectPayFlowList(PayFlow payFlow);

    /**
     * 新增CNY支付流水
     *
     * @param payFlow CNY支付流水
     * @return 结果
     */
     int insertPayFlow(PayFlow payFlow);

    /**
     * 修改CNY支付流水
     *
     * @param payFlow CNY支付流水
     * @return 结果
     */
     int updatePayFlow(PayFlow payFlow);

    /**
     * 批量删除CNY支付流水
     *
     * @param ids 需要删除的CNY支付流水主键集合
     * @return 结果
     */
     int deletePayFlowByIds(Long[] ids);

    /**
     * 删除CNY支付流水信息
     *
     * @param id CNY支付流水主键
     * @return 结果
     */
     int deletePayFlowById(Long id);

     List<PayFlow> listWithChildren(PayFlow entity);

     List<PayFlow> listWithParents(PayFlow entity);

    int operateOk(Long[] ids);

    int operateRefund(Long[] ids);
}
