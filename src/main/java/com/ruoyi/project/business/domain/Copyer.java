package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 用户跟单对象 t_copyer
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Data
public class Copyer extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 带单师id */
    @Excel(name = "带单师id")
    private Long traderId;

    /** 总收益 */
    @Excel(name = "总收益")
    private BigDecimal totalIncome;

    /** 收益率 */
    @Excel(name = "收益率")
    private BigDecimal yieldRate;

    /** 年化收益率 */
    @Excel(name = "年化收益率")
    private BigDecimal annualizedReturnRate;

    /** 最大回撤 */
    @Excel(name = "最大回撤")
    private BigDecimal maxDrawdown;

    /** 当前余额 */
    @Excel(name = "当前余额")
    private BigDecimal currentAmount;

    /** 本金 */
    @Excel(name = "本金")
    private BigDecimal principalAmount;

    /** 保证代币数量 */
    @Excel(name = "保证代币数量")
    private BigDecimal marginQuantity;

    /** 保证金价格 */
    @Excel(name = "保证金价格")
    private BigDecimal marginPrice;

    /** 当前保证金 */
    @Excel(name = "当前保证金")
    private BigDecimal marginAmount;

    /** 交易次数 */
    @Excel(name = "交易次数")
    private Long tradeCount;

    /** 赢利次数 */
    @Excel(name = "赢利次数")
    private Long winNum;

    /** 胜率 */
    @Excel(name = "胜率")
    private BigDecimal winRate;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private Long startAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long stopAt;

    /** 创建于 */
    @Excel(name = "创建于")
    private Long createAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String errMsg;

    /** 记录跟单时刻父级 */
    @Excel(name = "记录跟单时刻父级")
    private String parents;

    /** 记录跟单时刻父级业绩比例 */
    @Excel(name = "记录跟单时刻父级业绩比例")
    private BigDecimal parentsRate;

    /** 累计手续费 */
    @Excel(name = "累计手续费")
    private BigDecimal totalFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String profitList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long wins;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jackpots;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("uid", getUid())
            .append("traderId", getTraderId())
            .append("totalIncome", getTotalIncome())
            .append("yieldRate", getYieldRate())
            .append("annualizedReturnRate", getAnnualizedReturnRate())
            .append("maxDrawdown", getMaxDrawdown())
            .append("currentAmount", getCurrentAmount())
            .append("principalAmount", getPrincipalAmount())
            .append("marginQuantity", getMarginQuantity())
            .append("marginPrice", getMarginPrice())
            .append("marginAmount", getMarginAmount())
            .append("tradeCount", getTradeCount())
            .append("winNum", getWinNum())
            .append("winRate", getWinRate())
            .append("startAt", getStartAt())
            .append("stopAt", getStopAt())
            .append("createAt", getCreateAt())
            .append("status", getStatus())
            .append("errMsg", getErrMsg())
            .append("parents", getParents())
            .append("parentsRate", getParentsRate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("totalFee", getTotalFee())
            .append("profitList", getProfitList())
            .append("wins", getWins())
            .append("jackpots", getJackpots())
            .toString();
    }
}
