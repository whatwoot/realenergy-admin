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
import com.ruoyi.project.business.domain.MerchantWithdrawFlow;
import com.ruoyi.project.business.service.IMerchantWithdrawFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商家提现流水Controller
 *
 * @author gpthk
 * @date 2025-03-27
 */
@RestController
@RequestMapping("/business/merchant_withdraw_flow")
public class MerchantWithdrawFlowController extends BaseController
{
    @Autowired
    private IMerchantWithdrawFlowService merchantWithdrawFlowService;

    /**
     * 查询商家提现流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(MerchantWithdrawFlow merchantWithdrawFlow){
        startPage();
        List<MerchantWithdrawFlow> list = null;
        if (merchantWithdrawFlow.getUid() != null || StringUtils.hasText(merchantWithdrawFlow.getAccount())) {
            if (Constants.ONE_INT.equals(merchantWithdrawFlow.getRelate())) {
                list = merchantWithdrawFlowService.listWithChildren(merchantWithdrawFlow);
            } else if (Constants.ZERO_INT.equals(merchantWithdrawFlow.getRelate())) {
                list = merchantWithdrawFlowService.listWithParents(merchantWithdrawFlow);
            }
        }
        if (list == null) {
            list = merchantWithdrawFlowService.selectMerchantWithdrawFlowList(merchantWithdrawFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家提现流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:export')")
    @Log(title = "商家提现流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantWithdrawFlow merchantWithdrawFlow){
        List<MerchantWithdrawFlow> list = null;
        if (merchantWithdrawFlow.getUid() != null || StringUtils.hasText(merchantWithdrawFlow.getAccount())) {
            if (Constants.ONE_INT.equals(merchantWithdrawFlow.getRelate())) {
                list = merchantWithdrawFlowService.listWithChildren(merchantWithdrawFlow);
            } else if (Constants.ZERO_INT.equals(merchantWithdrawFlow.getRelate())) {
                list = merchantWithdrawFlowService.listWithParents(merchantWithdrawFlow);
            }
        }
        if (list == null) {
            list = merchantWithdrawFlowService.selectMerchantWithdrawFlowList(merchantWithdrawFlow);
        }
        ExcelUtil<MerchantWithdrawFlow> util = new ExcelUtil<MerchantWithdrawFlow>(MerchantWithdrawFlow.class);
        util.exportExcel(response, list, "商家提现流水数据");
    }

    /**
     * 获取商家提现流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(merchantWithdrawFlowService.selectMerchantWithdrawFlowById(id));
    }

    /**
     * 新增商家提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:add')")
    @Log(title = "商家提现流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerchantWithdrawFlow merchantWithdrawFlow)
    {
        return toAjax(merchantWithdrawFlowService.insertMerchantWithdrawFlow(merchantWithdrawFlow));
    }

    /**
     * 修改商家提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:edit')")
    @Log(title = "商家提现流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantWithdrawFlow merchantWithdrawFlow)
    {
        return toAjax(merchantWithdrawFlowService.updateMerchantWithdrawFlow(merchantWithdrawFlow));
    }

    /**
     * 删除商家提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:remove')")
    @Log(title = "商家提现流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(merchantWithdrawFlowService.deleteMerchantWithdrawFlowByIds(ids));
    }

    /**
     * 重试
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:edit')")
    @Log(title = "重试", businessType = BusinessType.UPDATE)
    @PutMapping("/retry")
    public AjaxResult retry(@RequestBody MerchantWithdrawFlow merchantWithdrawFlow)
    {
        merchantWithdrawFlow.setStatus(0L);
        merchantWithdrawFlow.setFailNum(0L);
        return toAjax(merchantWithdrawFlowService.updateMerchantWithdrawFlow(merchantWithdrawFlow));
    }

    /**
     * 重试
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:edit')")
    @Log(title = "退款", businessType = BusinessType.UPDATE)
    @PutMapping("/refund")
    public AjaxResult refund(@RequestBody MerchantWithdrawFlow merchantWithdrawFlow)
    {
        return toAjax(merchantWithdrawFlowService.updateRefund(merchantWithdrawFlow));
    }
}
