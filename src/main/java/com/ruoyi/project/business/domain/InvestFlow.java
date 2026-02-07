package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 理财记录对象 b_invest_flow
 *
 * @author gpthk
 * @date 2025-11-05
 */
@Data
public class InvestFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 数量 */
    @Excel(name = "数量")
    private Integer num;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal investAmount;

    /** 理财金额 */
    @Excel(name = "理财金额")
    private BigDecimal bonusAmount;

    /** NFT金额 */
    @Excel(name = "NFT金额")
    private BigDecimal nftAmount;

    /** 铸币金额 */
    @Excel(name = "铸币金额")
    private BigDecimal tokenAmount;

    /** 回报金额 */
    @Excel(name = "回报金额")
    private BigDecimal returnAmount;

    /** 回报剩余 */
    @Excel(name = "回报剩余")
    private BigDecimal leftAmount;

    /** 分红比例 */
    @Excel(name = "分红比例")
    private BigDecimal bonusRate;

    /** 已派奖 */
    @Excel(name = "已派奖")
    private Integer prized;

    /** 状态 */
    @Excel(name = "状态", dictType="invest_flow_status")
    private Long status;

    /** 最近分红日 */
    @Excel(name = "最近分红日")
    private Integer lastBonusDay;

    /** NFT下次分红日 */
    @Excel(name = "NFT下次分红日")
    private Integer nextNftBonusDay;

    /** 开奖周期 */
    @Excel(name = "开奖周期")
    private Integer period;

    /** 年月日 */
    @Excel(name = "年月日")
    private Integer ymd;

    /** 投资时间 */
    @Excel(name = "投资时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long investAt;

    /** 出售 */
    @Excel(name = "出售", dictType="invest_flow_sold")
    private Integer sold;

    /** 申请id */
    @Excel(name = "申请id")
    private Long applyId;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long auditAt;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long endAt;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 可卖 */
    @Excel(name = "可卖", readConverterExp = "0=否,1=是")
    private Integer canSell;

    /** 是否删除 */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("amount", getAmount())
            .append("num", getNum())
            .append("investAmount", getInvestAmount())
            .append("bonusAmount", getBonusAmount())
            .append("nftAmount", getNftAmount())
            .append("tokenAmount", getTokenAmount())
            .append("returnAmount", getReturnAmount())
            .append("leftAmount", getLeftAmount())
            .append("bonusRate", getBonusRate())
            .append("prized", getPrized())
            .append("status", getStatus())
            .append("lastBonusDay", getLastBonusDay())
            .append("nextNftBonusDay", getNextNftBonusDay())
            .append("period", getPeriod())
            .append("ymd", getYmd())
            .append("investAt", getInvestAt())
            .append("sold", getSold())
            .append("applyId", getApplyId())
            .append("auditAt", getAuditAt())
            .append("endAt", getEndAt())
            .append("source", getSource())
            .append("canSell", getCanSell())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
