package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
/**
 * 商家资产对象 p_merchant_asset
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class MerchantAsset extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 商家ID */
    @Excel(name = "商家ID")
    private Long mid;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 冻结 */
    @Excel(name = "冻结")
    private BigDecimal frozen;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("mid", getMid())
            .append("symbol", getSymbol())
            .append("balance", getBalance())
            .append("frozen", getFrozen())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
