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
import com.ruoyi.project.business.domain.ChainWork;
import com.ruoyi.project.business.service.IChainWorkService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 转账任务Controller
 *
 * @author gpthk
 * @date 2025-03-22
 */
@RestController
@RequestMapping("/business/chain_work")
public class ChainWorkController extends BaseController
{
    @Autowired
    private IChainWorkService chainWorkService;

    /**
     * 查询转账任务列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChainWork chainWork)
    {
        startPage();
        List<ChainWork> list = chainWorkService.selectChainWorkList(chainWork);
        return getDataTable(list);
    }

    /**
     * 导出转账任务列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:export')")
    @Log(title = "转账任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChainWork chainWork)
    {
        List<ChainWork> list = chainWorkService.selectChainWorkList(chainWork);
        ExcelUtil<ChainWork> util = new ExcelUtil<ChainWork>(ChainWork.class);
        util.exportExcel(response, list, "转账任务数据");
    }

    /**
     * 获取转账任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chainWorkService.selectChainWorkById(id));
    }

    /**
     * 新增转账任务
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:add')")
    @Log(title = "转账任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChainWork chainWork)
    {
        return toAjax(chainWorkService.insertChainWork(chainWork));
    }

    /**
     * 修改转账任务
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:edit')")
    @Log(title = "转账任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChainWork chainWork)
    {
        return toAjax(chainWorkService.updateChainWork(chainWork));
    }

    /**
     * 删除转账任务
     */
    @PreAuthorize("@ss.hasPermi('business:chain_work:remove')")
    @Log(title = "转账任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chainWorkService.deleteChainWorkByIds(ids));
    }
}
