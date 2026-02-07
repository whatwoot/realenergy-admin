package com.ruoyi.project.business.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.MerchantApply;
import com.ruoyi.project.business.dto.BatchAuditRequest;
import com.ruoyi.project.business.service.IMerchantApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商家申请Controller
 *
 * @author gpthk
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/business/merchant_apply")
public class MerchantApplyController extends BaseController {
    @Autowired
    private IMerchantApplyService merchantApplyService;

    /**
     * 查询商家申请列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(MerchantApply merchantApply) {
        startPage();
        List<MerchantApply> list = null;
        if (merchantApply.getUid() != null || StringUtils.hasText(merchantApply.getAccount())) {
            if (Constants.ONE_INT.equals(merchantApply.getRelate())) {
                list = merchantApplyService.listWithChildren(merchantApply);
            } else if (Constants.ZERO_INT.equals(merchantApply.getRelate())) {
                list = merchantApplyService.listWithParents(merchantApply);
            }
        }
        if (list == null) {
            list = merchantApplyService.selectMerchantApplyList(merchantApply);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家申请列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:export')")
    @Log(title = "商家申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantApply merchantApply) {
        List<MerchantApply> list = null;
        if (merchantApply.getUid() != null || StringUtils.hasText(merchantApply.getAccount())) {
            if (Constants.ONE_INT.equals(merchantApply.getRelate())) {
                list = merchantApplyService.listWithChildren(merchantApply);
            } else if (Constants.ZERO_INT.equals(merchantApply.getRelate())) {
                list = merchantApplyService.listWithParents(merchantApply);
            }
        }
        if (list == null) {
            list = merchantApplyService.selectMerchantApplyList(merchantApply);
        }
        ExcelUtil<MerchantApply> util = new ExcelUtil<MerchantApply>(MerchantApply.class);
        util.exportExcel(response, list, "商家申请数据");
    }

    /**
     * 获取商家申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(merchantApplyService.selectMerchantApplyById(id));
    }

    /**
     * 新增商家申请
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:add')")
    @Log(title = "商家申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerchantApply merchantApply) {
        return toAjax(merchantApplyService.insertMerchantApply(merchantApply));
    }

    /**
     * 修改商家申请
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:edit')")
    @Log(title = "商家申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantApply merchantApply) {
        return toAjax(merchantApplyService.updateMerchantApply(merchantApply));
    }

    /**
     * 删除商家申请
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:remove')")
    @Log(title = "商家申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(merchantApplyService.deleteMerchantApplyByIds(ids));
    }


    /**
     * 批量同意商家申请
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_apply:edit')")
    @Log(title = "批准商家申请", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult audit(@RequestBody BatchAuditRequest req) {
        MerchantApply merchantApply = new MerchantApply();
        merchantApply.setStatus(req.getStatus());
        merchantApply.setMessage(req.getMessage());
        return success(merchantApplyService.updateBatch(merchantApply, req.getIds()));
    }
}
