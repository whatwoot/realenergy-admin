package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 系统配置对象 s_config
 *
 * @author gpthk
 * @date 2024-04-21
 */
@Data
public class Config extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 配置分类 */
    @Excel(name = "配置分类")
    private String category;

    /** 配置key */
    @Excel(name = "配置key")
    private String configKey;

    /** 配置名称 */
    @Excel(name = "配置名称")
    private String configName;

    /** 配置值 */
    @Excel(name = "配置值")
    private String configValue;

    /** 配置规则 */
    @Excel(name = "配置规则")
    private String rule;

    /** 描述 */
    @Excel(name = "描述")
    private String memo;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 是否删除 */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("category", getCategory())
            .append("configKey", getConfigKey())
            .append("configName", getConfigName())
            .append("configValue", getConfigValue())
            .append("rule", getRule())
            .append("memo", getMemo())
            .append("status", getStatus())
            .append("weight", getWeight())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
