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
import com.ruoyi.project.business.domain.Apikey;
import com.ruoyi.project.business.service.IApikeyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 平台APIController
 *
 * @author gpthk
 * @date 2026-01-05
 */
@RestController
@RequestMapping("/business/apikey")
public class ApikeyController extends BaseController
{
    @Autowired
    private IApikeyService apikeyService;

    /**
     * 查询平台API列表
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:list')")
    @GetMapping("/list")
    public TableDataInfo list(Apikey apikey)
    {
        startPage();
        List<Apikey> list = apikeyService.selectApikeyList(apikey);
        return getDataTable(list);
    }

    /**
     * 导出平台API列表
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:export')")
    @Log(title = "平台API", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Apikey apikey)
    {
        List<Apikey> list = apikeyService.selectApikeyList(apikey);
        ExcelUtil<Apikey> util = new ExcelUtil<Apikey>(Apikey.class);
        util.exportExcel(response, list, "平台API数据");
    }

    /**
     * 获取平台API详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apikeyService.selectApikeyById(id));
    }

    /**
     * 新增平台API
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:add')")
    @Log(title = "平台API", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Apikey apikey)
    {
        return toAjax(apikeyService.insertApikey(apikey));
    }

    /**
     * 修改平台API
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:edit')")
    @Log(title = "平台API", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Apikey apikey)
    {
        return toAjax(apikeyService.updateApikey(apikey));
    }

    /**
     * 删除平台API
     */
    @PreAuthorize("@ss.hasPermi('business:apikey:remove')")
    @Log(title = "平台API", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(apikeyService.deleteApikeyByIds(ids));
    }
}
