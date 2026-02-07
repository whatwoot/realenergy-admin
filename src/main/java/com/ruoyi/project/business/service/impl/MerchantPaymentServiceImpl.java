package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.MerchantPaymentMapper;
import com.ruoyi.project.business.domain.MerchantPayment;
import com.ruoyi.project.business.service.IMerchantPaymentService;

/**
 * 商家收款方式Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Service
public class MerchantPaymentServiceImpl implements IMerchantPaymentService {
    @Autowired
    private MerchantPaymentMapper merchantPaymentMapper;

    /**
     * 查询商家收款方式
     *
     * @param id 商家收款方式主键
     * @return 商家收款方式
     */
    @Override
    public MerchantPayment selectMerchantPaymentById(Long id)
    {
        return merchantPaymentMapper.selectMerchantPaymentById(id);
    }

    /**
     * 查询商家收款方式列表
     *
     * @param merchantPayment 商家收款方式
     * @return 商家收款方式
     */
    @Override
    public List<MerchantPayment> selectMerchantPaymentList(MerchantPayment merchantPayment)
    {
        return merchantPaymentMapper.selectMerchantPaymentList(merchantPayment);
    }

    /**
     * 新增商家收款方式
     *
     * @param merchantPayment 商家收款方式
     * @return 结果
     */
    @Override
    public int insertMerchantPayment(MerchantPayment merchantPayment) {
        merchantPayment.setCreateTime(null);
        return merchantPaymentMapper.insertMerchantPayment(merchantPayment);
    }

    /**
     * 修改商家收款方式
     *
     * @param merchantPayment 商家收款方式
     * @return 结果
     */
    @Override
    public int updateMerchantPayment(MerchantPayment merchantPayment)
    {
        merchantPayment.setUpdateTime(null);
        return merchantPaymentMapper.updateMerchantPayment(merchantPayment);
    }

    /**
     * 批量删除商家收款方式
     *
     * @param ids 需要删除的商家收款方式主键
     * @return 结果
     */
    @Override
    public int deleteMerchantPaymentByIds(Long[] ids)
    {
        return merchantPaymentMapper.deleteMerchantPaymentByIds(ids);
    }

    /**
     * 删除商家收款方式信息
     *
     * @param id 商家收款方式主键
     * @return 结果
     */
    @Override
    public int deleteMerchantPaymentById(Long id)
    {
        return merchantPaymentMapper.deleteMerchantPaymentById(id);
    }

    @Override
    public List<MerchantPayment> listWithChildren(MerchantPayment entity) {
        return merchantPaymentMapper.listWithChildren(entity);
    }

    @Override
    public List<MerchantPayment> listWithParents(MerchantPayment  entity) {
        return merchantPaymentMapper.listWithParents(entity);
    }
}
