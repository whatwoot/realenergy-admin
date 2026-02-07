package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 价格历史D对象 c_dec_price_his
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Data
public class DecPriceHis extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String symbol;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String poolAddr;

    /** token0数量 */
    @Excel(name = "token0数量")
    private BigDecimal reserve0;

    /** token1数量 */
    @Excel(name = "token1数量")
    private BigDecimal reserve1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decimals0;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decimals1;

    /** 价格时间 */
    @Excel(name = "价格时间")
    private Long priceTime;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 价格方向 */
    @Excel(name = "价格方向")
    private Long priceDirection;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long blockNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long updateAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("symbol", getSymbol())
            .append("poolAddr", getPoolAddr())
            .append("reserve0", getReserve0())
            .append("reserve1", getReserve1())
            .append("decimals0", getDecimals0())
            .append("decimals1", getDecimals1())
            .append("priceTime", getPriceTime())
            .append("price", getPrice())
            .append("priceDirection", getPriceDirection())
            .append("blockNo", getBlockNo())
            .append("status", getStatus())
            .append("updateAt", getUpdateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
