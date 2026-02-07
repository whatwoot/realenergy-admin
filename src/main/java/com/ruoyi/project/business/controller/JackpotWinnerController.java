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
import com.ruoyi.project.business.domain.JackpotWinner;
import com.ruoyi.project.business.service.IJackpotWinnerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * JackPot抽奖Controller
 *
 * @author gpthk
 * @date 2025-12-31
 */
@RestController
@RequestMapping("/business/jackpot_winner")
public class JackpotWinnerController extends BaseController
{
    @Autowired
    private IJackpotWinnerService jackpotWinnerService;

    /**
     * 查询JackPot抽奖列表
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:list')")
    @GetMapping("/list")
    public TableDataInfo list(JackpotWinner jackpotWinner)
    {
        startPage();
        List<JackpotWinner> list = jackpotWinnerService.selectJackpotWinnerList(jackpotWinner);
        return getDataTable(list);
    }

    /**
     * 导出JackPot抽奖列表
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:export')")
    @Log(title = "JackPot抽奖", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JackpotWinner jackpotWinner)
    {
        List<JackpotWinner> list = jackpotWinnerService.selectJackpotWinnerList(jackpotWinner);
        ExcelUtil<JackpotWinner> util = new ExcelUtil<JackpotWinner>(JackpotWinner.class);
        util.exportExcel(response, list, "JackPot抽奖数据");
    }

    /**
     * 获取JackPot抽奖详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(jackpotWinnerService.selectJackpotWinnerById(id));
    }

    /**
     * 新增JackPot抽奖
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:add')")
    @Log(title = "JackPot抽奖", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JackpotWinner jackpotWinner)
    {
        return toAjax(jackpotWinnerService.insertJackpotWinner(jackpotWinner));
    }

    /**
     * 修改JackPot抽奖
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:edit')")
    @Log(title = "JackPot抽奖", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JackpotWinner jackpotWinner)
    {
        return toAjax(jackpotWinnerService.updateJackpotWinner(jackpotWinner));
    }

    /**
     * 删除JackPot抽奖
     */
    @PreAuthorize("@ss.hasPermi('business:jackpot_winner:remove')")
    @Log(title = "JackPot抽奖", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jackpotWinnerService.deleteJackpotWinnerByIds(ids));
    }
}
