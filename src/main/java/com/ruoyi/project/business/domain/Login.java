package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 登录账户对象 u_login
 *
 * @author gpthk
 * @date 2025-03-15
 */
@Data
public class Login extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 类型 */
    @Excel(name = "类型")
    private Byte type;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 密钥 */
    @Excel(name = "密钥")
    private String secret;

    /** 启用 */
    @Excel(name = "启用")
    private Long status;

    /** 盐值 */
    @Excel(name = "盐值")
    private String salt;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 绑定时间 */
    @Excel(name = "绑定时间")
    private Long bindAt;

    /** 显示 */
    @Excel(name = "显示")
    private Long showed;

    /** 删除 */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("type", getType())
            .append("account", getAccount())
            .append("secret", getSecret())
            .append("status", getStatus())
            .append("salt", getSalt())
            .append("memo", getMemo())
            .append("bindAt", getBindAt())
            .append("showed", getShowed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
