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
import com.ruoyi.project.business.domain.DecPriceHis;
import com.ruoyi.project.business.service.IDecPriceHisService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 价格历史DController
 *
 * @author gpthk
 * @date 2026-01-05
 */
@RestController
@RequestMapping("/business/dec_price_his")
public class DecPriceHisController extends BaseController
{
    @Autowired
    private IDecPriceHisService decPriceHisService;

    /**
     * 查询价格历史D列表
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:list')")
    @GetMapping("/list")
    public TableDataInfo list(DecPriceHis decPriceHis)
    {
        startPage();
        List<DecPriceHis> list = decPriceHisService.selectDecPriceHisList(decPriceHis);
        return getDataTable(list);
    }

    /**
     * 导出价格历史D列表
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:export')")
    @Log(title = "价格历史D", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DecPriceHis decPriceHis)
    {
        List<DecPriceHis> list = decPriceHisService.selectDecPriceHisList(decPriceHis);
        ExcelUtil<DecPriceHis> util = new ExcelUtil<DecPriceHis>(DecPriceHis.class);
        util.exportExcel(response, list, "价格历史D数据");
    }

    /**
     * 获取价格历史D详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(decPriceHisService.selectDecPriceHisById(id));
    }

    /**
     * 新增价格历史D
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:add')")
    @Log(title = "价格历史D", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DecPriceHis decPriceHis)
    {
        return toAjax(decPriceHisService.insertDecPriceHis(decPriceHis));
    }

    /**
     * 修改价格历史D
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:edit')")
    @Log(title = "价格历史D", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DecPriceHis decPriceHis)
    {
        return toAjax(decPriceHisService.updateDecPriceHis(decPriceHis));
    }

    /**
     * 删除价格历史D
     */
    @PreAuthorize("@ss.hasPermi('business:dec_price_his:remove')")
    @Log(title = "价格历史D", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(decPriceHisService.deleteDecPriceHisByIds(ids));
    }
}
