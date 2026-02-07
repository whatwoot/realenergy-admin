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
import com.ruoyi.project.business.domain.PriceHis;
import com.ruoyi.project.business.service.IPriceHisService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 价格历史Controller
 *
 * @author gpthk
 * @date 2025-12-31
 */
@RestController
@RequestMapping("/business/price_his")
public class PriceHisController extends BaseController
{
    @Autowired
    private IPriceHisService priceHisService;

    /**
     * 查询价格历史列表
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:list')")
    @GetMapping("/list")
    public TableDataInfo list(PriceHis priceHis)
    {
        startPage();
        List<PriceHis> list = priceHisService.selectPriceHisList(priceHis);
        return getDataTable(list);
    }

    /**
     * 导出价格历史列表
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:export')")
    @Log(title = "价格历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PriceHis priceHis)
    {
        List<PriceHis> list = priceHisService.selectPriceHisList(priceHis);
        ExcelUtil<PriceHis> util = new ExcelUtil<PriceHis>(PriceHis.class);
        util.exportExcel(response, list, "价格历史数据");
    }

    /**
     * 获取价格历史详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(priceHisService.selectPriceHisById(id));
    }

    /**
     * 新增价格历史
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:add')")
    @Log(title = "价格历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PriceHis priceHis)
    {
        return toAjax(priceHisService.insertPriceHis(priceHis));
    }

    /**
     * 修改价格历史
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:edit')")
    @Log(title = "价格历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PriceHis priceHis)
    {
        return toAjax(priceHisService.updatePriceHis(priceHis));
    }

    /**
     * 删除价格历史
     */
    @PreAuthorize("@ss.hasPermi('business:price_his:remove')")
    @Log(title = "价格历史", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(priceHisService.deletePriceHisByIds(ids));
    }
}
