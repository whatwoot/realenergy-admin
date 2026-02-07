package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 用户提现明细对象 a_withdraw_detail
 *
 * @author gpthk
 * @date 2025-01-08
 */
@Data
public class WithdrawDetail extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 流水id */
    @Excel(name = "流水id")
    private Long flowId;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 使用的地址id */
    private Long addressId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 发送者 */
    @Excel(name = "发送者")
    private String fromAddr;

    /** 接收者 */
    @Excel(name = "接收者")
    private String toAddr;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 事务hash */
    @Excel(name = "事务hash")
    private String hash;

    /** 发送时间 */
    @Excel(name = "发送时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long sendAt;

    /** 确认时间 */
    @Excel(name = "确认时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long confirmAt;

    /** 确认区块号 */
    @Excel(name = "确认区块号")
    private Long confirmBlockNo;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("flowId", getFlowId())
            .append("uid", getUid())
            .append("addressId", getAddressId())
            .append("amount", getAmount())
            .append("fromAddr", getFromAddr())
            .append("toAddr", getToAddr())
            .append("status", getStatus())
            .append("hash", getHash())
            .append("sendAt", getSendAt())
            .append("confirmAt", getConfirmAt())
            .append("confirmBlockNo", getConfirmBlockNo())
            .append("memo", getMemo())
            .append("seq", getSeq())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
