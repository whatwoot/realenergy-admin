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
import com.ruoyi.project.business.domain.MessageFlow;
import com.ruoyi.project.business.service.IMessageFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 消息流水Controller
 *
 * @author gpthk
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/business/message_flow")
public class MessageFlowController extends BaseController
{
    @Autowired
    private IMessageFlowService messageFlowService;

    /**
     * 查询消息流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(MessageFlow messageFlow)
    {
        startPage();
        List<MessageFlow> list = messageFlowService.selectMessageFlowList(messageFlow);
        return getDataTable(list);
    }

    /**
     * 导出消息流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:export')")
    @Log(title = "消息流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MessageFlow messageFlow)
    {
        List<MessageFlow> list = messageFlowService.selectMessageFlowList(messageFlow);
        ExcelUtil<MessageFlow> util = new ExcelUtil<MessageFlow>(MessageFlow.class);
        util.exportExcel(response, list, "消息流水数据");
    }

    /**
     * 获取消息流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(messageFlowService.selectMessageFlowById(id));
    }

    /**
     * 新增消息流水
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:add')")
    @Log(title = "消息流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MessageFlow messageFlow)
    {
        return toAjax(messageFlowService.insertMessageFlow(messageFlow));
    }

    /**
     * 修改消息流水
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:edit')")
    @Log(title = "消息流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MessageFlow messageFlow)
    {
        return toAjax(messageFlowService.updateMessageFlow(messageFlow));
    }

    /**
     * 删除消息流水
     */
    @PreAuthorize("@ss.hasPermi('business:message_flow:remove')")
    @Log(title = "消息流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(messageFlowService.deleteMessageFlowByIds(ids));
    }
}
