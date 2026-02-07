package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.project.business.dto.AssetFlowGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.AssetFlowMapper;
import com.ruoyi.project.business.domain.AssetFlow;
import com.ruoyi.project.business.service.IAssetFlowService;

/**
 * 用户资产流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Service
public class AssetFlowServiceImpl implements IAssetFlowService {
    @Autowired
    private AssetFlowMapper assetFlowMapper;

    /**
     * 查询用户资产流水
     *
     * @param id 用户资产流水主键
     * @return 用户资产流水
     */
    @Override
    public AssetFlow selectAssetFlowById(Long id)
    {
        return assetFlowMapper.selectAssetFlowById(id);
    }

    /**
     * 查询用户资产流水列表
     *
     * @param assetFlow 用户资产流水
     * @return 用户资产流水
     */
    @Override
    public List<AssetFlow> selectAssetFlowList(AssetFlow assetFlow)
    {
        return assetFlowMapper.selectAssetFlowList(assetFlow);
    }

    /**
     * 新增用户资产流水
     *
     * @param assetFlow 用户资产流水
     * @return 结果
     */
    @Override
    public int insertAssetFlow(AssetFlow assetFlow) {
        assetFlow.setCreateTime(null);
        return assetFlowMapper.insertAssetFlow(assetFlow);
    }

    /**
     * 修改用户资产流水
     *
     * @param assetFlow 用户资产流水
     * @return 结果
     */
    @Override
    public int updateAssetFlow(AssetFlow assetFlow)
    {
        return assetFlowMapper.updateAssetFlow(assetFlow);
    }

    /**
     * 批量删除用户资产流水
     *
     * @param ids 需要删除的用户资产流水主键
     * @return 结果
     */
    @Override
    public int deleteAssetFlowByIds(Long[] ids)
    {
        return assetFlowMapper.deleteAssetFlowByIds(ids);
    }

    /**
     * 删除用户资产流水信息
     *
     * @param id 用户资产流水主键
     * @return 结果
     */
    @Override
    public int deleteAssetFlowById(Long id)
    {
        return assetFlowMapper.deleteAssetFlowById(id);
    }

    @Override
    public List<AssetFlow> listWithChildren(AssetFlow entity) {
        return assetFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<AssetFlow> listWithParents(AssetFlow  entity) {
        return assetFlowMapper.listWithParents(entity);
    }

    @Override
    public List<AssetFlowGroupDTO> listDailyWithChildren(AssetFlow assetFlow) {
        return assetFlowMapper.listDailyWithChildren(assetFlow);
    }

    @Override
    public List<AssetFlowGroupDTO> listDailyWithParents(AssetFlow assetFlow) {
        return assetFlowMapper.listDailyWithParents(assetFlow);
    }

    @Override
    public List<AssetFlowGroupDTO> selectDailyAssetFlowList(AssetFlow assetFlow) {
        return assetFlowMapper.selectDailyAssetFlowList(assetFlow);
    }
}
