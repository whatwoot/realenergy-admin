package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
/**
 * 业绩报表对象 b_user_report_daily
 *
 * @author gpthk
 * @date 2025-05-04
 */
@Data
public class UserReportDaily extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 日期 */
    @Excel(name = "日期")
    private Integer day;

    /** 个人业绩 */
    @Excel(name = "个人业绩")
    private BigDecimal performance;

    /** 团队业绩 */
    @Excel(name = "团队业绩")
    private BigDecimal teamPerformance;

    /** 大区业绩 */
    @Excel(name = "大区业绩")
    private BigDecimal bigTeamPerformance;

    /** 小区业绩 */
    @Excel(name = "小区业绩")
    private BigDecimal smallTeamPerformance;

    /** 新增个人业绩 */
    @Excel(name = "新增个人业绩")
    private BigDecimal gainPerformance;

    /** 新增团队业绩 */
    @Excel(name = "新增团队业绩")
    private BigDecimal gainTeamPerformance;

    /** 期初小区业绩 */
    @Excel(name = "期初小区业绩")
    private BigDecimal beginSmallTeamPerformance;

    /** 新增小区业绩 */
    @Excel(name = "新增小区业绩")
    private BigDecimal gainSmallTeamPerformance;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("day", getDay())
            .append("performance", getPerformance())
            .append("teamPerformance", getTeamPerformance())
            .append("bigTeamPerformance", getBigTeamPerformance())
            .append("smallTeamPerformance", getSmallTeamPerformance())
            .append("gainPerformance", getGainPerformance())
            .append("gainTeamPerformance", getGainTeamPerformance())
            .append("beginSmallTeamPerformance", getBeginSmallTeamPerformance())
            .append("gainSmallTeamPerformance", getGainSmallTeamPerformance())
            .append("createTime", getCreateTime())
            .toString();
    }
}
