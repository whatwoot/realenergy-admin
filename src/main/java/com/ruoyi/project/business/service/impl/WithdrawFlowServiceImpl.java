package com.ruoyi.project.business.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.domain.ChainWork;
import com.ruoyi.project.business.domain.Symbol;
import com.ruoyi.project.business.domain.WithdrawFlow;
import com.ruoyi.project.business.enums.ChainWorkTxStatusEnum;
import com.ruoyi.project.business.enums.ChainWorkTypeEnum;
import com.ruoyi.project.business.enums.WithdrawStatusEnum;
import com.ruoyi.project.business.mapper.ChainWorkMapper;
import com.ruoyi.project.business.mapper.SymbolMapper;
import com.ruoyi.project.business.mapper.WithdrawFlowMapper;
import com.ruoyi.project.business.service.IWithdrawFlowService;
import com.cs.sp.constant.Constant;
import com.cs.sp.enums.YesNoByteEnum;
import com.cs.sp.enums.YesNoIntEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 提现流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Slf4j
@Service
public class WithdrawFlowServiceImpl implements IWithdrawFlowService {
    @Autowired
    private WithdrawFlowMapper withdrawFlowMapper;

    @Autowired
    private ChainWorkMapper chainWorkMapper;

    @Autowired
    private SymbolMapper symbolMapper;

    @Autowired
    private AppProperties appProperties;

    /**
     * 查询提现流水
     *
     * @param id 提现流水主键
     * @return 提现流水
     */
    @Override
    public WithdrawFlow selectWithdrawFlowById(Long id) {
        return withdrawFlowMapper.selectWithdrawFlowById(id);
    }

    /**
     * 查询提现流水列表
     *
     * @param withdrawFlow 提现流水
     * @return 提现流水
     */
    @Override
    public List<WithdrawFlow> selectWithdrawFlowList(WithdrawFlow withdrawFlow) {
        return withdrawFlowMapper.selectWithdrawFlowList(withdrawFlow);
    }

    /**
     * 新增提现流水
     *
     * @param withdrawFlow 提现流水
     * @return 结果
     */
    @Override
    public int insertWithdrawFlow(WithdrawFlow withdrawFlow) {
        withdrawFlow.setCreateTime(null);
        return withdrawFlowMapper.insertWithdrawFlow(withdrawFlow);
    }

    /**
     * 修改提现流水
     *
     * @param withdrawFlow 提现流水
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWithdrawFlow(WithdrawFlow withdrawFlow) {
        withdrawFlow.setUpdateTime(null);
        WithdrawFlow exists = withdrawFlowMapper.selectWithdrawFlowById(withdrawFlow.getId());
        boolean audit = !YesNoIntEnum.YES.eq(exists.getAuditStatus()) &&
                YesNoIntEnum.YES.eq(withdrawFlow.getAuditStatus()) &&
                !StringUtils.hasText(withdrawFlow.getClaimTx());
        boolean toRefund = !WithdrawStatusEnum.REFUND.eq(exists.getStatus()) && WithdrawStatusEnum.REFUND.eq(withdrawFlow.getStatus());
        if (toRefund) {
            String url = appProperties.getPrefix() + AppApi.WITHDRAW_REFUND + String.format("?id=%s", exists.getId());
            log.info("WithdrawFlow-refund url:{}", url);
            String body = HttpRequest.get(url)
                    .header("Accept-Language", "zh-CN")
                    .execute().body();
            log.info("WithdrawFlow-refund res:{}", body);
            JSONObject json = JSONObject.parseObject(body);
            if (!Constant.ZERO_STR.equals(json.getString("code"))) {
                throwBizException(json.getString("msg"));
            }
        } else {
            if (audit) {
                withdrawFlow.setAuditAt(System.currentTimeMillis());
            }
            int row = withdrawFlowMapper.updateWithdrawFlow(withdrawFlow);
            if (exists != null) {
                // 如果是审核状态从未通过，改为通过
                if (audit) {
                    ChainWork param = new ChainWork();
                    param.setRelateId(withdrawFlow.getId());
                    param.setType(ChainWorkTypeEnum.WITHDRAW.getCode());
                    List<ChainWork> txs = chainWorkMapper.selectChainWorkList(param);
                    if (!txs.isEmpty()) {
                        return row;
                    }
                    Symbol query = new Symbol();
                    query.setOrgId(0);
                    query.setChain("bsc");
                    query.setSymbol(withdrawFlow.getArriveSymbol());
                    List<Symbol> symbols = symbolMapper.selectSymbolList(query);
                    ChainWork chainWork = new ChainWork();
                    chainWork.setChain("bsc");
                    chainWork.setType(ChainWorkTypeEnum.WITHDRAW.getCode());
                    // 不记录发出地址，执行的时候再记录
                    chainWork.setToAddr(withdrawFlow.getArriveAddr());
                    chainWork.setContract(symbols.get(0).getContractAddr());
                    chainWork.setSymbol(symbols.get(0).getSymbol());
                    chainWork.setAmount(withdrawFlow.getArriveQuantity());
                    chainWork.setStatus(YesNoByteEnum.YES.getCode());
                    chainWork.setTxStatus(ChainWorkTxStatusEnum.WAIT.getCode());
                    chainWork.setCreateAt(System.currentTimeMillis());
                    // 添加排队时间
                    // 1、本身会会添加到执行队列的
                    // 2、同时又防止被定时任务立即捞起来，重复加队列
                    chainWork.setQueueAt(chainWork.getCreateAt() + 18000L);
                    chainWork.setRelateId(withdrawFlow.getId());
                    chainWorkMapper.insertChainWork(chainWork);
                }
            }
        }
        return 1;
    }

    /**
     * 批量删除提现流水
     *
     * @param ids 需要删除的提现流水主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawFlowByIds(Long[] ids) {
        return withdrawFlowMapper.deleteWithdrawFlowByIds(ids);
    }

    /**
     * 删除提现流水信息
     *
     * @param id 提现流水主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawFlowById(Long id) {
        return withdrawFlowMapper.deleteWithdrawFlowById(id);
    }

    @Override
    public List<WithdrawFlow> listWithChildren(WithdrawFlow entity) {
        return withdrawFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<WithdrawFlow> listWithParents(WithdrawFlow entity) {
        return withdrawFlowMapper.listWithParents(entity);
    }

    @Override
    public int updateAudit(WithdrawFlow update) {
        WithdrawFlow withdrawFlow = withdrawFlowMapper.selectWithdrawFlowById(update.getId());
        if(withdrawFlow == null){
            return 0;
        }
        if(!WithdrawStatusEnum.AUDITED.eq(update.getStatus())){
            return 0;
        }

        WithdrawFlow audit =new WithdrawFlow();
        audit.setId(update.getId());
        audit.setAuditAt(System.currentTimeMillis());
        audit.setAuditStatus(YesNoIntEnum.YES.getCode());
        // cny不需要其他处理
        if("cny".equals(withdrawFlow.getChain())){
            audit.setStatus(WithdrawStatusEnum.AUDITED.getCode());
        }
        return withdrawFlowMapper.updateWithdrawFlow(audit);
    }
}
