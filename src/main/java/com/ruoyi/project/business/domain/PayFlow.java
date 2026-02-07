package com.ruoyi.project.business.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * CNY支付流水对象 z_pay_flow
 *
 * @author gpthk
 * @date 2025-11-12
 */
@Data
public class PayFlow extends BaseExtMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 场景 */
    @Excel(name = "场景")
    private String scene;

    /** 关联id */
    @Excel(name = "关联id")
    private Long relateId;

    /** 供应商 */
    @Excel(name = "供应商")
    private String provider;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String payMode;

    /** 支付通道 */
    @Excel(name = "支付通道")
    private String payChannel;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private Integer payStatus;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String extInfo;

    /** 请求响应 */
    @Excel(name = "请求响应")
    private String resp;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** 成功通知 */
    @Excel(name = "成功通知", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long notifyAt;

    /** 失败回调 */
    @Excel(name = "失败回调", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long fallbackAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("scene", getScene())
            .append("relateId", getRelateId())
            .append("provider", getProvider())
            .append("uid", getUid())
            .append("amount", getAmount())
            .append("quantity", getQuantity())
            .append("payMode", getPayMode())
            .append("payChannel", getPayChannel())
            .append("status", getStatus())
            .append("payStatus", getPayStatus())
            .append("extInfo", getExtInfo())
            .append("resp", getResp())
            .append("createAt", getCreateAt())
            .append("notifyAt", getNotifyAt())
            .append("fallbackAt", getFallbackAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
