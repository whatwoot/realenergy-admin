package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.MerchantMapper;
import com.ruoyi.project.business.domain.Merchant;
import com.ruoyi.project.business.service.IMerchantService;

/**
 * 商家列表Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 查询商家列表
     *
     * @param id 商家列表主键
     * @return 商家列表
     */
    @Override
    public Merchant selectMerchantById(Long id)
    {
        return merchantMapper.selectMerchantById(id);
    }

    /**
     * 查询商家列表列表
     *
     * @param merchant 商家列表
     * @return 商家列表
     */
    @Override
    public List<Merchant> selectMerchantList(Merchant merchant)
    {
        return merchantMapper.selectMerchantList(merchant);
    }

    /**
     * 新增商家列表
     *
     * @param merchant 商家列表
     * @return 结果
     */
    @Override
    public int insertMerchant(Merchant merchant) {
        merchant.setCreateTime(null);
        return merchantMapper.insertMerchant(merchant);
    }

    /**
     * 修改商家列表
     *
     * @param merchant 商家列表
     * @return 结果
     */
    @Override
    public int updateMerchant(Merchant merchant)
    {
        merchant.setUpdateTime(null);
        return merchantMapper.updateMerchant(merchant);
    }

    /**
     * 批量删除商家列表
     *
     * @param ids 需要删除的商家列表主键
     * @return 结果
     */
    @Override
    public int deleteMerchantByIds(Long[] ids)
    {
        return merchantMapper.deleteMerchantByIds(ids);
    }

    /**
     * 删除商家列表信息
     *
     * @param id 商家列表主键
     * @return 结果
     */
    @Override
    public int deleteMerchantById(Long id)
    {
        return merchantMapper.deleteMerchantById(id);
    }

    @Override
    public List<Merchant> listWithChildren(Merchant entity) {
        return merchantMapper.listWithChildren(entity);
    }

    @Override
    public List<Merchant> listWithParents(Merchant  entity) {
        return merchantMapper.listWithParents(entity);
    }

    @Override
    public int updateBatch(Merchant merchant, List<Long> ids) {
        return merchantMapper.updateBatch(merchant, ids);
    }
}
