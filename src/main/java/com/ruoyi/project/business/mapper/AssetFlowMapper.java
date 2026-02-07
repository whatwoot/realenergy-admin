package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.AssetFlow;
import com.ruoyi.project.business.dto.AssetFlowGroupDTO;

/**
 * 用户资产流水Mapper接口
 *
 * @author gpthk
 * @date 2025-01-10
 */
public interface AssetFlowMapper {
    /**
     * 查询用户资产流水
     *
     * @param id 用户资产流水主键
     * @return 用户资产流水
     */
    AssetFlow selectAssetFlowById(Long id);

    /**
     * 查询用户资产流水列表
     *
     * @param assetFlow 用户资产流水
     * @return 用户资产流水集合
     */
    List<AssetFlow> selectAssetFlowList(AssetFlow assetFlow);

    /**
     * 新增用户资产流水
     *
     * @param assetFlow 用户资产流水
     * @return 结果
     */
    int insertAssetFlow(AssetFlow assetFlow);

    /**
     * 修改用户资产流水
     *
     * @param assetFlow 用户资产流水
     * @return 结果
     */
    int updateAssetFlow(AssetFlow assetFlow);

    /**
     * 删除用户资产流水
     *
     * @param id 用户资产流水主键
     * @return 结果
     */
    int deleteAssetFlowById(Long id);

    /**
     * 批量删除用户资产流水
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAssetFlowByIds(Long[] ids);

    List<AssetFlow> listWithChildren(AssetFlow entity);

    List<AssetFlow> listWithParents(AssetFlow entity);

    List<AssetFlowGroupDTO> listDailyWithChildren(AssetFlow assetFlow);

    List<AssetFlowGroupDTO> listDailyWithParents(AssetFlow assetFlow);

    List<AssetFlowGroupDTO> selectDailyAssetFlowList(AssetFlow assetFlow);
}
