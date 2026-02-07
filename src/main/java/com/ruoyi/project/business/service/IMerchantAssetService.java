package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantAsset;

/**
 * 商家资产Service接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface IMerchantAssetService {
    /**
     * 查询商家资产
     *
     * @param id 商家资产主键
     * @return 商家资产
     */
    MerchantAsset selectMerchantAssetById(Long id);

    /**
     * 查询商家资产列表
     *
     * @param merchantAsset 商家资产
     * @return 商家资产集合
     */
    List<MerchantAsset> selectMerchantAssetList(MerchantAsset merchantAsset);

    /**
     * 新增商家资产
     *
     * @param merchantAsset 商家资产
     * @return 结果
     */
     int insertMerchantAsset(MerchantAsset merchantAsset);

    /**
     * 修改商家资产
     *
     * @param merchantAsset 商家资产
     * @return 结果
     */
     int updateMerchantAsset(MerchantAsset merchantAsset);

    /**
     * 批量删除商家资产
     *
     * @param ids 需要删除的商家资产主键集合
     * @return 结果
     */
     int deleteMerchantAssetByIds(Long[] ids);

    /**
     * 删除商家资产信息
     *
     * @param id 商家资产主键
     * @return 结果
     */
     int deleteMerchantAssetById(Long id);

     List<MerchantAsset> listWithChildren(MerchantAsset entity);

     List<MerchantAsset> listWithParents(MerchantAsset entity);
}
