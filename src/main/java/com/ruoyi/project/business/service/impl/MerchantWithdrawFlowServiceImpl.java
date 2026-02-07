package com.ruoyi.project.business.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.domain.ChainWork;
import com.ruoyi.project.business.domain.MerchantWithdrawFlow;
import com.ruoyi.project.business.domain.Symbol;
import com.ruoyi.project.business.enums.ChainWorkTxStatusEnum;
import com.ruoyi.project.business.enums.ChainWorkTypeEnum;
import com.ruoyi.project.business.enums.MerchantWithdrawFlowArriveTypeEnum;
import com.ruoyi.project.business.mapper.ChainWorkMapper;
import com.ruoyi.project.business.mapper.MerchantWithdrawFlowMapper;
import com.ruoyi.project.business.mapper.SymbolMapper;
import com.ruoyi.project.business.service.IMerchantWithdrawFlowService;
import com.cs.sp.constant.Constant;
import com.cs.sp.enums.YesNoByteEnum;
import com.cs.sp.enums.YesNoIntEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cs.sp.common.WebAssert.expect;
import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 商家提现流水Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-27
 */
@Slf4j
@Service
public class MerchantWithdrawFlowServiceImpl implements IMerchantWithdrawFlowService {

    @Autowired
    private ChainWorkMapper chainWorkMapper;

    @Autowired
    private SymbolMapper symbolMapper;

    @Autowired
    private MerchantWithdrawFlowMapper merchantWithdrawFlowMapper;

    @Autowired
    private AppProperties appProperties;

    /**
     * 查询商家提现流水
     *
     * @param id 商家提现流水主键
     * @return 商家提现流水
     */
    @Override
    public MerchantWithdrawFlow selectMerchantWithdrawFlowById(Long id) {
        return merchantWithdrawFlowMapper.selectMerchantWithdrawFlowById(id);
    }

    /**
     * 查询商家提现流水列表
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 商家提现流水
     */
    @Override
    public List<MerchantWithdrawFlow> selectMerchantWithdrawFlowList(MerchantWithdrawFlow merchantWithdrawFlow) {
        return merchantWithdrawFlowMapper.selectMerchantWithdrawFlowList(merchantWithdrawFlow);
    }

    /**
     * 新增商家提现流水
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 结果
     */
    @Override
    public int insertMerchantWithdrawFlow(MerchantWithdrawFlow merchantWithdrawFlow) {
        merchantWithdrawFlow.setCreateTime(null);
        return merchantWithdrawFlowMapper.insertMerchantWithdrawFlow(merchantWithdrawFlow);
    }

    /**
     * 修改商家提现流水
     *
     * @param merchantWithdrawFlow 商家提现流水
     * @return 结果
     */
    @Override
    public int updateMerchantWithdrawFlow(MerchantWithdrawFlow merchantWithdrawFlow) {
        merchantWithdrawFlow.setUpdateTime(null);
        MerchantWithdrawFlow exists = merchantWithdrawFlowMapper.selectMerchantWithdrawFlowById(merchantWithdrawFlow.getId());
        boolean isWithdrawAudit = YesNoIntEnum.NO.eq(exists.getAuditStatus().intValue()) &&
                YesNoIntEnum.YES.eq(merchantWithdrawFlow.getAuditStatus().intValue());
        if (isWithdrawAudit) {
            merchantWithdrawFlow.setAuditAt(System.currentTimeMillis());
        }
        int i = merchantWithdrawFlowMapper.updateMerchantWithdrawFlow(merchantWithdrawFlow);
        if (isWithdrawAudit && MerchantWithdrawFlowArriveTypeEnum.BSC.eq(merchantWithdrawFlow.getArriveType())) {
            ChainWork query = new ChainWork();
            query.setParam("merchant");
            query.setRelateId(exists.getId());
            List<ChainWork> chainWorks = chainWorkMapper.selectChainWorkList(query);
            if (chainWorks.isEmpty()) {
                Symbol symbol = new Symbol();
                symbol.setOrgId(1);
                symbol.setSymbol("NIMT");
                symbol.setChain(merchantWithdrawFlow.getChain());
                List<Symbol> symbols = symbolMapper.selectSymbolList(symbol);
                expect(!symbols.isEmpty(), "未找到代币");

                ChainWork chainWork = new ChainWork();
                chainWork.setParam("merchant");
                chainWork.setChain("bsc");
                chainWork.setType(ChainWorkTypeEnum.WITHDRAW.getCode());
                // 不记录发出地址，执行的时候再记录
                chainWork.setToAddr(merchantWithdrawFlow.getArriveAddr());
                chainWork.setContract(symbols.get(0).getContractAddr());
                chainWork.setSymbol(merchantWithdrawFlow.getArriveSymbol());
                chainWork.setAmount(merchantWithdrawFlow.getArriveQuantity());
                chainWork.setStatus(YesNoByteEnum.YES.getCode());
                chainWork.setTxStatus(ChainWorkTxStatusEnum.WAIT.getCode());
                chainWork.setCreateAt(System.currentTimeMillis());
                // 添加排队时间
                // 1、本身会会添加到执行队列的
                // 2、同时又防止被定时任务立即捞起来，重复加队列
                chainWork.setQueueAt(chainWork.getCreateAt());
                chainWork.setRelateId(exists.getId());
                chainWorkMapper.insertChainWork(chainWork);
            }
        }
        return i;
    }

    /**
     * 批量删除商家提现流水
     *
     * @param ids 需要删除的商家提现流水主键
     * @return 结果
     */
    @Override
    public int deleteMerchantWithdrawFlowByIds(Long[] ids) {
        return merchantWithdrawFlowMapper.deleteMerchantWithdrawFlowByIds(ids);
    }

    /**
     * 删除商家提现流水信息
     *
     * @param id 商家提现流水主键
     * @return 结果
     */
    @Override
    public int deleteMerchantWithdrawFlowById(Long id) {
        return merchantWithdrawFlowMapper.deleteMerchantWithdrawFlowById(id);
    }

    @Override
    public List<MerchantWithdrawFlow> listWithChildren(MerchantWithdrawFlow entity) {
        return merchantWithdrawFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<MerchantWithdrawFlow> listWithParents(MerchantWithdrawFlow entity) {
        return merchantWithdrawFlowMapper.listWithParents(entity);
    }

    @Override
    public int updateRefund(MerchantWithdrawFlow merchantWithdrawFlow) {
        String prefix = appProperties.getPrefix();
        String param = String.format("?id=%s", merchantWithdrawFlow.getId());
        String url = prefix + AppApi.MERCHANT_WITHDRAW_REFUND + param;
        log.info("refund url {}", url);
        String body = HttpRequest.get(url)
                .header("Accept-Language", "zh-CN")
                .execute().body();
        log.info("refund res {}", body);
        JSONObject json = JSONObject.parseObject(body);
        if (!Constant.ZERO_STR.equals(json.getString("code"))) {
            throwBizException(json.getString("msg"));
        }
        return 1;
    }
}
