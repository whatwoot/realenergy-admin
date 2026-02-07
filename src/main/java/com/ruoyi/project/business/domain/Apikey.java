package com.ruoyi.project.business.domain;

import java.math.BigDecimal;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseExtEntity;

/**
 * 平台API对象 t_apikey
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Data
public class Apikey extends BaseExtEntity{

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 0=带单,1=跟单 */
    @Excel(name = "0=带单,1=跟单")
    private Long type;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

    /** 错误 */
    @Excel(name = "错误")
    private String errCode;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String errMsg;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** uid */
    @Excel(name = "uid")
    private Long uid;

    /** 平台 */
    @Excel(name = "平台")
    private String platform;

    /** apikey归属id */
    @Excel(name = "apikey归属id")
    private String keyUid;

    /** apikey */
    @Excel(name = "apikey")
    private String apikey;

    /** 密钥 */
    @Excel(name = "密钥")
    private String secret;

    /** 密码 */
    @Excel(name = "密码")
    private String passphrase;

    /** 权限 */
    @Excel(name = "权限")
    private String perm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String memo;

    /** 账户余额 */
    @Excel(name = "账户余额")
    private BigDecimal usdtBalance;

    /** 账户usdt更新于 */
    @Excel(name = "账户usdt更新于")
    private Long balanceUpdateAt;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createAt;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("seq", getSeq())
            .append("errCode", getErrCode())
            .append("errMsg", getErrMsg())
            .append("status", getStatus())
            .append("weight", getWeight())
            .append("uid", getUid())
            .append("platform", getPlatform())
            .append("keyUid", getKeyUid())
            .append("apikey", getApikey())
            .append("secret", getSecret())
            .append("passphrase", getPassphrase())
            .append("perm", getPerm())
            .append("memo", getMemo())
            .append("usdtBalance", getUsdtBalance())
            .append("balanceUpdateAt", getBalanceUpdateAt())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
