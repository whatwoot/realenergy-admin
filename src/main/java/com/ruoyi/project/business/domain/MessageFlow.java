package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 消息流水对象 o_message_flow
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Data
public class MessageFlow extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 业务编码 */
    @Excel(name = "业务编码")
    private String serviceName;

    /** uid */
    @Excel(name = "uid")
    private Long uid;

    /** 发送者 */
    @Excel(name = "发送者")
    private String sender;

    /** 接收者 */
    @Excel(name = "接收者")
    private String receiver;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 随机码 */
    @Excel(name = "随机码")
    private String code;

    /** 携带信息 */
    @Excel(name = "携带信息")
    private String param;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 响应 */
    @Excel(name = "响应")
    private String resp;

    /** 创建于 */
    @Excel(name = "创建于")
    private Long createAt;

    /** 队列时间 */
    @Excel(name = "队列时间")
    private Long queueAt;

    /** 服务商 */
    @Excel(name = "服务商")
    private Long errProvider;

    /** 错误次数 */
    @Excel(name = "错误次数")
    private Long errNum;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String errMsg;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("serviceName", getServiceName())
            .append("uid", getUid())
            .append("sender", getSender())
            .append("receiver", getReceiver())
            .append("nickname", getNickname())
            .append("title", getTitle())
            .append("content", getContent())
            .append("code", getCode())
            .append("param", getParam())
            .append("status", getStatus())
            .append("resp", getResp())
            .append("createAt", getCreateAt())
            .append("queueAt", getQueueAt())
            .append("errProvider", getErrProvider())
            .append("errNum", getErrNum())
            .append("errMsg", getErrMsg())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
