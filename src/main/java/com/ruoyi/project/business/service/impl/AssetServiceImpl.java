package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.AssetMapper;
import com.ruoyi.project.business.domain.Asset;
import com.ruoyi.project.business.service.IAssetService;

/**
 * 用户资产Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Service
public class AssetServiceImpl implements IAssetService {
    @Autowired
    private AssetMapper assetMapper;

    /**
     * 查询用户资产
     *
     * @param id 用户资产主键
     * @return 用户资产
     */
    @Override
    public Asset selectAssetById(Long id)
    {
        return assetMapper.selectAssetById(id);
    }

    /**
     * 查询用户资产列表
     *
     * @param asset 用户资产
     * @return 用户资产
     */
    @Override
    public List<Asset> selectAssetList(Asset asset)
    {
        return assetMapper.selectAssetList(asset);
    }

    /**
     * 新增用户资产
     *
     * @param asset 用户资产
     * @return 结果
     */
    @Override
    public int insertAsset(Asset asset) {
        asset.setCreateTime(null);
        return assetMapper.insertAsset(asset);
    }

    /**
     * 修改用户资产
     *
     * @param asset 用户资产
     * @return 结果
     */
    @Override
    public int updateAsset(Asset asset)
    {
        asset.setUpdateTime(null);
        return assetMapper.updateAsset(asset);
    }

    /**
     * 批量删除用户资产
     *
     * @param ids 需要删除的用户资产主键
     * @return 结果
     */
    @Override
    public int deleteAssetByIds(Long[] ids)
    {
        return assetMapper.deleteAssetByIds(ids);
    }

    /**
     * 删除用户资产信息
     *
     * @param id 用户资产主键
     * @return 结果
     */
    @Override
    public int deleteAssetById(Long id)
    {
        return assetMapper.deleteAssetById(id);
    }

    @Override
    public List<Asset> listWithChildren(Asset entity) {
        return assetMapper.listWithChildren(entity);
    }

    @Override
    public List<Asset> listWithParents(Asset  entity) {
        return assetMapper.listWithParents(entity);
    }
}
