package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * JackPot抽奖对象 t_jackpot_winner
 *
 * @author gpthk
 * @date 2025-12-31
 */
@Data
public class JackpotWinner extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wallet;

    /** 操盘手UID */
    @Excel(name = "操盘手UID")
    private Long traderId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long copyerId;

    /** 奖金 */
    @Excel(name = "奖金")
    private BigDecimal bonus;

    /** 校验哈希 */
    @Excel(name = "校验哈希")
    private String checkHash;

    /** 校验哈希 */
    @Excel(name = "校验哈希")
    private String memo;

    /** 平仓时间 */
    @Excel(name = "平仓时间")
    private Long closeAt;

    /** 释放时间 */
    @Excel(name = "释放时间")
    private Long releaseAt;

    /** 释放周期 */
    @Excel(name = "释放周期")
    private Long releasePeriod;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("wallet", getWallet())
            .append("traderId", getTraderId())
            .append("copyerId", getCopyerId())
            .append("bonus", getBonus())
            .append("checkHash", getCheckHash())
            .append("memo", getMemo())
            .append("closeAt", getCloseAt())
            .append("releaseAt", getReleaseAt())
            .append("releasePeriod", getReleasePeriod())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createAt", getCreateAt())
            .toString();
    }
}
