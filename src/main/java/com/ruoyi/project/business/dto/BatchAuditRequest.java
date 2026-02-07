package com.ruoyi.project.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author quzhimin
 * @date 2024/5/4 04:03
 */
@Data
public class BatchAuditRequest implements Serializable {
    private static final long serialVersionUID = -7696024528186719079L;
    private List<Long> ids;
    private Long status;
    private String message;
}
