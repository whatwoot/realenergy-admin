package com.ruoyi.project.business.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.MerchantAssetFlow;
import com.ruoyi.project.business.dto.MerchantAssetFlowReportDTO;
import com.ruoyi.project.business.service.IMerchantAssetFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商家资产流水Controller
 *
 * @author gpthk
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/business/merchant_asset_flow")
public class MerchantAssetFlowController extends BaseController {
    @Autowired
    private IMerchantAssetFlowService merchantAssetFlowService;

    /**
     * 查询商家资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(MerchantAssetFlow merchantAssetFlow) {
        startPage();
        List<MerchantAssetFlow> list = null;
        if (merchantAssetFlow.getUid() != null || StringUtils.hasText(merchantAssetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(merchantAssetFlow.getRelate())) {
                list = merchantAssetFlowService.listWithChildren(merchantAssetFlow);
            } else if (Constants.ZERO_INT.equals(merchantAssetFlow.getRelate())) {
                list = merchantAssetFlowService.listWithParents(merchantAssetFlow);
            }
        }
        if (list == null) {
            list = merchantAssetFlowService.selectMerchantAssetFlowList(merchantAssetFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:export')")
    @Log(title = "商家资产流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantAssetFlow merchantAssetFlow) {
        List<MerchantAssetFlow> list = null;
        if (merchantAssetFlow.getUid() != null || StringUtils.hasText(merchantAssetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(merchantAssetFlow.getRelate())) {
                list = merchantAssetFlowService.listWithChildren(merchantAssetFlow);
            } else if (Constants.ZERO_INT.equals(merchantAssetFlow.getRelate())) {
                list = merchantAssetFlowService.listWithParents(merchantAssetFlow);
            }
        }
        if (list == null) {
            list = merchantAssetFlowService.selectMerchantAssetFlowList(merchantAssetFlow);
        }
        ExcelUtil<MerchantAssetFlow> util = new ExcelUtil<MerchantAssetFlow>(MerchantAssetFlow.class);
        util.exportExcel(response, list, "商家资产流水数据");
    }

    /**
     * 获取商家资产流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(merchantAssetFlowService.selectMerchantAssetFlowById(id));
    }

    /**
     * 新增商家资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:add')")
    @Log(title = "商家资产流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerchantAssetFlow merchantAssetFlow) {
        return toAjax(merchantAssetFlowService.insertMerchantAssetFlow(merchantAssetFlow));
    }

    /**
     * 修改商家资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:edit')")
    @Log(title = "商家资产流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantAssetFlow merchantAssetFlow) {
        return toAjax(merchantAssetFlowService.updateMerchantAssetFlow(merchantAssetFlow));
    }

    /**
     * 删除商家资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:remove')")
    @Log(title = "商家资产流水", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(merchantAssetFlowService.deleteMerchantAssetFlowByIds(ids));
    }

    /**
     * 商户报表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:report')")
    @GetMapping("/report")
    public TableDataInfo report(MerchantAssetFlow assetFlow) {
        startPage();
        List<MerchantAssetFlowReportDTO> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = merchantAssetFlowService.listReportWithChildren(assetFlow);
            }
        }
        if (list == null) {
            list = merchantAssetFlowService.listDailyReport(assetFlow);
        }
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('business:merchant_asset_flow:report')")
    @Log(title = "商户报表", businessType = BusinessType.EXPORT)
    @PostMapping("/report/export")
    public void reportExport(HttpServletResponse response, MerchantAssetFlow assetFlow) {
        List<MerchantAssetFlowReportDTO> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = merchantAssetFlowService.listReportWithChildren(assetFlow);
            }
        }
        if (list == null) {
            list = merchantAssetFlowService.listDailyReport(assetFlow);
        }
        ExcelUtil<MerchantAssetFlowReportDTO> util = new ExcelUtil<>(MerchantAssetFlowReportDTO.class);
        util.exportExcel(response, list, "商户报表数据");
    }
}
