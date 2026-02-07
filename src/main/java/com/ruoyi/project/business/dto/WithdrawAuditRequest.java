package com.ruoyi.project.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @authro fun
 * @date 2025/6/7 15:28
 */
@Data
public class WithdrawAuditRequest implements Serializable {
    private Long id;
    private Integer status;
    private String message;
}
