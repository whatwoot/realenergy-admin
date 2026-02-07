package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Asset;

/**
 * 用户资产Service接口
 *
 * @author gpthk
 * @date 2025-01-10
 */
public interface IAssetService {
    /**
     * 查询用户资产
     *
     * @param id 用户资产主键
     * @return 用户资产
     */
    Asset selectAssetById(Long id);

    /**
     * 查询用户资产列表
     *
     * @param asset 用户资产
     * @return 用户资产集合
     */
    List<Asset> selectAssetList(Asset asset);

    /**
     * 新增用户资产
     *
     * @param asset 用户资产
     * @return 结果
     */
     int insertAsset(Asset asset);

    /**
     * 修改用户资产
     *
     * @param asset 用户资产
     * @return 结果
     */
     int updateAsset(Asset asset);

    /**
     * 批量删除用户资产
     *
     * @param ids 需要删除的用户资产主键集合
     * @return 结果
     */
     int deleteAssetByIds(Long[] ids);

    /**
     * 删除用户资产信息
     *
     * @param id 用户资产主键
     * @return 结果
     */
     int deleteAssetById(Long id);

     List<Asset> listWithChildren(Asset entity);

     List<Asset> listWithParents(Asset entity);
}
