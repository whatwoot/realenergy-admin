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
import com.ruoyi.project.business.domain.Queue;
import com.ruoyi.project.business.service.IQueueService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 当前排位Controller
 *
 * @author gpthk
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/business/queue")
public class QueueController extends BaseController
{
    @Autowired
    private IQueueService queueService;

    /**
     * 查询当前排位列表
     */
    @PreAuthorize("@ss.hasPermi('business:queue:list')")
    @GetMapping("/list")
    public TableDataInfo list(Queue queue){
        startPage();
        List<Queue> list = null;
        if (queue.getUid() != null || StringUtils.hasText(queue.getAccount())) {
            if (Constants.ONE_INT.equals(queue.getRelate())) {
                list = queueService.listWithChildren(queue);
            } else if (Constants.ZERO_INT.equals(queue.getRelate())) {
                list = queueService.listWithParents(queue);
            }
        }
        if (list == null) {
            list = queueService.selectQueueList(queue);
        }
        return getDataTable(list);
    }


    /**
     * 导出当前排位列表
     */
    @PreAuthorize("@ss.hasPermi('business:queue:export')")
    @Log(title = "当前排位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Queue queue){
        List<Queue> list = null;
        if (queue.getUid() != null || StringUtils.hasText(queue.getAccount())) {
            if (Constants.ONE_INT.equals(queue.getRelate())) {
                list = queueService.listWithChildren(queue);
            } else if (Constants.ZERO_INT.equals(queue.getRelate())) {
                list = queueService.listWithParents(queue);
            }
        }
        if (list == null) {
            list = queueService.selectQueueList(queue);
        }
        ExcelUtil<Queue> util = new ExcelUtil<Queue>(Queue.class);
        util.exportExcel(response, list, "当前排位数据");
    }

    /**
     * 获取当前排位详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:queue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(queueService.selectQueueById(id));
    }

    /**
     * 新增当前排位
     */
    @PreAuthorize("@ss.hasPermi('business:queue:add')")
    @Log(title = "当前排位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Queue queue)
    {
        return toAjax(queueService.insertQueue(queue));
    }

    /**
     * 修改当前排位
     */
    @PreAuthorize("@ss.hasPermi('business:queue:edit')")
    @Log(title = "当前排位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Queue queue)
    {
        return toAjax(queueService.updateQueue(queue));
    }

    /**
     * 删除当前排位
     */
    @PreAuthorize("@ss.hasPermi('business:queue:remove')")
    @Log(title = "当前排位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(queueService.deleteQueueByIds(ids));
    }
}
