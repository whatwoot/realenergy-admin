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
import com.ruoyi.project.business.domain.UserReportDaily;
import com.ruoyi.project.business.service.IUserReportDailyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 业绩报表Controller
 *
 * @author gpthk
 * @date 2025-05-04
 */
@RestController
@RequestMapping("/business/user_report_daily")
public class UserReportDailyController extends BaseController
{
    @Autowired
    private IUserReportDailyService userReportDailyService;

    /**
     * 查询业绩报表列表
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserReportDaily userReportDaily){
        startPage();
        List<UserReportDaily> list = null;
        if (userReportDaily.getUid() != null || StringUtils.hasText(userReportDaily.getAccount())) {
            if (Constants.ONE_INT.equals(userReportDaily.getRelate())) {
                list = userReportDailyService.listWithChildren(userReportDaily);
            } else if (Constants.ZERO_INT.equals(userReportDaily.getRelate())) {
                list = userReportDailyService.listWithParents(userReportDaily);
            }
        }
        if (list == null) {
            list = userReportDailyService.selectUserReportDailyList(userReportDaily);
        }
        return getDataTable(list);
    }


    /**
     * 导出业绩报表列表
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:export')")
    @Log(title = "业绩报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserReportDaily userReportDaily){
        List<UserReportDaily> list = null;
        if (userReportDaily.getUid() != null || StringUtils.hasText(userReportDaily.getAccount())) {
            if (Constants.ONE_INT.equals(userReportDaily.getRelate())) {
                list = userReportDailyService.listWithChildren(userReportDaily);
            } else if (Constants.ZERO_INT.equals(userReportDaily.getRelate())) {
                list = userReportDailyService.listWithParents(userReportDaily);
            }
        }
        if (list == null) {
            list = userReportDailyService.selectUserReportDailyList(userReportDaily);
        }
        ExcelUtil<UserReportDaily> util = new ExcelUtil<UserReportDaily>(UserReportDaily.class);
        util.exportExcel(response, list, "业绩报表数据");
    }

    /**
     * 获取业绩报表详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userReportDailyService.selectUserReportDailyById(id));
    }

    /**
     * 新增业绩报表
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:add')")
    @Log(title = "业绩报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserReportDaily userReportDaily)
    {
        return toAjax(userReportDailyService.insertUserReportDaily(userReportDaily));
    }

    /**
     * 修改业绩报表
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:edit')")
    @Log(title = "业绩报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserReportDaily userReportDaily)
    {
        return toAjax(userReportDailyService.updateUserReportDaily(userReportDaily));
    }

    /**
     * 删除业绩报表
     */
    @PreAuthorize("@ss.hasPermi('business:user_report_daily:remove')")
    @Log(title = "业绩报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userReportDailyService.deleteUserReportDailyByIds(ids));
    }
}
