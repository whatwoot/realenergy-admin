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
import com.ruoyi.project.business.domain.ReleaseFlow;
import com.ruoyi.project.business.service.IReleaseFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 等待释放Controller
 *
 * @author gpthk
 * @date 2025-12-31
 */
@RestController
@RequestMapping("/business/release_flow")
public class ReleaseFlowController extends BaseController
{
    @Autowired
    private IReleaseFlowService releaseFlowService;

    /**
     * 查询等待释放列表
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReleaseFlow releaseFlow)
    {
        startPage();
        List<ReleaseFlow> list = releaseFlowService.selectReleaseFlowList(releaseFlow);
        return getDataTable(list);
    }

    /**
     * 导出等待释放列表
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:export')")
    @Log(title = "等待释放", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReleaseFlow releaseFlow)
    {
        List<ReleaseFlow> list = releaseFlowService.selectReleaseFlowList(releaseFlow);
        ExcelUtil<ReleaseFlow> util = new ExcelUtil<ReleaseFlow>(ReleaseFlow.class);
        util.exportExcel(response, list, "等待释放数据");
    }

    /**
     * 获取等待释放详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(releaseFlowService.selectReleaseFlowById(id));
    }

    /**
     * 新增等待释放
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:add')")
    @Log(title = "等待释放", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReleaseFlow releaseFlow)
    {
        return toAjax(releaseFlowService.insertReleaseFlow(releaseFlow));
    }

    /**
     * 修改等待释放
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:edit')")
    @Log(title = "等待释放", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReleaseFlow releaseFlow)
    {
        return toAjax(releaseFlowService.updateReleaseFlow(releaseFlow));
    }

    /**
     * 删除等待释放
     */
    @PreAuthorize("@ss.hasPermi('business:release_flow:remove')")
    @Log(title = "等待释放", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(releaseFlowService.deleteReleaseFlowByIds(ids));
    }
}
