package com.ruoyi.project.business.dto;

import com.cs.sp.common.base.BaseDTO;
import lombok.Data;

/**
 * @authro fun
 * @date 2025/4/7 19:29
 */
@Data
public class TgNotifyDTO extends BaseDTO {
    private Boolean test;
    // 场景
    private String scene;
    // 消息类型：订阅该类型的群会被通知
    private String oriented;
    // 人
    private String member;
    // 事
    private String things;
    // 风险
    private String risk;
    // 流水id
    private String tx;
    // 时间
    private Long createAt;
}
