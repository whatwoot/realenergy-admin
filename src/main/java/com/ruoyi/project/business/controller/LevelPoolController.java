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
import com.ruoyi.project.business.domain.LevelPool;
import com.ruoyi.project.business.service.ILevelPoolService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 爆破池Controller
 *
 * @author gpthk
 * @date 2025-11-07
 */
@RestController
@RequestMapping("/business/level_pool")
public class LevelPoolController extends BaseController
{
    @Autowired
    private ILevelPoolService levelPoolService;

    /**
     * 查询爆破池列表
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:list')")
    @GetMapping("/list")
    public TableDataInfo list(LevelPool levelPool)
    {
        startPage();
        List<LevelPool> list = levelPoolService.selectLevelPoolList(levelPool);
        return getDataTable(list);
    }

    /**
     * 导出爆破池列表
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:export')")
    @Log(title = "爆破池", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LevelPool levelPool)
    {
        List<LevelPool> list = levelPoolService.selectLevelPoolList(levelPool);
        ExcelUtil<LevelPool> util = new ExcelUtil<LevelPool>(LevelPool.class);
        util.exportExcel(response, list, "爆破池数据");
    }

    /**
     * 获取爆破池详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(levelPoolService.selectLevelPoolById(id));
    }

    /**
     * 新增爆破池
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:add')")
    @Log(title = "爆破池", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LevelPool levelPool)
    {
        return toAjax(levelPoolService.insertLevelPool(levelPool));
    }

    /**
     * 修改爆破池
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:edit')")
    @Log(title = "爆破池", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LevelPool levelPool)
    {
        return toAjax(levelPoolService.updateLevelPool(levelPool));
    }

    /**
     * 删除爆破池
     */
    @PreAuthorize("@ss.hasPermi('business:level_pool:remove')")
    @Log(title = "爆破池", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(levelPoolService.deleteLevelPoolByIds(ids));
    }
}
