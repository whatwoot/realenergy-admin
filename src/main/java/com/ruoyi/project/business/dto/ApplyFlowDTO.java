package com.ruoyi.project.business.dto;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *
 * @author feiwo
 */
@Data
public class ApplyFlowDTO {

    private Long id;

    @Schema(description = "审核状态")
    @NotNull(message = "审核状态不能为空")
    private Integer status;

    /** 审核消息 */
    @Excel(name = "审核消息")
    private String auditMsg;

}
