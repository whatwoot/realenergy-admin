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
import com.ruoyi.project.business.domain.MerchantAsset;
import com.ruoyi.project.business.service.IMerchantAssetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商家资产Controller
 *
 * @author gpthk
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/business/merchant_asset")
public class MerchantAssetController extends BaseController
{
    @Autowired
    private IMerchantAssetService merchantAssetService;

    /**
     * 查询商家资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:list')")
    @GetMapping("/list")
    public TableDataInfo list(MerchantAsset merchantAsset){
        startPage();
        List<MerchantAsset> list = null;
        if (merchantAsset.getUid() != null || StringUtils.hasText(merchantAsset.getAccount())) {
            if (Constants.ONE_INT.equals(merchantAsset.getRelate())) {
                list = merchantAssetService.listWithChildren(merchantAsset);
            } else if (Constants.ZERO_INT.equals(merchantAsset.getRelate())) {
                list = merchantAssetService.listWithParents(merchantAsset);
            }
        }
        if (list == null) {
            list = merchantAssetService.selectMerchantAssetList(merchantAsset);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家资产列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:export')")
    @Log(title = "商家资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantAsset merchantAsset){
        List<MerchantAsset> list = null;
        if (merchantAsset.getUid() != null || StringUtils.hasText(merchantAsset.getAccount())) {
            if (Constants.ONE_INT.equals(merchantAsset.getRelate())) {
                list = merchantAssetService.listWithChildren(merchantAsset);
            } else if (Constants.ZERO_INT.equals(merchantAsset.getRelate())) {
                list = merchantAssetService.listWithParents(merchantAsset);
            }
        }
        if (list == null) {
            list = merchantAssetService.selectMerchantAssetList(merchantAsset);
        }
        ExcelUtil<MerchantAsset> util = new ExcelUtil<MerchantAsset>(MerchantAsset.class);
        util.exportExcel(response, list, "商家资产数据");
    }

    /**
     * 获取商家资产详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(merchantAssetService.selectMerchantAssetById(id));
    }

    /**
     * 新增商家资产
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:add')")
    @Log(title = "商家资产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerchantAsset merchantAsset)
    {
        return toAjax(merchantAssetService.insertMerchantAsset(merchantAsset));
    }

    /**
     * 修改商家资产
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:edit')")
    @Log(title = "商家资产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantAsset merchantAsset)
    {
        return toAjax(merchantAssetService.updateMerchantAsset(merchantAsset));
    }

    /**
     * 删除商家资产
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_asset:remove')")
    @Log(title = "商家资产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(merchantAssetService.deleteMerchantAssetByIds(ids));
    }
}
