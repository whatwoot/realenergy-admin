package com.ruoyi.project.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.business.dto.AssetFlowGroupDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.domain.AssetFlow;
import com.ruoyi.project.business.service.IAssetFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户资产流水Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/business/asset_flow")
public class AssetFlowController extends BaseController
{
    @Autowired
    private IAssetFlowService assetFlowService;

    /**
     * 查询用户资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:report')")
    @GetMapping("/dailyList")
    public TableDataInfo dailyList(AssetFlow assetFlow){
        startPage();
        List<AssetFlowGroupDTO> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listDailyWithChildren(assetFlow);
            } else if (Constants.ZERO_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listDailyWithParents(assetFlow);
            }
        }
        if (list == null) {
            list = assetFlowService.selectDailyAssetFlowList(assetFlow);
        }
        return getDataTable(list);
    }

    /**
     * 导出用户资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:report')")
    @Log(title = "用户流水报表导出", businessType = BusinessType.EXPORT)
    @PostMapping("/dailyList/export")
    public void dailyListExport(HttpServletResponse response, AssetFlow assetFlow){
        List<AssetFlowGroupDTO> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listDailyWithChildren(assetFlow);
            } else if (Constants.ZERO_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listDailyWithParents(assetFlow);
            }
        }
        if (list == null) {
            list = assetFlowService.selectDailyAssetFlowList(assetFlow);
        }
        ExcelUtil<AssetFlowGroupDTO> util = new ExcelUtil<>(AssetFlowGroupDTO.class);
        util.exportExcel(response, list, "用户流水报表");
    }

    /**
     * 查询用户资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetFlow assetFlow){
        startPage();
        List<AssetFlow> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listWithChildren(assetFlow);
            } else if (Constants.ZERO_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listWithParents(assetFlow);
            }
        }
        if (list == null) {
            list = assetFlowService.selectAssetFlowList(assetFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出用户资产流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:export')")
    @Log(title = "用户资产流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssetFlow assetFlow){
        List<AssetFlow> list = null;
        if (assetFlow.getUid() != null || StringUtils.hasText(assetFlow.getAccount())) {
            if (Constants.ONE_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listWithChildren(assetFlow);
            } else if (Constants.ZERO_INT.equals(assetFlow.getRelate())) {
                list = assetFlowService.listWithParents(assetFlow);
            }
        }
        if (list == null) {
            list = assetFlowService.selectAssetFlowList(assetFlow);
        }
        ExcelUtil<AssetFlow> util = new ExcelUtil<AssetFlow>(AssetFlow.class);
        util.exportExcel(response, list, "用户资产流水数据");
    }

    /**
     * 获取用户资产流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetFlowService.selectAssetFlowById(id));
    }

    /**
     * 新增用户资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:add')")
    @Log(title = "用户资产流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetFlow assetFlow)
    {
        return toAjax(assetFlowService.insertAssetFlow(assetFlow));
    }

    /**
     * 修改用户资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:edit')")
    @Log(title = "用户资产流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetFlow assetFlow)
    {
        return toAjax(assetFlowService.updateAssetFlow(assetFlow));
    }

    /**
     * 删除用户资产流水
     */
    @PreAuthorize("@ss.hasPermi('business:asset_flow:remove')")
    @Log(title = "用户资产流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetFlowService.deleteAssetFlowByIds(ids));
    }
}
