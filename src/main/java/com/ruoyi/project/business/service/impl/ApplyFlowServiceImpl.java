package com.ruoyi.project.business.service.impl;

import java.util.List;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.cs.sp.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.ApplyFlowMapper;
import com.ruoyi.project.business.domain.ApplyFlow;
import com.ruoyi.project.business.service.IApplyFlowService;

import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 申请审核Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-06
 */
@Service
public class ApplyFlowServiceImpl implements IApplyFlowService {
    @Autowired
    private ApplyFlowMapper applyFlowMapper;

    @Autowired
    private AppProperties appProperties;

    /**
     * 查询申请审核
     *
     * @param id 申请审核主键
     * @return 申请审核
     */
    @Override
    public ApplyFlow selectApplyFlowById(Long id)
    {
        return applyFlowMapper.selectApplyFlowById(id);
    }

    /**
     * 查询申请审核列表
     *
     * @param applyFlow 申请审核
     * @return 申请审核
     */
    @Override
    public List<ApplyFlow> selectApplyFlowList(ApplyFlow applyFlow)
    {
        return applyFlowMapper.selectApplyFlowList(applyFlow);
    }

    /**
     * 新增申请审核
     *
     * @param applyFlow 申请审核
     * @return 结果
     */
    @Override
    public int insertApplyFlow(ApplyFlow applyFlow) {
        applyFlow.setCreateTime(null);
        return applyFlowMapper.insertApplyFlow(applyFlow);
    }

    /**
     * 修改申请审核
     *
     * @param applyFlow 申请审核
     * @return 结果
     */
    @Override
    public int updateApplyFlow(ApplyFlow applyFlow)
    {
        applyFlow.setUpdateTime(null);
        return applyFlowMapper.updateApplyFlow(applyFlow);
    }

    /**
     * 批量删除申请审核
     *
     * @param ids 需要删除的申请审核主键
     * @return 结果
     */
    @Override
    public int deleteApplyFlowByIds(Long[] ids)
    {
        return applyFlowMapper.deleteApplyFlowByIds(ids);
    }

    /**
     * 删除申请审核信息
     *
     * @param id 申请审核主键
     * @return 结果
     */
    @Override
    public int deleteApplyFlowById(Long id)
    {
        return applyFlowMapper.deleteApplyFlowById(id);
    }

    @Override
    public List<ApplyFlow> listWithChildren(ApplyFlow entity) {
        return applyFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<ApplyFlow> listWithParents(ApplyFlow  entity) {
        return applyFlowMapper.listWithParents(entity);
    }

    @Override
    public int updateAudit(ApplyFlow applyFlow) {
        String url = String.format("%s%s?id=%s&status=%s&msg=%s", appProperties.getPrefix(), AppApi.APPLY_AUDIT,
                    applyFlow.getId(),
                    applyFlow.getStatus(),
                    applyFlow.getAuditMsg() == null ? "" : applyFlow.getAuditMsg()
                );
        String body = HttpRequest.get(url)
                .header("Accept-Language", "zh-CN")
                .execute().body();
        JSONObject json = JSONObject.parseObject(body);
        if (!Constant.ZERO_STR.equals(json.getString("code"))) {
            throwBizException(json.getString("msg"));
        }
        return 1;
    }
}
