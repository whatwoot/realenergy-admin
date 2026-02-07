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
import com.ruoyi.project.business.domain.Symbol;
import com.ruoyi.project.business.service.ISymbolService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 代币表Controller
 *
 * @author gpthk
 * @date 2025-03-22
 */
@RestController
@RequestMapping("/business/symbol")
public class SymbolController extends BaseController
{
    @Autowired
    private ISymbolService symbolService;

    /**
     * 查询代币表列表
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:list')")
    @GetMapping("/list")
    public TableDataInfo list(Symbol symbol)
    {
        startPage();
        List<Symbol> list = symbolService.selectSymbolList(symbol);
        return getDataTable(list);
    }

    /**
     * 导出代币表列表
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:export')")
    @Log(title = "代币表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Symbol symbol)
    {
        List<Symbol> list = symbolService.selectSymbolList(symbol);
        ExcelUtil<Symbol> util = new ExcelUtil<Symbol>(Symbol.class);
        util.exportExcel(response, list, "代币表数据");
    }

    /**
     * 获取代币表详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(symbolService.selectSymbolById(id));
    }

    /**
     * 新增代币表
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:add')")
    @Log(title = "代币表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Symbol symbol)
    {
        return toAjax(symbolService.insertSymbol(symbol));
    }

    /**
     * 修改代币表
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:edit')")
    @Log(title = "代币表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Symbol symbol)
    {
        return toAjax(symbolService.updateSymbol(symbol));
    }

    /**
     * 删除代币表
     */
    @PreAuthorize("@ss.hasPermi('business:symbol:remove')")
    @Log(title = "代币表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(symbolService.deleteSymbolByIds(ids));
    }
}
