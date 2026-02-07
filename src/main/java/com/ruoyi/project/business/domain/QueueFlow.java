package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 排位出局明细对象 b_queue_flow
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Data
public class QueueFlow extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 排位 */
    @Excel(name = "排位")
    private Long queueId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 轮次 */
    @Excel(name = "轮次")
    private Long round;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal rewardAmount;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("queueId", getQueueId())
            .append("uid", getUid())
            .append("round", getRound())
            .append("rewardAmount", getRewardAmount())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
