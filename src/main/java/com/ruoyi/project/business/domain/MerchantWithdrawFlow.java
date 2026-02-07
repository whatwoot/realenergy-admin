package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 商家提现流水对象 p_merchant_withdraw_flow
 *
 * @author gpthk
 * @date 2025-03-27
 */
@Data
public class MerchantWithdrawFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id", sort = 1)
    private Long id;

    /** UID */
    @Excel(name = "UID", sort = 2)
    private Long uid;

    /** MID */
    @Excel(name = "MID", sort = 5)
    private Long mid;

    /** 币种 */
    @Excel(name = "币种")
    private String symbol;

    /** 提现数量 */
    @Excel(name = "提现数量")
    private BigDecimal quantity;

    /** 提现的链 */
    private String chain;

    /** 关联订单id */
    private Long relateId;

    /** 参数 */
    private String extInfo;

    @Excel(name = "应到数量")
    private BigDecimal receivableQuantity;

    /** 奖励数量 */
    @Excel(name = "奖励数量")
    private BigDecimal prizeQuantity;

    /** 实际到账 */
    @Excel(name = "实际到账")
    private BigDecimal arriveQuantity;


    /** 汇率 */
    @Excel(name = "汇率")
    private BigDecimal exchangeRate;

    /** 到账方式 */
    @Excel(name = "到账方式",readConverterExp="1=微信,2=支付宝,3=BSC,4=聚合码")
    private Integer arriveType;

    /** 到账代币 */
    @Excel(name = "到账代币")
    private String arriveSymbol;

    /** 到账地址 */
    @Excel(name = "到账地址")
    private String arriveAddr;


    /** 备注 */
    private String arriveMemo;

    /** 审核状态 */
    @Excel(name = "审核状态",readConverterExp="1=是,0=否")
    private Long auditStatus;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long auditAt;

    /** 自动提现 */
    @Excel(name = "自动提现",readConverterExp="1=是,0=否")
    private Long autoWithdraw;

    @Excel(name = "付款人id")
    private Long payUid;

    @Excel(name = "支付渠道")
    private String payChannel;

    /** 状态
     *     NOOP((byte)0, "待处理"),
     *     DONE((byte)1, "已完成"),
     *     TRANSFER((byte)2, "转账中"),
     *     CONFIRMING((byte)3, "待确认"),
     *     CHECK((byte)4, "异常"),
     *     REFUND((byte)5, "已退款")
     * */
    @Excel(name = "状态",readConverterExp="0=待处理,1=已完成,2=转账中,3=待确认,4=异常,5=已退款")
    private Long status;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal fee;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** 队列时间 */
    private Long queueAt;

    /** 创建日期 */
    @Excel(name = "创建日期")
    private Long ymd;

    /** 拆分的事务数量 */
    private Long txNum;

    /** 领取的tx */
    @Excel(name = "流水/tx")
    private String claimTx;

    /** 领取时间 */
    @Excel(name = "发起时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long claimAt;

    /** 确认领取时间 */
    @Excel(name = "确认时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long confirmAt;

    /** 失败次数 */
    @Excel(name = "失败次数")
    private Long failNum;

    /** 上次失败原因 */
    @Excel(name = "上次失败原因")
    private String failMsg;

    /** 删除标记 */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("mid", getMid())
            .append("symbol", getSymbol())
            .append("quantity", getQuantity())
            .append("chain", getChain())
            .append("prizeQuantity", getPrizeQuantity())
            .append("relateId", getRelateId())
            .append("extInfo", getExtInfo())
            .append("arriveType", getArriveType())
            .append("arriveSymbol", getArriveSymbol())
            .append("arriveAddr", getArriveAddr())
            .append("arriveQuantity", getArriveQuantity())
            .append("arriveMemo", getArriveMemo())
            .append("exchangeRate", getExchangeRate())
            .append("auditStatus", getAuditStatus())
            .append("auditAt", getAuditAt())
            .append("autoWithdraw", getAutoWithdraw())
            .append("status", getStatus())
            .append("fee", getFee())
            .append("createAt", getCreateAt())
            .append("queueAt", getQueueAt())
            .append("ymd", getYmd())
            .append("txNum", getTxNum())
            .append("claimTx", getClaimTx())
            .append("claimAt", getClaimAt())
            .append("confirmAt", getConfirmAt())
            .append("failNum", getFailNum())
            .append("failMsg", getFailMsg())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
