package com.ruoyi.framework.web.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

/**
 * @author quzhimin
 * @date 2024/4/16 20:18
 */
@Data
public class BaseMemEntity extends BaseEntity {
    private static final long serialVersionUID = -2669026156723387267L;
    /**
     * 钱包地址
     */
    @Excel(name = "邮箱", sort = 3)
    private String account;
    /**
     * 父级
     */
    @Excel(name = "父UID", sort = 4)
    private Long pid;

    /**
     * 关联方式，1=下级，0=上级
     */
    private Integer relate;
}
