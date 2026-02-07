package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 爆破池对象 b_level_pool
 *
 * @author gpthk
 * @date 2025-11-07
 */
@Data
public class LevelPool extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 奖励 */
    @Excel(name = "奖励")
    private BigDecimal rate;

    /** 奖池 */
    @Excel(name = "奖池")
    private BigDecimal amount;

    /** 是否首爆 */
    @Excel(name = "是否首爆")
    private Integer prized;

    /** 上次派奖 */
    @Excel(name = "上次派奖")
    private Integer lastBonusDay;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("rate", getRate())
            .append("amount", getAmount())
            .append("prized", getPrized())
            .append("lastBonusDay", getLastBonusDay())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
