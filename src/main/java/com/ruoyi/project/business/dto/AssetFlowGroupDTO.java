package com.ruoyi.project.business.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
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
public class AssetFlowGroupDTO extends BaseEntity {

    /**
     *     PAY("02", "0201", "扫码消费"),
     *     INCOME("02", "0202", "商家收入"),
     *     REWARD("02", "0203","商家奖励"),
     *     INVEST("03", "0301","理财"),
     *     STATIC("04", "0401", "理财收益"),
     *     DYNAMIC("04", "0402", "邀请收益"),
     *     PUBLIC_RANK("05", "0503", "公排奖励"),
     *
     *     EXCHANGE("06", "0601", "闪兑"),
     */
    @Excel(name = "日期")
    private Integer ymd;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "系统充")
    private BigDecimal sysRecharge;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "系统扣")
    private BigDecimal sysReduce;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "提现")
    private BigDecimal withdraw;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "提现退款")
    private BigDecimal withdrawRefund;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "充值")
    private BigDecimal recharge;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "消费")
    private BigDecimal pay;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "消费退款")
    private BigDecimal payRefund;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "理财")
    private BigDecimal invest;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "静态")
    private BigDecimal statics;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "邀请")
    private BigDecimal teamInvite;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "公排")
    private BigDecimal publicRank;
    @JsonSerialize(using = MoneySerializer.class)
    @Excel(name = "闪兑")
    private BigDecimal exchange;

}
