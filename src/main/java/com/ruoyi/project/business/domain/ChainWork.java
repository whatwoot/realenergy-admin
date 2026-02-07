package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 转账任务对象 c_chain_work
 *
 * @author gpthk
 * @date 2025-03-22
 */
@Data
public class ChainWork extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private Byte type;

    /** 链 */
    @Excel(name = "链")
    private String chain;

    /** 发起地址 */
    @Excel(name = "发起地址")
    private String fromAddr;

    /** 接收地址 */
    @Excel(name = "接收地址")
    private String toAddr;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 合约 */
    @Excel(name = "合约")
    private String contract;

    /** 参数 */
    @Excel(name = "参数")
    private String param;

    /** gas费 */
    @Excel(name = "gas费")
    private BigDecimal gasFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal gasPrice;

    /** 状态 */
    @Excel(name = "状态")
    private Byte status;

    /** 事务状态 */
    @Excel(name = "事务状态")
    private Byte txStatus;

    /** 区块号 */
    @Excel(name = "区块号")
    private Long blockNo;

    /** 事务hash */
    @Excel(name = "事务hash")
    private String hash;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long blockTime;

    /** 排队时间 */
    @Excel(name = "排队时间")
    private Long queueAt;

    /** 确认于 */
    @Excel(name = "确认于")
    private Long confirmAt;

    /** 确认区块  */
    @Excel(name = "确认区块 ")
    private Long confirmBlockNo;

    /** 事务状态 */
    @Excel(name = "事务状态")
    private Byte receiptStatus;

    /** 事务错误原因 */
    @Excel(name = "事务错误原因")
    private String errMsg;

    /** 业务处理状态 */
    @Excel(name = "业务处理状态")
    private Byte processed;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long processAt;

    /** 业务处理备注 */
    @Excel(name = "业务处理备注")
    private String processMsg;

    /** 归集状态 */
    @Excel(name = "归集状态")
    private Byte collected;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long collectAt;

    /** 归集消息 */
    @Excel(name = "归集消息")
    private String collectMsg;

    /** 关联业务id */
    @Excel(name = "关联业务id")
    private Long relateId;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("chain", getChain())
            .append("fromAddr", getFromAddr())
            .append("toAddr", getToAddr())
            .append("symbol", getSymbol())
            .append("amount", getAmount())
            .append("contract", getContract())
            .append("param", getParam())
            .append("gasFee", getGasFee())
            .append("gasPrice", getGasPrice())
            .append("status", getStatus())
            .append("txStatus", getTxStatus())
            .append("blockNo", getBlockNo())
            .append("hash", getHash())
            .append("createAt", getCreateAt())
            .append("blockTime", getBlockTime())
            .append("queueAt", getQueueAt())
            .append("confirmAt", getConfirmAt())
            .append("confirmBlockNo", getConfirmBlockNo())
            .append("receiptStatus", getReceiptStatus())
            .append("errMsg", getErrMsg())
            .append("processed", getProcessed())
            .append("processAt", getProcessAt())
            .append("processMsg", getProcessMsg())
            .append("collected", getCollected())
            .append("collectAt", getCollectAt())
            .append("collectMsg", getCollectMsg())
            .append("relateId", getRelateId())
            .append("memo", getMemo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
