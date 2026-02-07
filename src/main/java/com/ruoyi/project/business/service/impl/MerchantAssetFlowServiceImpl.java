package com.ruoyi.project.business.service.impl;

import java.util.Collections;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.business.dto.MerchantAssetFlowReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.MerchantAssetFlowMapper;
import com.ruoyi.project.business.domain.MerchantAssetFlow;
import com.ruoyi.project.business.service.IMerchantAssetFlowService;

/**
 * 商家资产流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Service
public class MerchantAssetFlowServiceImpl implements IMerchantAssetFlowService {
    @Autowired
    private MerchantAssetFlowMapper merchantAssetFlowMapper;

    /**
     * 查询商家资产流水
     *
     * @param id 商家资产流水主键
     * @return 商家资产流水
     */
    @Override
    public MerchantAssetFlow selectMerchantAssetFlowById(Long id)
    {
        return merchantAssetFlowMapper.selectMerchantAssetFlowById(id);
    }

    /**
     * 查询商家资产流水列表
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 商家资产流水
     */
    @Override
    public List<MerchantAssetFlow> selectMerchantAssetFlowList(MerchantAssetFlow merchantAssetFlow)
    {
        return merchantAssetFlowMapper.selectMerchantAssetFlowList(merchantAssetFlow);
    }

    /**
     * 新增商家资产流水
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 结果
     */
    @Override
    public int insertMerchantAssetFlow(MerchantAssetFlow merchantAssetFlow) {
        merchantAssetFlow.setCreateTime(null);
        return merchantAssetFlowMapper.insertMerchantAssetFlow(merchantAssetFlow);
    }

    /**
     * 修改商家资产流水
     *
     * @param merchantAssetFlow 商家资产流水
     * @return 结果
     */
    @Override
    public int updateMerchantAssetFlow(MerchantAssetFlow merchantAssetFlow)
    {
        return merchantAssetFlowMapper.updateMerchantAssetFlow(merchantAssetFlow);
    }

    /**
     * 批量删除商家资产流水
     *
     * @param ids 需要删除的商家资产流水主键
     * @return 结果
     */
    @Override
    public int deleteMerchantAssetFlowByIds(Long[] ids)
    {
        return merchantAssetFlowMapper.deleteMerchantAssetFlowByIds(ids);
    }

    /**
     * 删除商家资产流水信息
     *
     * @param id 商家资产流水主键
     * @return 结果
     */
    @Override
    public int deleteMerchantAssetFlowById(Long id)
    {
        return merchantAssetFlowMapper.deleteMerchantAssetFlowById(id);
    }

    @Override
    public List<MerchantAssetFlow> listWithChildren(MerchantAssetFlow entity) {
        return merchantAssetFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<MerchantAssetFlow> listWithParents(MerchantAssetFlow  entity) {
        return merchantAssetFlowMapper.listWithParents(entity);
    }

    @Override
    public List<MerchantAssetFlowReportDTO> listDailyReport(MerchantAssetFlow entity) {
        return merchantAssetFlowMapper.listDailyReport(entity);
    }

    @Override
    public List<MerchantAssetFlowReportDTO> listReportWithChildren(MerchantAssetFlow assetFlow) {
        return merchantAssetFlowMapper.listDailyReportWithChildren(assetFlow);
    }
}
