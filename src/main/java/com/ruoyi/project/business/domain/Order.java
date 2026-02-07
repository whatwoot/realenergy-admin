package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 支付订单对象 b_order
 *
 * @author gpthk
 * @date 2025-05-20
 */
@Data
public class Order extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id", sort = 1)
    private Long id;

    /** 流水 */
    @Excel(name = "流水")
    private Long sn;

    /** UID */
    @Excel(name = "UID", sort = 2)
    private Long uid;

    @Excel(name = "父UID", sort = 4)
    private Long puid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 商户id */
    @Excel(name = "商户id")
    private Long mid;

    /** 收款方式ID */
    @Excel(name = "收款方式ID")
    private Long pid;

    /** 商户uid */
    @Excel(name = "商户uid")
    private Long merchantUid;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String merchantName;

    /** 商户法人 */
    @Excel(name = "商户法人")
    private String merchantLegal;

    /** 商户联系方式 */
    @Excel(name = "商户联系方式")
    private String merchantContact;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 结算代币 */
    @Excel(name = "结算代币")
    private String receiptSymbol;

    /** 法币金额 */
    @Excel(name = "法币金额")
    private BigDecimal baseAmount;

    /** 货币 */
    @Excel(name = "货币")
    private String currency;

    /** 汇率 */
    @Excel(name = "汇率")
    private BigDecimal exchangeRate;

    /** 收款方式类型 */
    @Excel(name = "收款方式类型")
    private Integer paymentType;

    /** 收款姓名 */
    @Excel(name = "收款姓名")
    private String paymentName;

    /** 收款账号 */
    @Excel(name = "收款账号")
    private String paymentAccount;

    /** 备注 */
    @Excel(name = "备注")
    private String paymentMemo;

    /** 收款码 */
    @Excel(name = "收款码")
    private String paymentCode;

    /** 支付时间 */
    @Excel(name = "支付时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long payAt;

    /** 过期时间 */
    @Excel(name = "过期时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long expireAt;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sn", getSn())
            .append("uid", getUid())
            .append("name", getName())
            .append("email", getEmail())
            .append("mid", getMid())
            .append("pid", getPid())
            .append("merchantUid", getMerchantUid())
            .append("merchantName", getMerchantName())
            .append("merchantLegal", getMerchantLegal())
            .append("merchantContact", getMerchantContact())
            .append("amount", getAmount())
            .append("receiptSymbol", getReceiptSymbol())
            .append("baseAmount", getBaseAmount())
            .append("currency", getCurrency())
            .append("exchangeRate", getExchangeRate())
            .append("paymentType", getPaymentType())
            .append("paymentName", getPaymentName())
            .append("paymentAccount", getPaymentAccount())
            .append("paymentMemo", getPaymentMemo())
            .append("paymentCode", getPaymentCode())
            .append("payAt", getPayAt())
            .append("expireAt", getExpireAt())
            .append("status", getStatus())
            .append("memo", getMemo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
