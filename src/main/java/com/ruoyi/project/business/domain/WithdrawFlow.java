package com.ruoyi.project.business.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtMemEntity;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
/**
 * 提现流水对象 a_withdraw_flow
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class WithdrawFlow extends BaseExtMemEntity {

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 币种 */
    @Excel(name = "币种")
    private String symbol;

    /** 提现的链 */
    @Excel(name = "提现的链", dictType = "chain")
    private String chain;

    /** 到账代币 */
    @Excel(name = "到账代币")
    private String arriveSymbol;

    /** 到账合约地址 */
    private String arriveAddr;

    /** 提现数量 */
    @Excel(name = "提现数量")
    private BigDecimal quantity;

    /** 手续费 */
    @Excel(name = "手续费")
    private BigDecimal fee;

    /** 实际到账 */
    @Excel(name = "实际到账")
    private BigDecimal arriveQuantity;

    /** 审核状态 */
    @Excel(name = "审核状态", dictType = "common_yes_no")
    private Integer auditStatus;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long auditAt;

    /** 排队时间 */
//    private Long queueAt;

    /**
     * 清算日
     */
    @Schema(description = "清算日")
    private Long clearDay;

    /** 状态 */
    @Excel(name = "状态", dictType = "withdraw_flow_status")
    private Integer status;


    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** 创建日期 */
    private Long ymd;

    /** 数量 */
    private Long txNum;

    /** 领取的tx */
    @Excel(name = "领取的tx")
    private String claimTx;

    private String params;

    /** 领取时间 */
    @Excel(name = "领取时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long claimAt;

    /** 确认时间 */
    private Long confirmAt;

    /** 删除标记 */
    private Long deleted;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("symbol", getSymbol())
            .append("quantity", getQuantity())
            .append("chain", getChain())
            .append("arriveSymbol", getArriveSymbol())
            .append("arriveAddr", getArriveAddr())
            .append("arriveQuantity", getArriveQuantity())
            .append("auditStatus", getAuditStatus())
            .append("auditAt", getAuditAt())
            .append("status", getStatus())
            .append("fee", getFee())
            .append("createAt", getCreateAt())
            .append("ymd", getYmd())
            .append("txNum", getTxNum())
            .append("claimTx", getClaimTx())
            .append("claimAt", getClaimAt())
            .append("confirmAt", getConfirmAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
