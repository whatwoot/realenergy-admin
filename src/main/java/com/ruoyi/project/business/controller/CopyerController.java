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
import com.ruoyi.project.business.domain.Copyer;
import com.ruoyi.project.business.service.ICopyerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户跟单Controller
 *
 * @author gpthk
 * @date 2026-01-05
 */
@RestController
@RequestMapping("/business/copyer")
public class CopyerController extends BaseController
{
    @Autowired
    private ICopyerService copyerService;

    /**
     * 查询用户跟单列表
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Copyer copyer)
    {
        startPage();
        List<Copyer> list = copyerService.selectCopyerList(copyer);
        return getDataTable(list);
    }

    /**
     * 导出用户跟单列表
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:export')")
    @Log(title = "用户跟单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Copyer copyer)
    {
        List<Copyer> list = copyerService.selectCopyerList(copyer);
        ExcelUtil<Copyer> util = new ExcelUtil<Copyer>(Copyer.class);
        util.exportExcel(response, list, "用户跟单数据");
    }

    /**
     * 获取用户跟单详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(copyerService.selectCopyerById(id));
    }

    /**
     * 新增用户跟单
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:add')")
    @Log(title = "用户跟单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Copyer copyer)
    {
        return toAjax(copyerService.insertCopyer(copyer));
    }

    /**
     * 修改用户跟单
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:edit')")
    @Log(title = "用户跟单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Copyer copyer)
    {
        return toAjax(copyerService.updateCopyer(copyer));
    }

    /**
     * 删除用户跟单
     */
    @PreAuthorize("@ss.hasPermi('business:copyer:remove')")
    @Log(title = "用户跟单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(copyerService.deleteCopyerByIds(ids));
    }
}
