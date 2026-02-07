package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 邀请级别对象 u_invite_level
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class InviteLevel extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 层级名 */
    @Excel(name = "层级名")
    private String name;

    /** 邀请用户 */
    @Excel(name = "邀请用户")
    private Long inviteNum;

    /** 奖励比率 */
    @Excel(name = "奖励比率")
    private BigDecimal prizeRate;

    /** 奖励层级 */
    @Excel(name = "奖励层级")
    private Long level;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("inviteNum", getInviteNum())
            .append("prizeRate", getPrizeRate())
            .append("level", getLevel())
            .append("status", getStatus())
            .append("weight", getWeight())
            .toString();
    }
}
