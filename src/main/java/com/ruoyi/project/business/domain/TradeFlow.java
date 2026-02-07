package com.ruoyi.project.business.domain;

import java.math.BigDecimal;

import com.ruoyi.framework.web.domain.BaseExtEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 交易流水对象 b_trade_flow
 *
 * @author gpthk
 * @date 2025-11-07
 */
@Data
public class TradeFlow extends BaseExtEntity {

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 方向 */
    @Excel(name = "方向")
    private Integer type;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 交易价格 */
    @Excel(name = "交易价格")
    private BigDecimal price;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 交易金额 */
    @Excel(name = "交易金额")
    private BigDecimal amount;

    /** 交易后价格 */
    @Excel(name = "交易后价格")
    private BigDecimal close;

    /** 日期 */
    @Excel(name = "日期")
    private Integer ymd;

    /** 时间 */
    @Excel(name = "时间")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("uid", getUid())
            .append("price", getPrice())
            .append("quantity", getQuantity())
            .append("amount", getAmount())
            .append("close", getClose())
            .append("ymd", getYmd())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
