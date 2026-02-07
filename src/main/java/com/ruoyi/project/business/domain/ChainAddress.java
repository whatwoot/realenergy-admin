package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 钱包列表对象 c_chain_address
 *
 * @author gpthk
 * @date 2025-01-11
 */
@Data
public class ChainAddress extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 链 */
    @Excel(name = "链")
    private String chain;

    /** 地址类型 */
    @Excel(name = "地址类型", dictType = "address_type")
    private Integer type;

    /** 钱包版本 */
    @Excel(name = "钱包版本")
    private String ver;

    /** 钱包id */
    @Excel(name = "钱包id")
    private Long walletId;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 原始地址 */
    @Excel(name = "原始地址")
    private String addr;

    /** 友好地址 */
    @Excel(name = "友好地址")
    private String showAddr;

    /** jetton地址 */
    private String usdtAddr;

    /** ton余额 */
    @Excel(name = "ton余额")
    private BigDecimal balance;

    /** usdt余额 */
    @Excel(name = "usdt余额")
    private BigDecimal usdtBalance;

    /** 是否需要刷新 */
    @Excel(name = "是否需要刷新")
    private Integer needRefresh;

    /** 加密key */
    private String privKey;

    /** 是否有效 */
    @Excel(name = "是否有效", dictType = "common_status")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 更新时间 */
    private Long updateAt;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("chain", getChain())
            .append("type", getType())
            .append("ver", getVer())
            .append("walletId", getWalletId())
            .append("symbol", getSymbol())
            .append("addr", getAddr())
            .append("showAddr", getShowAddr())
            .append("usdtAddr", getUsdtAddr())
            .append("tonBalance", getBalance())
            .append("usdtBalance", getUsdtBalance())
            .append("needRefresh", getNeedRefresh())
            .append("privKey", getPrivKey())
            .append("status", getStatus())
            .append("memo", getMemo())
            .append("updateAt", getUpdateAt())
            .append("weight", getWeight())
            .append("createTime", getCreateTime())
            .toString();
    }
}
