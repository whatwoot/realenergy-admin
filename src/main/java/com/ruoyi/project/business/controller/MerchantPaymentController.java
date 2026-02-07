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
import com.ruoyi.project.business.domain.MerchantPayment;
import com.ruoyi.project.business.service.IMerchantPaymentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商家收款方式Controller
 *
 * @author gpthk
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/business/merchant_payment")
public class MerchantPaymentController extends BaseController
{
    @Autowired
    private IMerchantPaymentService merchantPaymentService;

    /**
     * 查询商家收款方式列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:list')")
    @GetMapping("/list")
    public TableDataInfo list(MerchantPayment merchantPayment){
        startPage();
        List<MerchantPayment> list = null;
        if (merchantPayment.getUid() != null || StringUtils.hasText(merchantPayment.getAccount())) {
            if (Constants.ONE_INT.equals(merchantPayment.getRelate())) {
                list = merchantPaymentService.listWithChildren(merchantPayment);
            } else if (Constants.ZERO_INT.equals(merchantPayment.getRelate())) {
                list = merchantPaymentService.listWithParents(merchantPayment);
            }
        }
        if (list == null) {
            list = merchantPaymentService.selectMerchantPaymentList(merchantPayment);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家收款方式列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:export')")
    @Log(title = "商家收款方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantPayment merchantPayment){
        List<MerchantPayment> list = null;
        if (merchantPayment.getUid() != null || StringUtils.hasText(merchantPayment.getAccount())) {
            if (Constants.ONE_INT.equals(merchantPayment.getRelate())) {
                list = merchantPaymentService.listWithChildren(merchantPayment);
            } else if (Constants.ZERO_INT.equals(merchantPayment.getRelate())) {
                list = merchantPaymentService.listWithParents(merchantPayment);
            }
        }
        if (list == null) {
            list = merchantPaymentService.selectMerchantPaymentList(merchantPayment);
        }
        ExcelUtil<MerchantPayment> util = new ExcelUtil<MerchantPayment>(MerchantPayment.class);
        util.exportExcel(response, list, "商家收款方式数据");
    }

    /**
     * 获取商家收款方式详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(merchantPaymentService.selectMerchantPaymentById(id));
    }

    /**
     * 新增商家收款方式
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:add')")
    @Log(title = "商家收款方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerchantPayment merchantPayment)
    {
        return toAjax(merchantPaymentService.insertMerchantPayment(merchantPayment));
    }

    /**
     * 修改商家收款方式
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:edit')")
    @Log(title = "商家收款方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantPayment merchantPayment)
    {
        return toAjax(merchantPaymentService.updateMerchantPayment(merchantPayment));
    }

    /**
     * 删除商家收款方式
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_payment:remove')")
    @Log(title = "商家收款方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(merchantPaymentService.deleteMerchantPaymentByIds(ids));
    }
}
