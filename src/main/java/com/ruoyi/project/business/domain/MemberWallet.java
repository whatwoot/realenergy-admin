package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 用户钱包对象 u_member_wallet
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Data
public class MemberWallet extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 链 */
    @Excel(name = "链")
    private String chain;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 钱包地址 */
    @Excel(name = "钱包地址")
    private String wallet;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("chain", getChain())
            .append("uid", getUid())
            .append("name", getName())
            .append("wallet", getWallet())
            .append("memo", getMemo())
            .append("seq", getSeq())
            .append("weight", getWeight())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
