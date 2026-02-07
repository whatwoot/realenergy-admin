package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 销售排行榜对象 b_invite_rank
 *
 * @author gpthk
 * @date 2025-11-06
 */
@Data
public class InviteRank extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 日期 */
    @Excel(name = "日期")
    private Integer ymd;

    /** 邀请人数 */
    @Excel(name = "邀请人数")
    private Integer inviteNum;

    /** 业绩 */
    @Excel(name = "业绩")
    private BigDecimal performance;

    /** 最后理财时间 */
    @Excel(name = "最后理财时间")
    private Long lastInvestAt;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("nickname", getNickname())
            .append("ymd", getYmd())
            .append("inviteNum", getInviteNum())
            .append("performance", getPerformance())
            .append("lastInvestAt", getLastInvestAt())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
