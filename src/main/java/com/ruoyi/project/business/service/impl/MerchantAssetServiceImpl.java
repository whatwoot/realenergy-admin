package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.MerchantAssetMapper;
import com.ruoyi.project.business.domain.MerchantAsset;
import com.ruoyi.project.business.service.IMerchantAssetService;

/**
 * 商家资产Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Service
public class MerchantAssetServiceImpl implements IMerchantAssetService {
    @Autowired
    private MerchantAssetMapper merchantAssetMapper;

    /**
     * 查询商家资产
     *
     * @param id 商家资产主键
     * @return 商家资产
     */
    @Override
    public MerchantAsset selectMerchantAssetById(Long id)
    {
        return merchantAssetMapper.selectMerchantAssetById(id);
    }

    /**
     * 查询商家资产列表
     *
     * @param merchantAsset 商家资产
     * @return 商家资产
     */
    @Override
    public List<MerchantAsset> selectMerchantAssetList(MerchantAsset merchantAsset)
    {
        return merchantAssetMapper.selectMerchantAssetList(merchantAsset);
    }

    /**
     * 新增商家资产
     *
     * @param merchantAsset 商家资产
     * @return 结果
     */
    @Override
    public int insertMerchantAsset(MerchantAsset merchantAsset) {
        merchantAsset.setCreateTime(null);
        return merchantAssetMapper.insertMerchantAsset(merchantAsset);
    }

    /**
     * 修改商家资产
     *
     * @param merchantAsset 商家资产
     * @return 结果
     */
    @Override
    public int updateMerchantAsset(MerchantAsset merchantAsset)
    {
        merchantAsset.setUpdateTime(null);
        return merchantAssetMapper.updateMerchantAsset(merchantAsset);
    }

    /**
     * 批量删除商家资产
     *
     * @param ids 需要删除的商家资产主键
     * @return 结果
     */
    @Override
    public int deleteMerchantAssetByIds(Long[] ids)
    {
        return merchantAssetMapper.deleteMerchantAssetByIds(ids);
    }

    /**
     * 删除商家资产信息
     *
     * @param id 商家资产主键
     * @return 结果
     */
    @Override
    public int deleteMerchantAssetById(Long id)
    {
        return merchantAssetMapper.deleteMerchantAssetById(id);
    }

    @Override
    public List<MerchantAsset> listWithChildren(MerchantAsset entity) {
        return merchantAssetMapper.listWithChildren(entity);
    }

    @Override
    public List<MerchantAsset> listWithParents(MerchantAsset  entity) {
        return merchantAssetMapper.listWithParents(entity);
    }
}
