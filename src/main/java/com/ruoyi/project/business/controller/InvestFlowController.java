package com.ruoyi.project.business.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.project.business.domain.ApplyFlow;
import com.ruoyi.project.business.service.IApplyFlowService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.domain.InvestFlow;
import com.ruoyi.project.business.service.IInvestFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

import static com.cs.sp.common.WebAssert.isNotNull;

/**
 * 理财记录Controller
 *
 * @author gpthk
 * @date 2025-11-05
 */
@RestController
@RequestMapping("/business/invest_flow")
public class InvestFlowController extends BaseController
{
    @Autowired
    private IInvestFlowService investFlowService;

    @Autowired
    private IApplyFlowService applyFlowService;


    /**
     * 审核权限需要获取
     * @return
     */
    @PreAuthorize("@ss.hasPermi('business:apply_flow:edit')")
    @GetMapping("/apply/list/{ids}")
    public TableDataInfo applyList(@PathVariable Long[] ids){
        List<InvestFlow> list;
        if(ids.length == 0){
            list = Collections.emptyList();
        }else{
            list = investFlowService.listByIds(Arrays.asList(ids));
        }
        return getDataTable(list);
    }

    /**
     * 查询理财记录列表
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(InvestFlow investFlow){
        startPage();
        List<InvestFlow> list = null;
        if (investFlow.getUid() != null || StringUtils.hasText(investFlow.getAccount())) {
            if (Constants.ONE_INT.equals(investFlow.getRelate())) {
                list = investFlowService.listWithChildren(investFlow);
            } else if (Constants.ZERO_INT.equals(investFlow.getRelate())) {
                list = investFlowService.listWithParents(investFlow);
            }
        }
        if (list == null) {
            list = investFlowService.selectInvestFlowList(investFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出理财记录列表
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:export')")
    @Log(title = "理财记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InvestFlow investFlow){
        List<InvestFlow> list = null;
        if (investFlow.getUid() != null || StringUtils.hasText(investFlow.getAccount())) {
            if (Constants.ONE_INT.equals(investFlow.getRelate())) {
                list = investFlowService.listWithChildren(investFlow);
            } else if (Constants.ZERO_INT.equals(investFlow.getRelate())) {
                list = investFlowService.listWithParents(investFlow);
            }
        }
        if (list == null) {
            list = investFlowService.selectInvestFlowList(investFlow);
        }
        ExcelUtil<InvestFlow> util = new ExcelUtil<InvestFlow>(InvestFlow.class);
        util.exportExcel(response, list, "理财记录数据");
    }

    /**
     * 获取理财记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(investFlowService.selectInvestFlowById(id));
    }

    /**
     * 新增理财记录
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:add')")
    @Log(title = "理财记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InvestFlow investFlow)
    {
        return toAjax(investFlowService.insertInvestFlow(investFlow));
    }

    /**
     * 修改理财记录
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:edit')")
    @Log(title = "理财记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InvestFlow investFlow)
    {
        return toAjax(investFlowService.updateInvestFlow(investFlow));
    }

    /**
     * 删除理财记录
     */
    @PreAuthorize("@ss.hasPermi('business:invest_flow:remove')")
    @Log(title = "理财记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(investFlowService.deleteInvestFlowByIds(ids));
    }
}
