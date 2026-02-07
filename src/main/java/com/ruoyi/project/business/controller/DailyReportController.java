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
import com.ruoyi.project.business.domain.DailyReport;
import com.ruoyi.project.business.service.IDailyReportService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 每日报表Controller
 *
 * @author gpthk
 * @date 2025-11-16
 */
@RestController
@RequestMapping("/business/daily_report")
public class DailyReportController extends BaseController
{
    @Autowired
    private IDailyReportService dailyReportService;

    /**
     * 查询每日报表列表
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:list')")
    @GetMapping("/list")
    public TableDataInfo list(DailyReport dailyReport)
    {
        startPage();
        List<DailyReport> list = dailyReportService.selectDailyReportList(dailyReport);
        return getDataTable(list);
    }

    /**
     * 导出每日报表列表
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:export')")
    @Log(title = "每日报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DailyReport dailyReport)
    {
        List<DailyReport> list = dailyReportService.selectDailyReportList(dailyReport);
        ExcelUtil<DailyReport> util = new ExcelUtil<DailyReport>(DailyReport.class);
        util.exportExcel(response, list, "每日报表数据");
    }

    /**
     * 获取每日报表详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(dailyReportService.selectDailyReportById(id));
    }

    /**
     * 新增每日报表
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:add')")
    @Log(title = "每日报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DailyReport dailyReport)
    {
        return toAjax(dailyReportService.insertDailyReport(dailyReport));
    }

    /**
     * 修改每日报表
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:edit')")
    @Log(title = "每日报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DailyReport dailyReport)
    {
        return toAjax(dailyReportService.updateDailyReport(dailyReport));
    }

    /**
     * 删除每日报表
     */
    @PreAuthorize("@ss.hasPermi('business:daily_report:remove')")
    @Log(title = "每日报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dailyReportService.deleteDailyReportByIds(ids));
    }
}
