package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 跟单订单对象 t_trade_order
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Data
public class TradeOrder extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** open=开仓,close=平仓 */
    @Excel(name = "open=开仓,close=平仓")
    private String op;

    /** 带单师 */
    @Excel(name = "带单师")
    private Long tid;

    /** uid */
    @Excel(name = "uid")
    private Long uid;

    /** 三方订单id */
    @Excel(name = "三方订单id")
    private String ordId;

    /** 产品 */
    @Excel(name = "产品")
    private String instId;

    /** 保证金模式 */
    @Excel(name = "保证金模式")
    private String mgnMode;

    /** 订单信息已完善 */
    @Excel(name = "订单信息已完善")
    private Long filled;

    /** 购买方向 */
    @Excel(name = "购买方向")
    private String side;

    /** 仓位方向 */
    @Excel(name = "仓位方向")
    private String posSide;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal expectQuantity;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal quantity;

    /** 杠杆倍数 */
    @Excel(name = "杠杆倍数")
    private BigDecimal lever;

    /** 实际收入 */
    @Excel(name = "实际收入")
    private BigDecimal actualProfit;

    /** 交易手续费 */
    @Excel(name = "交易手续费")
    private BigDecimal fee;

    /** 手续费代币 */
    @Excel(name = "手续费代币")
    private String feeCcy;

    /** 跟单手续费 */
    @Excel(name = "跟单手续费")
    private BigDecimal copyFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderType;

    /** 代币实时价格 */
    @Excel(name = "代币实时价格")
    private BigDecimal price;

    /** 使用保证金 */
    @Excel(name = "使用保证金")
    private BigDecimal usedMargin;

    /** 信号id */
    @Excel(name = "信号id")
    private String signalId;

    /** 内部订单 */
    @Excel(name = "内部订单")
    private Long internal;

    /** 外部仓位id */
    @Excel(name = "外部仓位id")
    private String posId;

    /** 结算仓位记录id */
    @Excel(name = "结算仓位记录id")
    private Long posFlowId;

    /** 标签 */
    @Excel(name = "标签")
    private String tag;

    /** 下单接口失败响应 */
    @Excel(name = "下单接口失败响应")
    private String apiMsg;

    /** 订单完整信息 */
    @Excel(name = "订单完整信息")
    private String orderDetail;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String errCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String errMsg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long updateAt;

    /** 平仓单是否已触发结算 */
    @Excel(name = "平仓单是否已触发结算")
    private Long settled;

    /** 结算处理时间 */
    @Excel(name = "结算处理时间")
    private Long settleQueueAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("op", getOp())
            .append("tid", getTid())
            .append("uid", getUid())
            .append("ordId", getOrdId())
            .append("instId", getInstId())
            .append("mgnMode", getMgnMode())
            .append("filled", getFilled())
            .append("side", getSide())
            .append("posSide", getPosSide())
            .append("expectQuantity", getExpectQuantity())
            .append("quantity", getQuantity())
            .append("lever", getLever())
            .append("actualProfit", getActualProfit())
            .append("fee", getFee())
            .append("feeCcy", getFeeCcy())
            .append("copyFee", getCopyFee())
            .append("orderType", getOrderType())
            .append("price", getPrice())
            .append("usedMargin", getUsedMargin())
            .append("signalId", getSignalId())
            .append("internal", getInternal())
            .append("posId", getPosId())
            .append("posFlowId", getPosFlowId())
            .append("tag", getTag())
            .append("apiMsg", getApiMsg())
            .append("orderDetail", getOrderDetail())
            .append("errCode", getErrCode())
            .append("errMsg", getErrMsg())
            .append("createAt", getCreateAt())
            .append("updateAt", getUpdateAt())
            .append("settled", getSettled())
            .append("settleQueueAt", getSettleQueueAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
