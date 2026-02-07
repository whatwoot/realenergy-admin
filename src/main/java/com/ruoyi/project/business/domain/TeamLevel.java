package com.ruoyi.project.business.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 社区级别对象 u_team_level
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Data
public class TeamLevel extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 流水 */
    @Excel(name = "流水")
    private BigDecimal fundFlowAmount;

    /** 团队流水 */
    @Excel(name = "团队流水")
    private BigDecimal teamFundFlowAmount;

    /** 同级邀请人数量 */
    @Excel(name = "同级邀请人数量")
    private Long levelInviterNum;

    /** 平级奖 */
    @Excel(name = "平级奖")
    private BigDecimal sameLevelRate;

    /** 平级奖来源 */
    @Excel(name = "平级奖来源", dictType="level_source")
    private Integer sameLevelSource;

    /** 平级奖数量限制 */
    @Excel(name = "平级奖数量限制")
    private Long sameLevelLimit;

    /** 等级奖 */
    @Excel(name = "等级奖")
    private BigDecimal levelRate;

    /** 级差制 */
    @Excel(name = "级差制", dictType="common_yes_no")
    private Integer differential;

    /** 状态 */
    @Excel(name = "状态", dictType = "common_status")
    private Integer status;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 小区业绩 */
    @Schema(description = "小区业绩")
    private BigDecimal smallerPerformance;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("fundFlowAmount", getFundFlowAmount())
            .append("teamFundFlowAmount", getTeamFundFlowAmount())
            .append("levelInviterNum", getLevelInviterNum())
            .append("sameLevelRate", getSameLevelRate())
            .append("sameLevelSource", getSameLevelSource())
            .append("sameLevelLimit", getSameLevelLimit())
            .append("levelRate", getLevelRate())
            .append("differential", getDifferential())
            .append("status", getStatus())
            .append("weight", getWeight())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
