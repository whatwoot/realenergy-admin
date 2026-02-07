package com.ruoyi.project.business.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.TeamLevel;
import com.ruoyi.project.business.service.ITeamLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 社区级别Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/business/team_level")
public class TeamLevelController extends BaseController {
    @Autowired
    private ITeamLevelService teamLevelService;

    /**
     * 查询社区级别列表
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamLevel teamLevel) {
        startPage();
        List<TeamLevel> list = teamLevelService.selectTeamLevelList(teamLevel);
        return getDataTable(list);
    }

    /**
     * 导出社区级别列表
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:export')")
    @Log(title = "社区级别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeamLevel teamLevel) {
        List<TeamLevel> list = teamLevelService.selectTeamLevelList(teamLevel);
        ExcelUtil<TeamLevel> util = new ExcelUtil<TeamLevel>(TeamLevel.class);
        util.exportExcel(response, list, "社区级别数据");
    }

    /**
     * 获取社区级别详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(teamLevelService.selectTeamLevelById(id));
    }

    /**
     * 新增社区级别
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:add')")
    @Log(title = "社区级别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamLevel teamLevel) {
        return toAjax(teamLevelService.insertTeamLevel(teamLevel));
    }

    /**
     * 修改社区级别
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:edit')")
    @Log(title = "社区级别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamLevel teamLevel) {
        return toAjax(teamLevelService.updateTeamLevel(teamLevel));
    }

    /**
     * 删除社区级别
     */
    @PreAuthorize("@ss.hasPermi('business:team_level:remove')")
    @Log(title = "社区级别", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(teamLevelService.deleteTeamLevelByIds(ids));
    }
}
