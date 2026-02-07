package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantPayment;

/**
 * 商家收款方式Service接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface IMerchantPaymentService {
    /**
     * 查询商家收款方式
     *
     * @param id 商家收款方式主键
     * @return 商家收款方式
     */
    MerchantPayment selectMerchantPaymentById(Long id);

    /**
     * 查询商家收款方式列表
     *
     * @param merchantPayment 商家收款方式
     * @return 商家收款方式集合
     */
    List<MerchantPayment> selectMerchantPaymentList(MerchantPayment merchantPayment);

    /**
     * 新增商家收款方式
     *
     * @param merchantPayment 商家收款方式
     * @return 结果
     */
     int insertMerchantPayment(MerchantPayment merchantPayment);

    /**
     * 修改商家收款方式
     *
     * @param merchantPayment 商家收款方式
     * @return 结果
     */
     int updateMerchantPayment(MerchantPayment merchantPayment);

    /**
     * 批量删除商家收款方式
     *
     * @param ids 需要删除的商家收款方式主键集合
     * @return 结果
     */
     int deleteMerchantPaymentByIds(Long[] ids);

    /**
     * 删除商家收款方式信息
     *
     * @param id 商家收款方式主键
     * @return 结果
     */
     int deleteMerchantPaymentById(Long id);

     List<MerchantPayment> listWithChildren(MerchantPayment entity);

     List<MerchantPayment> listWithParents(MerchantPayment entity);
}
