package com.ruoyi.project.business.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
/**
 * 用户资产对象 a_asset
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class Asset extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;


    /** 币种 */
    @Excel(name = "币种")
    private String symbol;

    /** 锁定 */
    private BigDecimal locked;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 冻结 */
    @Excel(name = "冻结")
    private BigDecimal frozen;

    /** 余额宝快照日 */
    @Schema(description = "余额宝快照日")
    private Integer fundYmd;

    /** 余额宝快照余额 */
    @Schema(description = "余额宝快照余额")
    private BigDecimal fundBalance;

    /** 类型 */
    @Schema(description = "类型")
    private Integer type;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("symbol", getSymbol())
            .append("locked", getLocked())
            .append("balance", getBalance())
            .append("frozen", getFrozen())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
