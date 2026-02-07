package com.ruoyi.project.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.project.business.domain.Asset;
import com.ruoyi.project.business.service.IAssetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户资产Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/business/asset")
public class AssetController extends BaseController
{
    @Autowired
    private IAssetService assetService;

    /**
     * 查询用户资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset:list')")
    @GetMapping("/list")
    public TableDataInfo list(Asset asset){
        startPage();
        List<Asset> list = null;
        if (asset.getUid() != null || StringUtils.hasText(asset.getAccount())) {
            if (Constants.ONE_INT.equals(asset.getRelate())) {
                list = assetService.listWithChildren(asset);
            } else if (Constants.ZERO_INT.equals(asset.getRelate())) {
                list = assetService.listWithParents(asset);
            }
        }
        if (list == null) {
            list = assetService.selectAssetList(asset);
        }
        return getDataTable(list);
    }


    /**
     * 导出用户资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:asset:export')")
    @Log(title = "用户资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Asset asset){
        List<Asset> list = null;
        if (asset.getUid() != null || StringUtils.hasText(asset.getAccount())) {
            if (Constants.ONE_INT.equals(asset.getRelate())) {
                list = assetService.listWithChildren(asset);
            } else if (Constants.ZERO_INT.equals(asset.getRelate())) {
                list = assetService.listWithParents(asset);
            }
        }
        if (list == null) {
            list = assetService.selectAssetList(asset);
        }
        ExcelUtil<Asset> util = new ExcelUtil<Asset>(Asset.class);
        util.exportExcel(response, list, "用户资产数据");
    }

    /**
     * 获取用户资产详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:asset:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(assetService.selectAssetById(id));
    }

    /**
     * 新增用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:asset:add')")
    @Log(title = "用户资产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Asset asset)
    {
        return toAjax(assetService.insertAsset(asset));
    }

    /**
     * 修改用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:asset:edit')")
    @Log(title = "用户资产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Asset asset)
    {
        return toAjax(assetService.updateAsset(asset));
    }

    /**
     * 删除用户资产
     */
    @PreAuthorize("@ss.hasPermi('business:asset:remove')")
    @Log(title = "用户资产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetService.deleteAssetByIds(ids));
    }
}
