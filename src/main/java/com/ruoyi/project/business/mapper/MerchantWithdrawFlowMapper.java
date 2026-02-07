package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantWithdrawFlow;

/**
 * 商家提现流水Mapper接口
 *
 * @author gpthk
 * @date 2025-03-27
 */
public interface MerchantWithdrawFlowMapper {
    /**
     * 查询商家提现流水
     *
     * @param id 商家提现流水主键
     * @return 商家提现流水
     */
    MerchantWithdrawFlow selectMerchantWithdrawFlowById(Long id);

    /**
     * 查询商家提现流水列表
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 商家提现流水集合
     */
    List<MerchantWithdrawFlow> selectMerchantWithdrawFlowList(MerchantWithdrawFlow merchantWithdrawFlow);

    /**
     * 新增商家提现流水
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 结果
     */
    int insertMerchantWithdrawFlow(MerchantWithdrawFlow merchantWithdrawFlow);

    /**
     * 修改商家提现流水
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 结果
     */
    int updateMerchantWithdrawFlow(MerchantWithdrawFlow merchantWithdrawFlow);

    /**
     * 删除商家提现流水
     *
     * @param id 商家提现流水主键
     * @return 结果
     */
    int deleteMerchantWithdrawFlowById(Long id);

    /**
     * 批量删除商家提现流水
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMerchantWithdrawFlowByIds(Long[] ids);

    List<MerchantWithdrawFlow> listWithChildren(MerchantWithdrawFlow entity);

    List<MerchantWithdrawFlow> listWithParents(MerchantWithdrawFlow entity);
}
