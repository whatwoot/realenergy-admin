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
import com.ruoyi.project.business.domain.QueueFlow;
import com.ruoyi.project.business.service.IQueueFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 排位出局明细Controller
 *
 * @author gpthk
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/business/queue_flow")
public class QueueFlowController extends BaseController
{
    @Autowired
    private IQueueFlowService queueFlowService;

    /**
     * 查询排位出局明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(QueueFlow queueFlow){
        startPage();
        List<QueueFlow> list = null;
        if (queueFlow.getUid() != null || StringUtils.hasText(queueFlow.getAccount())) {
            if (Constants.ONE_INT.equals(queueFlow.getRelate())) {
                list = queueFlowService.listWithChildren(queueFlow);
            } else if (Constants.ZERO_INT.equals(queueFlow.getRelate())) {
                list = queueFlowService.listWithParents(queueFlow);
            }
        }
        if (list == null) {
            list = queueFlowService.selectQueueFlowList(queueFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出排位出局明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:export')")
    @Log(title = "排位出局明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QueueFlow queueFlow){
        List<QueueFlow> list = null;
        if (queueFlow.getUid() != null || StringUtils.hasText(queueFlow.getAccount())) {
            if (Constants.ONE_INT.equals(queueFlow.getRelate())) {
                list = queueFlowService.listWithChildren(queueFlow);
            } else if (Constants.ZERO_INT.equals(queueFlow.getRelate())) {
                list = queueFlowService.listWithParents(queueFlow);
            }
        }
        if (list == null) {
            list = queueFlowService.selectQueueFlowList(queueFlow);
        }
        ExcelUtil<QueueFlow> util = new ExcelUtil<QueueFlow>(QueueFlow.class);
        util.exportExcel(response, list, "排位出局明细数据");
    }

    /**
     * 获取排位出局明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(queueFlowService.selectQueueFlowById(id));
    }

    /**
     * 新增排位出局明细
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:add')")
    @Log(title = "排位出局明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QueueFlow queueFlow)
    {
        return toAjax(queueFlowService.insertQueueFlow(queueFlow));
    }

    /**
     * 修改排位出局明细
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:edit')")
    @Log(title = "排位出局明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QueueFlow queueFlow)
    {
        return toAjax(queueFlowService.updateQueueFlow(queueFlow));
    }

    /**
     * 删除排位出局明细
     */
    @PreAuthorize("@ss.hasPermi('business:queue_flow:remove')")
    @Log(title = "排位出局明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(queueFlowService.deleteQueueFlowByIds(ids));
    }
}
