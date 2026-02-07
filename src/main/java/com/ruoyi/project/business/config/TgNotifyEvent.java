package com.ruoyi.project.business.config;

import com.ruoyi.project.business.dto.TgNotifyDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @authro fun
 * @date 2025/4/25 22:35
 */
@Getter
public class TgNotifyEvent extends ApplicationEvent {
    private TgNotifyDTO notify;

    public TgNotifyEvent(Object source, TgNotifyDTO notify) {
        super(source);
        this.notify = notify;
    }
}
