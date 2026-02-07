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
import com.ruoyi.project.business.domain.ApplyFlow;
import com.ruoyi.project.business.service.IApplyFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 申请审核Controller
 *
 * @author gpthk
 * @date 2025-11-06
 */
@RestController
@RequestMapping("/business/apply_flow")
public class ApplyFlowController extends BaseController
{
    @Autowired
    private IApplyFlowService applyFlowService;

    /**
     * 查询申请审核列表
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApplyFlow applyFlow){
        startPage();
        List<ApplyFlow> list = null;
        if (applyFlow.getUid() != null || StringUtils.hasText(applyFlow.getAccount())) {
            if (Constants.ONE_INT.equals(applyFlow.getRelate())) {
                list = applyFlowService.listWithChildren(applyFlow);
            } else if (Constants.ZERO_INT.equals(applyFlow.getRelate())) {
                list = applyFlowService.listWithParents(applyFlow);
            }
        }
        if (list == null) {
            list = applyFlowService.selectApplyFlowList(applyFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出申请审核列表
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:export')")
    @Log(title = "申请审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApplyFlow applyFlow){
        List<ApplyFlow> list = null;
        if (applyFlow.getUid() != null || StringUtils.hasText(applyFlow.getAccount())) {
            if (Constants.ONE_INT.equals(applyFlow.getRelate())) {
                list = applyFlowService.listWithChildren(applyFlow);
            } else if (Constants.ZERO_INT.equals(applyFlow.getRelate())) {
                list = applyFlowService.listWithParents(applyFlow);
            }
        }
        if (list == null) {
            list = applyFlowService.selectApplyFlowList(applyFlow);
        }
        ExcelUtil<ApplyFlow> util = new ExcelUtil<ApplyFlow>(ApplyFlow.class);
        util.exportExcel(response, list, "申请审核数据");
    }

    /**
     * 获取申请审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(applyFlowService.selectApplyFlowById(id));
    }

    /**
     * 新增申请审核
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:add')")
    @Log(title = "申请审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApplyFlow applyFlow)
    {
        return toAjax(applyFlowService.insertApplyFlow(applyFlow));
    }

    /**
     * 修改申请审核
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:edit')")
    @Log(title = "申请审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApplyFlow applyFlow)
    {
        return toAjax(applyFlowService.updateApplyFlow(applyFlow));
    }

    /**
     * 删除申请审核
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:remove')")
    @Log(title = "申请审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(applyFlowService.deleteApplyFlowByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('business:apply_flow:audit')")
    @Log(title = "申请审核", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult audit(@RequestBody ApplyFlow applyFlow)
    {
        return toAjax(applyFlowService.updateAudit(applyFlow));
    }
}
