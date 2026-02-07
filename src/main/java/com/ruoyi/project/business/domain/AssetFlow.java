package com.ruoyi.project.business.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
/**
 * 用户资产流水对象 a_asset_flow
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class AssetFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 场景 */
    @Excel(name = "场景", dictType = "asset_flow_scene")
    private String scene;

    @Excel(name = "账户", readConverterExp = "0=默认,1=溢出")
    private Integer type;

    /** 代币 */
    @Excel(name = "代币")
    private String symbol;

    /** 账期 */
    @Excel(name = "账期")
    private Long ymd;

    /** 余额变动 */
    @Excel(name = "余额变动")
    private BigDecimal balance;

    /** 冻结变动 */
    @Excel(name = "冻结变动")
    private BigDecimal frozen;

    @Excel(name = "退款", dictType = "common_yes_no")
    private Byte refunded;

    @Excel(name = "退款时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long refundAt;

    @Excel(name = "对公户", dictType = "common_yes_no")
    private Byte publiced;

    /** 关联id */
    @Excel(name = "关联id")
    private Long relateId;

    /** 关联备注 */
    private String relateMemo;

    /** 清算日 */
    private Long clearDay;

    /** 变动前余额 */
    @Excel(name = "变动前余额")
    private BigDecimal beginBalance;

    /** 变动前冻结 */
    @Excel(name = "变动前冻结")
    private BigDecimal beginFrozen;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    @Schema(description = "")
    private BigDecimal locked;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("scene", getScene())
            .append("symbol", getSymbol())
            .append("day", getYmd())
            .append("balance", getBalance())
            .append("frozen", getFrozen())
            .append("relateId", getRelateId())
            .append("relateMemo", getRelateMemo())
            .append("clearDay", getClearDay())
            .append("beginBalance", getBeginBalance())
            .append("beginFrozen", getBeginFrozen())
            .append("memo", getMemo())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
