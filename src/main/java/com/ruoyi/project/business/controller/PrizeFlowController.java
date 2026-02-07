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
import com.ruoyi.project.business.domain.PrizeFlow;
import com.ruoyi.project.business.service.IPrizeFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户贡献明细Controller
 *
 * @author gpthk
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/business/prize_flow")
public class PrizeFlowController extends BaseController
{
    @Autowired
    private IPrizeFlowService prizeFlowService;

    /**
     * 查询用户贡献明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(PrizeFlow prizeFlow){
        startPage();
        List<PrizeFlow> list = null;
        if (prizeFlow.getUid() != null || StringUtils.hasText(prizeFlow.getAccount())) {
            if (Constants.ONE_INT.equals(prizeFlow.getRelate())) {
                list = prizeFlowService.listWithChildren(prizeFlow);
            } else if (Constants.ZERO_INT.equals(prizeFlow.getRelate())) {
                list = prizeFlowService.listWithParents(prizeFlow);
            }
        }
        if (list == null) {
            list = prizeFlowService.selectPrizeFlowList(prizeFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出用户贡献明细列表
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:export')")
    @Log(title = "用户贡献明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PrizeFlow prizeFlow){
        List<PrizeFlow> list = null;
        if (prizeFlow.getUid() != null || StringUtils.hasText(prizeFlow.getAccount())) {
            if (Constants.ONE_INT.equals(prizeFlow.getRelate())) {
                list = prizeFlowService.listWithChildren(prizeFlow);
            } else if (Constants.ZERO_INT.equals(prizeFlow.getRelate())) {
                list = prizeFlowService.listWithParents(prizeFlow);
            }
        }
        if (list == null) {
            list = prizeFlowService.selectPrizeFlowList(prizeFlow);
        }
        ExcelUtil<PrizeFlow> util = new ExcelUtil<PrizeFlow>(PrizeFlow.class);
        util.exportExcel(response, list, "用户贡献明细数据");
    }

    /**
     * 获取用户贡献明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(prizeFlowService.selectPrizeFlowById(id));
    }

    /**
     * 新增用户贡献明细
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:add')")
    @Log(title = "用户贡献明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PrizeFlow prizeFlow)
    {
        return toAjax(prizeFlowService.insertPrizeFlow(prizeFlow));
    }

    /**
     * 修改用户贡献明细
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:edit')")
    @Log(title = "用户贡献明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PrizeFlow prizeFlow)
    {
        return toAjax(prizeFlowService.updatePrizeFlow(prizeFlow));
    }

    /**
     * 删除用户贡献明细
     */
    @PreAuthorize("@ss.hasPermi('business:prize_flow:remove')")
    @Log(title = "用户贡献明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(prizeFlowService.deletePrizeFlowByIds(ids));
    }
}
