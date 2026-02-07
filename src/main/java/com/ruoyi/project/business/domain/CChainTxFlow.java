package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 扫块记录对象 c_chain_tx_flow
 *
 * @author gpthk
 * @date 2024-11-01
 */
@Data
public class CChainTxFlow extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 扫块任务id */
    @Excel(name = "扫块任务id")
    private Long scanId;

    /** 区块号 */
    @Excel(name = "区块号")
    private Long blockNo;

    /** 区块时间 */
    @Excel(name = "区块时间")
    private Long blockTime;

    /** 区块hash */
    @Excel(name = "区块hash")
    private String blockHash;

    /** 事务hash */
    @Excel(name = "事务hash")
    private String hash;

    /** 序列号 */
    @Excel(name = "序列号")
    private Long nonce;

    /** 发送地址 */
    @Excel(name = "发送地址")
    private String fromAddr;

    /** 接收地址 */
    @Excel(name = "接收地址")
    private String toAddr;

    /** 智能合约地址 */
    @Excel(name = "智能合约地址")
    private String contract;

    /** 转账数量 */
    @Excel(name = "转账数量")
    private BigDecimal value;

    /** 区块信息 */
    @Excel(name = "区块信息")
    private String input;

    /** 记账状态，1=是，0=否 */
    @Excel(name = "记账状态，1=是，0=否")
    private Integer receiptStatus;

    /** 方法id */
    @Excel(name = "方法id")
    private String methodId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 错误次数 */
    @Excel(name = "错误次数")
    private Long errorNum;

    /** 业务处理失败信息 */
    @Excel(name = "业务处理失败信息")
    private String errorMsg;

    /** 延迟确认时间 */
    @Excel(name = "延迟确认时间")
    private Long confirmAt;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("scanId", getScanId())
            .append("blockNo", getBlockNo())
            .append("blockTime", getBlockTime())
            .append("blockHash", getBlockHash())
            .append("hash", getHash())
            .append("nonce", getNonce())
            .append("fromAddr", getFromAddr())
            .append("toAddr", getToAddr())
            .append("contract", getContract())
            .append("value", getValue())
            .append("input", getInput())
            .append("receiptStatus", getReceiptStatus())
            .append("methodId", getMethodId())
            .append("status", getStatus())
            .append("errorNum", getErrorNum())
            .append("errorMsg", getErrorMsg())
            .append("confirmAt", getConfirmAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
