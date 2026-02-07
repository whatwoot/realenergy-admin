package com.ruoyi.project.business.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.Config;
import com.ruoyi.project.business.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统配置Controller
 *
 * @author gpthk
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/business/config")
public class ConfigController extends BaseController {
    @Autowired
    private IConfigService configService;

    /**
     * 查询系统配置列表
     */
    @PreAuthorize("@ss.hasPermi('business:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(Config config) {
        startPage();
        List<Config> list = configService.selectConfigList(config);
        return getDataTable(list);
    }

    /**
     * 导出系统配置列表
     */
    @PreAuthorize("@ss.hasPermi('business:config:export')")
    @Log(title = "系统配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Config config) {
        List<Config> list = configService.selectConfigList(config);
        ExcelUtil<Config> util = new ExcelUtil<Config>(Config.class);
        util.exportExcel(response, list, "系统配置数据");
    }

    /**
     * 获取系统配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(configService.selectConfigById(id));
    }

    /**
     * 新增系统配置
     */
    @PreAuthorize("@ss.hasPermi('business:config:add')")
    @Log(title = "系统配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Config config) {
        return toAjax(configService.insertConfig(config));
    }

    /**
     * 修改系统配置
     */
    @PreAuthorize("@ss.hasPermi('business:config:edit')")
    @Log(title = "系统配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Config config) {
        return toAjax(configService.updateConfig(config));
    }

    /**
     * 删除系统配置
     */
    @PreAuthorize("@ss.hasPermi('business:config:remove')")
    @Log(title = "系统配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(configService.deleteConfigByIds(ids));
    }
}
