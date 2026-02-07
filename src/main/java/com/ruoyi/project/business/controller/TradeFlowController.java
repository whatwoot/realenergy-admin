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
import com.ruoyi.project.business.domain.TradeFlow;
import com.ruoyi.project.business.service.ITradeFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 交易流水Controller
 *
 * @author gpthk
 * @date 2025-11-07
 */
@RestController
@RequestMapping("/business/trade_flow")
public class TradeFlowController extends BaseController
{
    @Autowired
    private ITradeFlowService tradeFlowService;

    /**
     * 查询交易流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(TradeFlow tradeFlow)
    {
        startPage();
        List<TradeFlow> list = tradeFlowService.selectTradeFlowList(tradeFlow);
        return getDataTable(list);
    }

    /**
     * 导出交易流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:export')")
    @Log(title = "交易流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TradeFlow tradeFlow)
    {
        List<TradeFlow> list = tradeFlowService.selectTradeFlowList(tradeFlow);
        ExcelUtil<TradeFlow> util = new ExcelUtil<TradeFlow>(TradeFlow.class);
        util.exportExcel(response, list, "交易流水数据");
    }

    /**
     * 获取交易流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tradeFlowService.selectTradeFlowById(id));
    }

    /**
     * 新增交易流水
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:add')")
    @Log(title = "交易流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TradeFlow tradeFlow)
    {
        return toAjax(tradeFlowService.insertTradeFlow(tradeFlow));
    }

    /**
     * 修改交易流水
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:edit')")
    @Log(title = "交易流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TradeFlow tradeFlow)
    {
        return toAjax(tradeFlowService.updateTradeFlow(tradeFlow));
    }

    /**
     * 删除交易流水
     */
    @PreAuthorize("@ss.hasPermi('business:trade_flow:remove')")
    @Log(title = "交易流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tradeFlowService.deleteTradeFlowByIds(ids));
    }
}
