package com.ruoyi.project.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author quzhimin
 * @date 2024/5/4 04:03
 */
@Data
public class ChangeEmailRequest implements Serializable {
    private String mainAccount;
    private Long id;
}
