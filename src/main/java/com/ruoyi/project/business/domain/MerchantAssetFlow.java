package com.ruoyi.project.business.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 商家资产流水对象 p_merchant_asset_flow
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class MerchantAssetFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */

    private Long id;

    /** 商家id */
    @Excel(name = "商家id")
    private Long mid;

    /** 用户id  */
    @Excel(name = "用户id ")
    private Long uid;

    /** 场景 */
    @Excel(name = "场景")
    private String scene;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 账期 */
    @Excel(name = "账期")
    private Long day;

    /** 法币数量 */
    @Excel(name = "法币数量")
    private BigDecimal baseAmount;

    /** 法币 */
    @Excel(name = "法币")
    private String currency;

    /** 汇率 */
    @Excel(name = "汇率")
    private BigDecimal exchangeRate;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal balance;

    /** 冻结变动 */
    @Excel(name = "冻结变动")
    private BigDecimal frozen;

    /** 关联id */
    @Excel(name = "关联id")
    private Long relateId;

    /** $column.columnComment */
    @Excel(name = "关联备注", readConverterExp = "$column.readConverterExp()")
    private String relateMemo;

    /** $column.columnComment */
    private Long clearDay;

    /** $column.columnComment */
    @Excel(name = "起始余额", readConverterExp = "$column.readConverterExp()")
    private BigDecimal beginBalance;

    /** $column.columnComment */
    @Excel(name = "起始冻结", readConverterExp = "$column.readConverterExp()")
    private BigDecimal beginFrozen;

    /** 付款从 */
    @Excel(name = "付款人id")
    private Long payUid;
    @Excel(name = "付款人")
    private String payer;

    @Excel(name = "支付渠道")
    private String payChannel;
    /** 收款方式 */
    @Excel(name = "收款方式")
    private String payment;

    /** 是否退款 */
    @Excel(name = "是否退款")
    private Long refunded;

    /** 退款时间 */
    @Excel(name = "退款时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long refundAt;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mid", getMid())
            .append("uid", getUid())
            .append("scene", getScene())
            .append("symbol", getSymbol())
            .append("day", getDay())
            .append("baseAmount", getBaseAmount())
            .append("currency", getCurrency())
            .append("exchangeRate", getExchangeRate())
            .append("balance", getBalance())
            .append("frozen", getFrozen())
            .append("relateId", getRelateId())
            .append("relateMemo", getRelateMemo())
            .append("clearDay", getClearDay())
            .append("beginBalance", getBeginBalance())
            .append("beginFrozen", getBeginFrozen())
            .append("payer", getPayer())
            .append("payment", getPayment())
            .append("refunded", getRefunded())
            .append("refundAt", getRefundAt())
            .append("memo", getMemo())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
