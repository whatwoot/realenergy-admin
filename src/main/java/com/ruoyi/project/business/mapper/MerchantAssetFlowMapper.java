package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantAssetFlow;
import com.ruoyi.project.business.dto.MerchantAssetFlowReportDTO;

/**
 * 商家资产流水Mapper接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface MerchantAssetFlowMapper {
    /**
     * 查询商家资产流水
     *
     * @param id 商家资产流水主键
     * @return 商家资产流水
     */
    MerchantAssetFlow selectMerchantAssetFlowById(Long id);

    /**
     * 查询商家资产流水列表
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 商家资产流水集合
     */
    List<MerchantAssetFlow> selectMerchantAssetFlowList(MerchantAssetFlow merchantAssetFlow);

    /**
     * 新增商家资产流水
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 结果
     */
    int insertMerchantAssetFlow(MerchantAssetFlow merchantAssetFlow);

    /**
     * 修改商家资产流水
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 结果
     */
    int updateMerchantAssetFlow(MerchantAssetFlow merchantAssetFlow);

    /**
     * 删除商家资产流水
     *
     * @param id 商家资产流水主键
     * @return 结果
     */
    int deleteMerchantAssetFlowById(Long id);

    /**
     * 批量删除商家资产流水
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMerchantAssetFlowByIds(Long[] ids);

    List<MerchantAssetFlow> listWithChildren(MerchantAssetFlow entity);

    List<MerchantAssetFlow> listWithParents(MerchantAssetFlow entity);

    List<MerchantAssetFlowReportDTO> listDailyReport(MerchantAssetFlow entity);

    List<MerchantAssetFlowReportDTO> listDailyReportWithChildren(MerchantAssetFlow assetFlow);
}
