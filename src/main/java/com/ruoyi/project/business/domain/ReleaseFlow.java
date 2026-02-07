package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 等待释放对象 t_release_flow
 *
 * @author gpthk
 * @date 2025-12-31
 */
@Data
public class ReleaseFlow extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 实时币价 */
    @Excel(name = "实时币价")
    private BigDecimal price;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderId;

    /** 平仓时间 */
    @Excel(name = "平仓时间")
    private Long closeAt;

    /** 释放时间 */
    @Excel(name = "释放时间")
    private Long releaseAt;

    /** 释放周期 */
    @Excel(name = "释放周期")
    private Long releasePeriod;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lastReleaseDay;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal leftAmount;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("amount", getAmount())
            .append("quantity", getQuantity())
            .append("price", getPrice())
            .append("orderId", getOrderId())
            .append("closeAt", getCloseAt())
            .append("releaseAt", getReleaseAt())
            .append("releasePeriod", getReleasePeriod())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("type", getType())
            .append("lastReleaseDay", getLastReleaseDay())
            .append("leftAmount", getLeftAmount())
            .toString();
    }
}
