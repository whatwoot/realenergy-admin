package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 策略对象 t_trader
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Data
public class Trader extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 策略 */
    @Excel(name = "策略")
    private String strategy;

    /** 交易平台 */
    @Excel(name = "交易平台")
    private String platform;

    /** 类型 */
    @Excel(name = "类型")
    private Long cate;

    /** 封闭 */
    @Excel(name = "封闭")
    private Long closedEnd;

    /** 累计收入 */
    @Excel(name = "累计收入")
    private BigDecimal tradeTotalIncome;

    /** 收益率 */
    @Excel(name = "收益率")
    private BigDecimal tradeYieldRate;

    /** 年化收益率 */
    @Excel(name = "年化收益率")
    private BigDecimal annualizedReturnRate;

    /** 最大回撤 */
    @Excel(name = "最大回撤")
    private BigDecimal maxDrawdown;

    /** 本金 */
    @Excel(name = "本金")
    private BigDecimal principalAmount;

    /** 参与人数 */
    @Excel(name = "参与人数")
    private Long participantCount;

    /** 当前资金 */
    @Excel(name = "当前资金")
    private BigDecimal currentAmount;

    /** 资金规模 */
    @Excel(name = "资金规模")
    private BigDecimal fundAmount;

    /** 胜率 */
    @Excel(name = "胜率")
    private BigDecimal winRate;

    /** 交易次数 */
    @Excel(name = "交易次数")
    private Long tradeCount;

    /** 限制人数 */
    @Excel(name = "限制人数")
    private Long limitNum;

    /** 限制金额 */
    @Excel(name = "限制金额")
    private BigDecimal limitAmount;

    /** 封闭天数 */
    @Excel(name = "封闭天数")
    private Long closedDay;

    /** 参与人数 */
    @Excel(name = "参与人数")
    private Long participantNum;

    /** 跟单用户总收入 */
    @Excel(name = "跟单用户总收入")
    private BigDecimal followTotalIncome;

    /** 跟单用户总收益率 */
    @Excel(name = "跟单用户总收益率")
    private BigDecimal followYieldRate;

    /** 收益历史 */
    @Excel(name = "收益历史")
    private String profitList;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private Long startAt;

    /** 上次开始时间 */
    @Excel(name = "上次开始时间")
    private Long lastStartAt;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal volume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal compensation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal fundAdjustAmount;

    /** 最小参与金额 */
    @Excel(name = "最小参与金额")
    private BigDecimal minAmount;

    /** 最大参与金额 */
    @Excel(name = "最大参与金额")
    private BigDecimal maxAmount;

    /** 显示 */
    @Excel(name = "显示")
    private Long showed;

    /** 奖池比例配置 */
    @Excel(name = "奖池比例配置")
    private String rates;

    /** 达标奖池比例 */
    @Excel(name = "达标奖池比例")
    private String fullRates;

    /** 跟单押金比例 */
    @Excel(name = "跟单押金比例")
    private BigDecimal marginRate;

    /** 跟单警告押金比例 */
    @Excel(name = "跟单警告押金比例")
    private BigDecimal warnMarginRate;

    /** 跟单暂停押金比例 */
    @Excel(name = "跟单暂停押金比例")
    private BigDecimal stopMarginRate;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("name", getName())
            .append("strategy", getStrategy())
            .append("platform", getPlatform())
            .append("cate", getCate())
            .append("closedEnd", getClosedEnd())
            .append("tradeTotalIncome", getTradeTotalIncome())
            .append("tradeYieldRate", getTradeYieldRate())
            .append("annualizedReturnRate", getAnnualizedReturnRate())
            .append("maxDrawdown", getMaxDrawdown())
            .append("principalAmount", getPrincipalAmount())
            .append("participantCount", getParticipantCount())
            .append("currentAmount", getCurrentAmount())
            .append("fundAmount", getFundAmount())
            .append("winRate", getWinRate())
            .append("tradeCount", getTradeCount())
            .append("limitNum", getLimitNum())
            .append("limitAmount", getLimitAmount())
            .append("closedDay", getClosedDay())
            .append("participantNum", getParticipantNum())
            .append("followTotalIncome", getFollowTotalIncome())
            .append("followYieldRate", getFollowYieldRate())
            .append("profitList", getProfitList())
            .append("startAt", getStartAt())
            .append("lastStartAt", getLastStartAt())
            .append("status", getStatus())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("volume", getVolume())
            .append("compensation", getCompensation())
            .append("fundAdjustAmount", getFundAdjustAmount())
            .append("minAmount", getMinAmount())
            .append("maxAmount", getMaxAmount())
            .append("showed", getShowed())
            .append("rates", getRates())
            .append("fullRates", getFullRates())
            .append("marginRate", getMarginRate())
            .append("warnMarginRate", getWarnMarginRate())
            .append("stopMarginRate", getStopMarginRate())
            .toString();
    }
}
