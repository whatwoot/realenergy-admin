package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 当前排位对象 b_queue
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Data
public class Queue extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "排位", sort = 1)
    private Long id;

    /** UID */
    @Excel(name = "UID", sort = 2)
    private Long uid;

    /** 轮次 */
    @Excel(name = "当前轮次")
    private Long round;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 状态 */
    @Excel(name = "状态", dictType="queue_status")
    private Long status;

    /** 流水id */
    @Excel(name = "流水id")
    private Long flowId;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** 更新于 */
    @Excel(name = "更新于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long updateAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("uid", getUid())
            .append("round", getRound())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("flowId", getFlowId())
            .append("createAt", getCreateAt())
            .append("updateAt", getUpdateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
