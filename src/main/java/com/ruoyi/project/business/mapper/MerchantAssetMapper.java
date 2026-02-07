package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantAsset;

/**
 * 商家资产Mapper接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface MerchantAssetMapper {
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
     * 删除商家资产
     *
     * @param id 商家资产主键
     * @return 结果
     */
    int deleteMerchantAssetById(Long id);

    /**
     * 批量删除商家资产
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMerchantAssetByIds(Long[] ids);

    List<MerchantAsset> listWithChildren(MerchantAsset entity);

    List<MerchantAsset> listWithParents(MerchantAsset entity);
}
