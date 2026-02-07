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
import com.ruoyi.project.business.domain.ReleaseVer;
import com.ruoyi.project.business.service.IReleaseVerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * APP发版Controller
 *
 * @author gpthk
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/business/release_ver")
public class ReleaseVerController extends BaseController
{
    @Autowired
    private IReleaseVerService releaseVerService;

    /**
     * 查询APP发版列表
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReleaseVer releaseVer)
    {
        startPage();
        List<ReleaseVer> list = releaseVerService.selectReleaseVerList(releaseVer);
        return getDataTable(list);
    }

    /**
     * 导出APP发版列表
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:export')")
    @Log(title = "APP发版", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReleaseVer releaseVer)
    {
        List<ReleaseVer> list = releaseVerService.selectReleaseVerList(releaseVer);
        ExcelUtil<ReleaseVer> util = new ExcelUtil<ReleaseVer>(ReleaseVer.class);
        util.exportExcel(response, list, "APP发版数据");
    }

    /**
     * 获取APP发版详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(releaseVerService.selectReleaseVerById(id));
    }

    /**
     * 新增APP发版
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:add')")
    @Log(title = "APP发版", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReleaseVer releaseVer)
    {
        return toAjax(releaseVerService.insertReleaseVer(releaseVer));
    }

    /**
     * 修改APP发版
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:edit')")
    @Log(title = "APP发版", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReleaseVer releaseVer)
    {
        return toAjax(releaseVerService.updateReleaseVer(releaseVer));
    }

    /**
     * 删除APP发版
     */
    @PreAuthorize("@ss.hasPermi('business:release_ver:remove')")
    @Log(title = "APP发版", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(releaseVerService.deleteReleaseVerByIds(ids));
    }
}
