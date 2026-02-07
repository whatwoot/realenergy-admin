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
import com.ruoyi.project.business.domain.InviteRank;
import com.ruoyi.project.business.service.IInviteRankService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 销售排行榜Controller
 *
 * @author gpthk
 * @date 2025-11-06
 */
@RestController
@RequestMapping("/business/invite_rank")
public class InviteRankController extends BaseController
{
    @Autowired
    private IInviteRankService inviteRankService;

    /**
     * 查询销售排行榜列表
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:list')")
    @GetMapping("/list")
    public TableDataInfo list(InviteRank inviteRank)
    {
        startPage();
        List<InviteRank> list = inviteRankService.selectInviteRankList(inviteRank);
        return getDataTable(list);
    }

    /**
     * 导出销售排行榜列表
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:export')")
    @Log(title = "销售排行榜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InviteRank inviteRank)
    {
        List<InviteRank> list = inviteRankService.selectInviteRankList(inviteRank);
        ExcelUtil<InviteRank> util = new ExcelUtil<InviteRank>(InviteRank.class);
        util.exportExcel(response, list, "销售排行榜数据");
    }

    /**
     * 获取销售排行榜详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(inviteRankService.selectInviteRankById(id));
    }

    /**
     * 新增销售排行榜
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:add')")
    @Log(title = "销售排行榜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InviteRank inviteRank)
    {
        return toAjax(inviteRankService.insertInviteRank(inviteRank));
    }

    /**
     * 修改销售排行榜
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:edit')")
    @Log(title = "销售排行榜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InviteRank inviteRank)
    {
        return toAjax(inviteRankService.updateInviteRank(inviteRank));
    }

    /**
     * 删除销售排行榜
     */
    @PreAuthorize("@ss.hasPermi('business:invite_rank:remove')")
    @Log(title = "销售排行榜", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inviteRankService.deleteInviteRankByIds(ids));
    }
}
