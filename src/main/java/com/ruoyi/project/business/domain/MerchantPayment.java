package com.ruoyi.project.business.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 商家收款方式对象 p_merchant_payment
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class MerchantPayment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 钱包地址
     */
    @Excel(name = "邮箱", sort = 3)
    private String email;
    /**
     * 父级
     */
    @Excel(name = "父UID", sort = 4)
    private Long pid;

    /**
     * 关联方式，1=下级，0=上级
     */
    private Integer relate;

    /** id */
    private Long id;

    /** 商户ID */
    @Excel(name = "商户ID")
    private Long mid;

    /** UID */
    @Excel(name = "UID", sort = 2)
    private Long uid;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 货币 */
    @Excel(name = "货币")
    private String currency;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 二维码地址 */
    @Excel(name = "二维码地址")
    private String codeUrl;

    /** 二维码内容 */
    @Excel(name = "二维码内容")
    private String code;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createAt;

    /** 默认 */
    @Excel(name = "默认")
    private Long weight;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mid", getMid())
            .append("uid", getUid())
            .append("type", getType())
            .append("account", getAccount())
            .append("name", getName())
            .append("currency", getCurrency())
            .append("memo", getMemo())
            .append("codeUrl", getCodeUrl())
            .append("code", getCode())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("weight", getWeight())
            .append("deleted", getDeleted())
            .toString();
    }
}
