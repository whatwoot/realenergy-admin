package com.ruoyi.project.business.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.cs.sp.serializer.MoneySerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户资产流水对象 a_asset_flow
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class MerchantAssetFlowReportDTO extends BaseEntity {

    @Excel(name="日期")
    private Integer day;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="商家收入")
    private BigDecimal pay;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="商家收入退款")
    private BigDecimal payRefund;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="USDT提现")
    private BigDecimal withdrawUsdt;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="USDT提现奖励")
    private BigDecimal withdrawPrizeUsdt;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="USDT提现退款")
    private BigDecimal withdrawRefundUsdt;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="CNY提现数量")
    private BigDecimal withdrawOfCny;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="CNY提现退款数量")
    private BigDecimal withdrawRefundOfCny;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="CNY提现")
    private BigDecimal withdrawCny;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="CNY提现奖励")
    private BigDecimal withdrawPrizeCny;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name="CNY提现退款")
    private BigDecimal withdrawRefundCny;

}
