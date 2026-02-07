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
import com.ruoyi.project.business.domain.Trader;
import com.ruoyi.project.business.service.ITraderService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 策略Controller
 *
 * @author gpthk
 * @date 2026-01-05
 */
@RestController
@RequestMapping("/business/trader")
public class TraderController extends BaseController
{
    @Autowired
    private ITraderService traderService;

    /**
     * 查询策略列表
     */
    @PreAuthorize("@ss.hasPermi('business:trader:list')")
    @GetMapping("/list")
    public TableDataInfo list(Trader trader)
    {
        startPage();
        List<Trader> list = traderService.selectTraderList(trader);
        return getDataTable(list);
    }

    /**
     * 导出策略列表
     */
    @PreAuthorize("@ss.hasPermi('business:trader:export')")
    @Log(title = "策略", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Trader trader)
    {
        List<Trader> list = traderService.selectTraderList(trader);
        ExcelUtil<Trader> util = new ExcelUtil<Trader>(Trader.class);
        util.exportExcel(response, list, "策略数据");
    }

    /**
     * 获取策略详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:trader:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(traderService.selectTraderById(id));
    }

    /**
     * 新增策略
     */
    @PreAuthorize("@ss.hasPermi('business:trader:add')")
    @Log(title = "策略", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Trader trader)
    {
        return toAjax(traderService.insertTrader(trader));
    }

    /**
     * 修改策略
     */
    @PreAuthorize("@ss.hasPermi('business:trader:edit')")
    @Log(title = "策略", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Trader trader)
    {
        return toAjax(traderService.updateTrader(trader));
    }

    /**
     * 删除策略
     */
    @PreAuthorize("@ss.hasPermi('business:trader:remove')")
    @Log(title = "策略", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(traderService.deleteTraderByIds(ids));
    }
}
