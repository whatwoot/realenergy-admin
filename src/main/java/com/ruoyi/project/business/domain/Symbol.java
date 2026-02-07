package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 代币表对象 c_symbol
 *
 * @author gpthk
 * @date 2025-03-22
 */
@Data
public class Symbol extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 成员 */
    @Excel(name = "成员")
    private Integer orgId;

    /** 链 */
    @Excel(name = "链")
    private String chain;

    /** 链引擎 */
    @Excel(name = "链引擎")
    private String chainEngine;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 可充 */
    @Excel(name = "可充")
    private Integer canRecharge;

    /** 可提 */
    @Excel(name = "可提")
    private Integer canWithdraw;

    /** 稳定币 */
    @Excel(name = "稳定币")
    private Integer stablecoin;

    /** 本链币 */
    @Excel(name = "本链币")
    private Integer chaincoin;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String contractAddr;

    /** 精度 */
    @Excel(name = "精度")
    private Long decimals;

    /** 提现精度 */
    @Excel(name = "提现精度")
    private Long withdrawDecimals;

    /** 最小提现 */
    @Excel(name = "最小提现")
    private BigDecimal withdrawMin;

    /** 最小充值 */
    @Excel(name = "最小充值")
    private BigDecimal rechargeMin;

    /** 提现手续费率 */
    @Excel(name = "提现手续费率")
    private BigDecimal withdrawFeeRate;

    /** 固定提现手续费 */
    @Excel(name = "固定提现手续费")
    private BigDecimal withdrawFee;

    /** 最小提现手续费 */
    @Excel(name = "最小提现手续费")
    private BigDecimal withdrawFeeMin;

    /** 奖励比例 */
    @Excel(name = "奖励比例")
    private BigDecimal prizeRate;

    /** 是否归集 */
    @Excel(name = "是否归集")
    private Integer collect;

    /** 最小归集金额 */
    @Excel(name = "最小归集金额")
    private BigDecimal collectMin;

    /** 归集gas */
    @Excel(name = "归集gas")
    private BigDecimal collectGas;

    /** gas费代币 */
    @Excel(name = "gas费代币")
    private String gasSymbol;

    /** 权重 */
    @Excel(name = "权重")
    private Integer weight;

    /** 显示 */
    @Excel(name = "显示")
    private Integer showed;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orgId", getOrgId())
            .append("chain", getChain())
            .append("chainEngine", getChainEngine())
            .append("symbol", getSymbol())
            .append("canRecharge", getCanRecharge())
            .append("canWithdraw", getCanWithdraw())
            .append("stablecoin", getStablecoin())
            .append("chaincoin", getChaincoin())
            .append("contractAddr", getContractAddr())
            .append("decimals", getDecimals())
            .append("withdrawDecimals", getWithdrawDecimals())
            .append("withdrawMin", getWithdrawMin())
            .append("rechargeMin", getRechargeMin())
            .append("withdrawFeeRate", getWithdrawFeeRate())
            .append("withdrawFee", getWithdrawFee())
            .append("withdrawFeeMin", getWithdrawFeeMin())
            .append("prizeRate", getPrizeRate())
            .append("collect", getCollect())
            .append("collectMin", getCollectMin())
            .append("collectGas", getCollectGas())
            .append("gasSymbol", getGasSymbol())
            .append("weight", getWeight())
            .append("showed", getShowed())
            .toString();
    }
}
