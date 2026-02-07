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
import com.ruoyi.project.business.domain.TradeOrder;
import com.ruoyi.project.business.service.ITradeOrderService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 跟单订单Controller
 *
 * @author gpthk
 * @date 2026-01-05
 */
@RestController
@RequestMapping("/business/trade_order")
public class TradeOrderController extends BaseController
{
    @Autowired
    private ITradeOrderService tradeOrderService;

    /**
     * 查询跟单订单列表
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TradeOrder tradeOrder)
    {
        startPage();
        List<TradeOrder> list = tradeOrderService.selectTradeOrderList(tradeOrder);
        return getDataTable(list);
    }

    /**
     * 导出跟单订单列表
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:export')")
    @Log(title = "跟单订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TradeOrder tradeOrder)
    {
        List<TradeOrder> list = tradeOrderService.selectTradeOrderList(tradeOrder);
        ExcelUtil<TradeOrder> util = new ExcelUtil<TradeOrder>(TradeOrder.class);
        util.exportExcel(response, list, "跟单订单数据");
    }

    /**
     * 获取跟单订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tradeOrderService.selectTradeOrderById(id));
    }

    /**
     * 新增跟单订单
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:add')")
    @Log(title = "跟单订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TradeOrder tradeOrder)
    {
        return toAjax(tradeOrderService.insertTradeOrder(tradeOrder));
    }

    /**
     * 修改跟单订单
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:edit')")
    @Log(title = "跟单订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TradeOrder tradeOrder)
    {
        return toAjax(tradeOrderService.updateTradeOrder(tradeOrder));
    }

    /**
     * 删除跟单订单
     */
    @PreAuthorize("@ss.hasPermi('business:trade_order:remove')")
    @Log(title = "跟单订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tradeOrderService.deleteTradeOrderByIds(ids));
    }
}
