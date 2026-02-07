package com.ruoyi.project.business.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.InviteLevel;
import com.ruoyi.project.business.service.IInviteLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 邀请级别Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/business/invite_level")
public class InviteLevelController extends BaseController {
    @Autowired
    private IInviteLevelService inviteLevelService;

    /**
     * 查询邀请级别列表
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:list')")
    @GetMapping("/list")
    public TableDataInfo list(InviteLevel inviteLevel) {
        startPage();
        List<InviteLevel> list = inviteLevelService.selectInviteLevelList(inviteLevel);
        return getDataTable(list);
    }

    /**
     * 导出邀请级别列表
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:export')")
    @Log(title = "邀请级别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InviteLevel inviteLevel) {
        List<InviteLevel> list = inviteLevelService.selectInviteLevelList(inviteLevel);
        ExcelUtil<InviteLevel> util = new ExcelUtil<InviteLevel>(InviteLevel.class);
        util.exportExcel(response, list, "邀请级别数据");
    }

    /**
     * 获取邀请级别详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(inviteLevelService.selectInviteLevelById(id));
    }

    /**
     * 新增邀请级别
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:add')")
    @Log(title = "邀请级别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InviteLevel inviteLevel) {
        return toAjax(inviteLevelService.insertInviteLevel(inviteLevel));
    }

    /**
     * 修改邀请级别
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:edit')")
    @Log(title = "邀请级别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InviteLevel inviteLevel) {
        return toAjax(inviteLevelService.updateInviteLevel(inviteLevel));
    }

    /**
     * 删除邀请级别
     */
    @PreAuthorize("@ss.hasPermi('business:invite_level:remove')")
    @Log(title = "邀请级别", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(inviteLevelService.deleteInviteLevelByIds(ids));
    }
}
