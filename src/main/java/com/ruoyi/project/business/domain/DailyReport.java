package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 每日报表对象 b_daily_report
 *
 * @author gpthk
 * @date 2025-11-16
 */
@Data
public class DailyReport extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private Integer ymd;

    /** h1人均 */
    @Excel(name = "h1人均")
    private BigDecimal h1AvgAmount;

    /** h1人数 */
    @Excel(name = "h1人数")
    private Integer h1Num;

    /** h1总额 */
    @Excel(name = "h1总额")
    private BigDecimal h1TotalAmount;

    /** h2人均 */
    @Excel(name = "h2人均")
    private BigDecimal h2AvgAmount;

    /** h2人数 */
    @Excel(name = "h2人数")
    private Integer h2Num;

    /** h2总额 */
    @Excel(name = "h2总额")
    private BigDecimal h2TotalAmount;

    /** h3人均 */
    @Excel(name = "h3人均")
    private BigDecimal h3AvgAmount;

    /** h3人数 */
    @Excel(name = "h3人数")
    private Integer h3Num;

    /** h3总额 */
    @Excel(name = "h3总额")
    private BigDecimal h3TotalAmount;

    /** h4人均 */
    @Excel(name = "h4人均")
    private BigDecimal h4AvgAmount;

    /** h4人数 */
    @Excel(name = "h4人数")
    private Integer h4Num;

    /** h4总额 */
    @Excel(name = "h4总额")
    private BigDecimal h4TotalAmount;

    /** h5人均 */
    @Excel(name = "h5人均")
    private BigDecimal h5AvgAmount;

    /** h5人数 */
    @Excel(name = "h5人数")
    private Integer h5Num;

    /** h5总额 */
    @Excel(name = "h5总额")
    private BigDecimal h5TotalAmount;

    /** h6人均 */
    @Excel(name = "h6人均")
    private BigDecimal h6AvgAmount;

    /** h6人数 */
    @Excel(name = "h6人数")
    private Integer h6Num;

    /** h6总额 */
    @Excel(name = "h6总额")
    private BigDecimal h6TotalAmount;

    /** h7人均 */
    @Excel(name = "h7人均")
    private BigDecimal h7AvgAmount;

    /** h7人数 */
    @Excel(name = "h7人数")
    private Integer h7Num;

    /** h7总额 */
    @Excel(name = "h7总额")
    private BigDecimal h7TotalAmount;

    /** 邀请人均 */
    @Excel(name = "邀请人均")
    private BigDecimal invitePerAmount;

    /** 邀请人数 */
    @Excel(name = "邀请人数")
    private Integer inviteNum;

    /** 邀请总额 */
    @Excel(name = "邀请总额")
    private BigDecimal inviteTotalAmount;

    /** 理财总额 */
    @Excel(name = "理财总额")
    private BigDecimal totalInvestAmount;

    /** USDT提现总额 */
    @Excel(name = "USDT提现总额")
    private BigDecimal withdrawAmount;

    /** 充值总额 */
    @Excel(name = "充值总额")
    private BigDecimal rechargeAmount;

    /** 系统充值总额 */
    @Excel(name = "系统充值总额")
    private BigDecimal sysAddAmount;

    /** 系统扣除总额 */
    @Excel(name = "系统扣除总额")
    private BigDecimal sysReduceAmount;

    /** 支付宝总额 */
    @Excel(name = "支付宝总额")
    private BigDecimal withdrawAlipayAmount;

    /** 理财总额 */
    @Excel(name = "理财总额")
    private BigDecimal investAmount;

    /** NFT卖出总额 */
    @Excel(name = "NFT卖出总额")
    private BigDecimal nftSellAmount;

    /** NFT分红总额 */
    @Excel(name = "NFT分红总额")
    private BigDecimal nftStaticAmount;

    /** 静态总额 */
    @Excel(name = "静态总额")
    private BigDecimal staticAmount;

    /** 代数奖总额 */
    @Excel(name = "代数奖总额")
    private BigDecimal inviteAmount;

    /** 团队奖总额 */
    @Excel(name = "团队奖总额")
    private BigDecimal dynamicAmount;

    /** 平级奖总额 */
    @Excel(name = "平级奖总额")
    private BigDecimal sameLevelAmount;

    /** 溢出赎回总额 */
    @Excel(name = "溢出赎回总额")
    private BigDecimal overflowAmount;

    /** 销售奖总额 */
    @Excel(name = "销售奖总额")
    private BigDecimal inviteRankAmount;

    /** 爆破池总额 */
    @Excel(name = "爆破池总额")
    private BigDecimal poolAmount;

    /** 节点手续费总额 */
    @Excel(name = "节点手续费总额")
    private BigDecimal nodeFeeAmount;

    /** 闪总USDT总额 */
    @Excel(name = "闪总USDT总额")
    private BigDecimal exchangeUsdtAmount;

    /** 余额宝利息 */
    @Excel(name = "余额宝利息")
    private BigDecimal fundAmount;

    /** 铸币总量 */
    @Excel(name = "铸币总量")
    private BigDecimal tokenMintQuantity;

    /** 铸币分红总量 */
    @Excel(name = "铸币分红总量")
    private BigDecimal nodeMintQuantity;

    /** 闪总代币总量 */
    @Excel(name = "闪总代币总量")
    private BigDecimal exchangeTokenAmount;

    /** USDT余额 */
    @Excel(name = "USDT余额")
    private BigDecimal usdtAmount;

    /** 代币余额 */
    @Excel(name = "代币余额")
    private BigDecimal tokenAmount;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ymd", getYmd())
            .append("h1AvgAmount", getH1AvgAmount())
            .append("h1Num", getH1Num())
            .append("h1TotalAmount", getH1TotalAmount())
            .append("h2AvgAmount", getH2AvgAmount())
            .append("h2Num", getH2Num())
            .append("h2TotalAmount", getH2TotalAmount())
            .append("h3AvgAmount", getH3AvgAmount())
            .append("h3Num", getH3Num())
            .append("h3TotalAmount", getH3TotalAmount())
            .append("h4AvgAmount", getH4AvgAmount())
            .append("h4Num", getH4Num())
            .append("h4TotalAmount", getH4TotalAmount())
            .append("h5AvgAmount", getH5AvgAmount())
            .append("h5Num", getH5Num())
            .append("h5TotalAmount", getH5TotalAmount())
            .append("h6AvgAmount", getH6AvgAmount())
            .append("h6Num", getH6Num())
            .append("h6TotalAmount", getH6TotalAmount())
            .append("h7AvgAmount", getH7AvgAmount())
            .append("h7Num", getH7Num())
            .append("h7TotalAmount", getH7TotalAmount())
            .append("invitePerAmount", getInvitePerAmount())
            .append("inviteNum", getInviteNum())
            .append("inviteTotalAmount", getInviteTotalAmount())
            .append("createTime", getCreateTime())
            .append("totalInvestAmount", getTotalInvestAmount())
            .append("withdrawAmount", getWithdrawAmount())
            .append("rechargeAmount", getRechargeAmount())
            .append("sysAddAmount", getSysAddAmount())
            .append("sysReduceAmount", getSysReduceAmount())
            .append("withdrawAlipayAmount", getWithdrawAlipayAmount())
            .append("investAmount", getInvestAmount())
            .append("nftSellAmount", getNftSellAmount())
            .append("nftStaticAmount", getNftStaticAmount())
            .append("staticAmount", getStaticAmount())
            .append("inviteAmount", getInviteAmount())
            .append("dynamicAmount", getDynamicAmount())
            .append("sameLevelAmount", getSameLevelAmount())
            .append("overflowAmount", getOverflowAmount())
            .append("inviteRankAmount", getInviteRankAmount())
            .append("poolAmount", getPoolAmount())
            .append("nodeFeeAmount", getNodeFeeAmount())
            .append("exchangeUsdtAmount", getExchangeUsdtAmount())
            .append("fundAmount", getFundAmount())
            .append("tokenMintQuantity", getTokenMintQuantity())
            .append("nodeMintQuantity", getNodeMintQuantity())
            .append("exchangeTokenAmount", getExchangeTokenAmount())
            .append("usdtAmount", getUsdtAmount())
            .append("tokenAmount", getTokenAmount())
            .toString();
    }
}
