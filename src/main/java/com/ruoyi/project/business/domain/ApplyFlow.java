package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 申请审核对象 s_apply_flow
 *
 * @author gpthk
 * @date 2025-11-06
 */
@Data
public class ApplyFlow extends BaseExtMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 业务 */
    @Excel(name = "业务")
    private String scene;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 参数 */
    @Excel(name = "参数")
    private String params;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long auditAt;

    /** 审核消息 */
    @Excel(name = "审核消息")
    private String auditMsg;

    /** 提交时间 */
    @Excel(name = "提交时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("scene", getScene())
            .append("status", getStatus())
            .append("params", getParams())
            .append("auditAt", getAuditAt())
            .append("auditMsg", getAuditMsg())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
