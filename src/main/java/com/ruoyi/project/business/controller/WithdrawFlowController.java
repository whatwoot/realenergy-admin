package com.ruoyi.project.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.dto.WithdrawAuditRequest;
import com.cs.sp.constant.Constant;
import lombok.extern.slf4j.Slf4j;
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
import com.ruoyi.project.business.domain.WithdrawFlow;
import com.ruoyi.project.business.service.IWithdrawFlowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 提现流水Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Slf4j
@RestController
@RequestMapping("/business/withdraw_flow")
public class WithdrawFlowController extends BaseController
{
    @Autowired
    private IWithdrawFlowService withdrawFlowService;

    /**
     * 查询提现流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(WithdrawFlow withdrawFlow){
        startPage();
        List<WithdrawFlow> list = null;
        if (withdrawFlow.getUid() != null || StringUtils.hasText(withdrawFlow.getAccount())) {
            if (Constants.ONE_INT.equals(withdrawFlow.getRelate())) {
                list = withdrawFlowService.listWithChildren(withdrawFlow);
            } else if (Constants.ZERO_INT.equals(withdrawFlow.getRelate())) {
                list = withdrawFlowService.listWithParents(withdrawFlow);
            }
        }
        if (list == null) {
            list = withdrawFlowService.selectWithdrawFlowList(withdrawFlow);
        }
        return getDataTable(list);
    }


    /**
     * 导出提现流水列表
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:export')")
    @Log(title = "提现流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WithdrawFlow withdrawFlow){
        List<WithdrawFlow> list = null;
        if (withdrawFlow.getUid() != null || StringUtils.hasText(withdrawFlow.getAccount())) {
            if (Constants.ONE_INT.equals(withdrawFlow.getRelate())) {
                list = withdrawFlowService.listWithChildren(withdrawFlow);
            } else if (Constants.ZERO_INT.equals(withdrawFlow.getRelate())) {
                list = withdrawFlowService.listWithParents(withdrawFlow);
            }
        }
        if (list == null) {
            list = withdrawFlowService.selectWithdrawFlowList(withdrawFlow);
        }
        ExcelUtil<WithdrawFlow> util = new ExcelUtil<WithdrawFlow>(WithdrawFlow.class);
        util.exportExcel(response, list, "提现流水数据");
    }

    /**
     * 获取提现流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(withdrawFlowService.selectWithdrawFlowById(id));
    }

    /**
     * 新增提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:add')")
    @Log(title = "提现流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WithdrawFlow withdrawFlow)
    {
        return toAjax(withdrawFlowService.insertWithdrawFlow(withdrawFlow));
    }

    /**
     * 修改提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:edit')")
    @Log(title = "提现流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WithdrawFlow withdrawFlow)
    {
        return toAjax(withdrawFlowService.updateWithdrawFlow(withdrawFlow));
    }

    /**
     * 删除提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:withdraw_flow:remove')")
    @Log(title = "提现流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(withdrawFlowService.deleteWithdrawFlowByIds(ids));
    }


    @Autowired
    private AppProperties appProperties;
    /**
     * 修改商家提现流水
     */
    @PreAuthorize("@ss.hasPermi('business:merchant_withdraw_flow:edit')")
    @Log(title = "商家提现流水审核", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult audit(@RequestBody WithdrawAuditRequest req){

        Boolean localAudit = true;
        if(localAudit){
            WithdrawFlow update=  new WithdrawFlow();
            update.setId(req.getId());
            update.setStatus(req.getStatus());
            return toAjax(withdrawFlowService.updateAudit(update));
        }else{
            String url = String.format("%s%s?id=%s&status=%s&message=%s", appProperties.getPrefix(), AppApi.WITHDRAW_AUDIT,
                    req.getId(), req.getStatus(), req.getMessage());
            log.info("Withdraw-audit url {}", url);
            String body = HttpRequest.get(url).execute().body();
            JSONObject json = JSONObject.parseObject(body);
            if (!Constant.ZERO_STR.equals(json.getString("code"))) {
                throwBizException(json.getString("msg"));
            }
        }
        return toAjax(1);
    }
}
