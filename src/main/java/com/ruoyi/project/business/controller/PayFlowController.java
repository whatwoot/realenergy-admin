package com.ruoyi.project.business.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.PayFlow;
import com.ruoyi.project.business.service.IPayFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * CNY支付流水Controller
 *
 * @author gpthk
 * @date 2025-11-12
 */
@RestController
@RequestMapping("/business/pay_flow")
public class PayFlowController extends BaseController {
    @Autowired
    private IPayFlowService payFlowService;

    /**
     * 查询CNY支付流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayFlow payFlow) {
        startPage();
        List<PayFlow> list = null;
        if (payFlow.getUid() != null || StringUtils.hasText(payFlow.getAccount())) {
            if (Constants.ONE_INT.equals(payFlow.getRelate())) {
                list = payFlowService.listWithChildren(payFlow);
            } else if (Constants.ZERO_INT.equals(payFlow.getRelate())) {
                list = payFlowService.listWithParents(payFlow);
            }
        }
        if (list == null) {
            list = payFlowService.selectPayFlowList(payFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出CNY支付流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:export')")
    @Log(title = "CNY支付流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayFlow payFlow) {
        List<PayFlow> list = null;
        if (payFlow.getUid() != null || StringUtils.hasText(payFlow.getAccount())) {
            if (Constants.ONE_INT.equals(payFlow.getRelate())) {
                list = payFlowService.listWithChildren(payFlow);
            } else if (Constants.ZERO_INT.equals(payFlow.getRelate())) {
                list = payFlowService.listWithParents(payFlow);
            }
        }
        if (list == null) {
            list = payFlowService.selectPayFlowList(payFlow);
        }
        ExcelUtil<PayFlow> util = new ExcelUtil<PayFlow>(PayFlow.class);
        util.exportExcel(response, list, "CNY支付流水数据");
    }

    /**
     * 获取CNY支付流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(payFlowService.selectPayFlowById(id));
    }

    /**
     * 新增CNY支付流水
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:add')")
    @Log(title = "CNY支付流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayFlow payFlow) {
        return toAjax(payFlowService.insertPayFlow(payFlow));
    }

    /**
     * 修改CNY支付流水
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:edit')")
    @Log(title = "CNY支付流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayFlow payFlow) {
        return toAjax(payFlowService.updatePayFlow(payFlow));
    }

    /**
     * 删除CNY支付流水
     */
    @PreAuthorize("@ss.hasPermi('business:pay_flow:remove')")
    @Log(title = "CNY支付流水", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(payFlowService.deletePayFlowByIds(ids));
    }


    @PreAuthorize("@ss.hasPermi('business:pay_flow:operOk')")
    @Log(title = "CNY支付流水", businessType = BusinessType.UPDATE)
    @PutMapping("/operOk/{ids}")
    public AjaxResult operOk(@PathVariable Long[] ids) {
        return toAjax(payFlowService.operateOk(ids));
    }

    @PreAuthorize("@ss.hasPermi('business:pay_flow:operRefund')")
    @Log(title = "CNY支付流水", businessType = BusinessType.UPDATE)
    @PutMapping("/operRefund/{ids}")
    public AjaxResult operRefund(@PathVariable Long[] ids) {
        return toAjax(payFlowService.operateRefund(ids));
    }
}
