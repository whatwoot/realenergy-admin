package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 用户贡献明细对象 b_prize_flow
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Data
public class PrizeFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 场景 */
    @Excel(name = "场景")
    private String scene;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal balance;

    /** 变动前 */
    @Excel(name = "变动前")
    private BigDecimal balanceBegin;

    /** 账期 */
    @Excel(name = "账期")
    private Long day;

    /** 时间 */
    @Excel(name = "时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("scene", getScene())
            .append("balance", getBalance())
            .append("balanceBegin", getBalanceBegin())
            .append("day", getDay())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
