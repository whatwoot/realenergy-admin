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
import com.ruoyi.project.business.domain.WithdrawDetail;
import com.ruoyi.project.business.service.IWithdrawDetailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户提现明细Controller
 *
 * @author gpthk
 * @date 2025-01-08
 */
@RestController
@RequestMapping("/business/withdraw_detail")
public class WithdrawDetailController extends BaseController
{
    @Autowired
    private IWithdrawDetailService withdrawDetailService;

    /**
     * 查询用户提现明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(WithdrawDetail withdrawDetail){
        startPage();
        List<WithdrawDetail> list = null;
        if (withdrawDetail.getUid() != null || StringUtils.hasText(withdrawDetail.getAccount())) {
            if (Constants.ONE_INT.equals(withdrawDetail.getRelate())) {
                list = withdrawDetailService.listWithChildren(withdrawDetail);
            } else if (Constants.ZERO_INT.equals(withdrawDetail.getRelate())) {
                list = withdrawDetailService.listWithParents(withdrawDetail);
            }
        }
        if (list == null) {
            list = withdrawDetailService.selectWithdrawDetailList(withdrawDetail);
        }
        return getDataTable(list);
    }


    /**
     * 导出用户提现明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:export')")
    @Log(title = "用户提现明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WithdrawDetail withdrawDetail){
        List<WithdrawDetail> list = null;
        if (withdrawDetail.getUid() != null || StringUtils.hasText(withdrawDetail.getAccount())) {
            if (Constants.ONE_INT.equals(withdrawDetail.getRelate())) {
                list = withdrawDetailService.listWithChildren(withdrawDetail);
            } else if (Constants.ZERO_INT.equals(withdrawDetail.getRelate())) {
                list = withdrawDetailService.listWithParents(withdrawDetail);
            }
        }
        if (list == null) {
            list = withdrawDetailService.selectWithdrawDetailList(withdrawDetail);
        }
        ExcelUtil<WithdrawDetail> util = new ExcelUtil<WithdrawDetail>(WithdrawDetail.class);
        util.exportExcel(response, list, "用户提现明细数据");
    }

    /**
     * 获取用户提现明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(withdrawDetailService.selectWithdrawDetailById(id));
    }

    /**
     * 新增用户提现明细
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:add')")
    @Log(title = "用户提现明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WithdrawDetail withdrawDetail)
    {
        return toAjax(withdrawDetailService.insertWithdrawDetail(withdrawDetail));
    }

    /**
     * 新增用户提现明细重发
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:add')")
    @Log(title = "用户提现明细重发", businessType = BusinessType.INSERT)
    @PostMapping("/addCopy/{ids}")
    public AjaxResult addCopy(@PathVariable Long[] ids)
    {
        return toAjax(withdrawDetailService.addCopy(ids));
    }

    /**
     * 修改用户提现明细
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:edit')")
    @Log(title = "用户提现明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WithdrawDetail withdrawDetail)
    {
        return toAjax(withdrawDetailService.updateWithdrawDetail(withdrawDetail));
    }

    /**
     * 删除用户提现明细
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_detail:remove')")
    @Log(title = "用户提现明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(withdrawDetailService.deleteWithdrawDetailByIds(ids));
    }
}
