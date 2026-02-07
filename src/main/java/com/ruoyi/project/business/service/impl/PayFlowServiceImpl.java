package com.ruoyi.project.business.service.impl;

import java.sql.Struct;
import java.util.List;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.cs.sp.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.PayFlowMapper;
import com.ruoyi.project.business.domain.PayFlow;
import com.ruoyi.project.business.service.IPayFlowService;

import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * CNY支付流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-12
 */
@Slf4j
@Service
public class PayFlowServiceImpl implements IPayFlowService {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private PayFlowMapper payFlowMapper;

    /**
     * 查询CNY支付流水
     *
     * @param id CNY支付流水主键
     * @return CNY支付流水
     */
    @Override
    public PayFlow selectPayFlowById(Long id)
    {
        return payFlowMapper.selectPayFlowById(id);
    }

    /**
     * 查询CNY支付流水列表
     *
     * @param payFlow CNY支付流水
     * @return CNY支付流水
     */
    @Override
    public List<PayFlow> selectPayFlowList(PayFlow payFlow)
    {
        return payFlowMapper.selectPayFlowList(payFlow);
    }

    /**
     * 新增CNY支付流水
     *
     * @param payFlow CNY支付流水
     * @return 结果
     */
    @Override
    public int insertPayFlow(PayFlow payFlow) {
        payFlow.setCreateTime(null);
        return payFlowMapper.insertPayFlow(payFlow);
    }

    /**
     * 修改CNY支付流水
     *
     * @param payFlow CNY支付流水
     * @return 结果
     */
    @Override
    public int updatePayFlow(PayFlow payFlow)
    {
        payFlow.setUpdateTime(null);
        return payFlowMapper.updatePayFlow(payFlow);
    }

    /**
     * 批量删除CNY支付流水
     *
     * @param ids 需要删除的CNY支付流水主键
     * @return 结果
     */
    @Override
    public int deletePayFlowByIds(Long[] ids)
    {
        return payFlowMapper.deletePayFlowByIds(ids);
    }

    /**
     * 删除CNY支付流水信息
     *
     * @param id CNY支付流水主键
     * @return 结果
     */
    @Override
    public int deletePayFlowById(Long id)
    {
        return payFlowMapper.deletePayFlowById(id);
    }

    @Override
    public List<PayFlow> listWithChildren(PayFlow entity) {
        return payFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<PayFlow> listWithParents(PayFlow  entity) {
        return payFlowMapper.listWithParents(entity);
    }

    @Override
    public int operateOk(Long[] ids) {
        int ok = 0;
        for (Long id : ids) {
            String param = String.format("?id=%s", id);
            String body = null;
            try {
                body = HttpRequest.get(appProperties.getPrefix() + AppApi.PAYFLOW_OK + param)
                        .header("Accept-Language", "zh-CN")
                        .execute().body();
                JSONObject json = JSONObject.parseObject(body);
                if (Constant.ZERO_STR.equals(json.getString("code"))) {
                    ok++;
                }
            } catch (Throwable e) {
                log.info(StrUtil.format("operateOk-{} fail", id), e);
            }
        }
        return ok;
    }

    @Override
    public int operateRefund(Long[] ids) {
        int ok = 0;
        for (Long id : ids) {
            String param = String.format("?id=%s", id);
            String body = null;
            try {
                body = HttpRequest.get(appProperties.getPrefix() + AppApi.PAYFLOW_REFUND + param)
                        .header("Accept-Language", "zh-CN")
                        .execute().body();
                JSONObject json = JSONObject.parseObject(body);
                if (Constant.ZERO_STR.equals(json.getString("code"))) {
                    ok++;
                }
            } catch (Throwable e) {
                log.info(StrUtil.format("operateRefund-{} fail", id), e);
            }
        }
        return ok;
    }
}
