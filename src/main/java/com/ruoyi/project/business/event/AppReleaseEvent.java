package com.ruoyi.project.business.event;

import com.ruoyi.project.business.domain.ReleaseVer;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @authro fun
 * @date 2025/5/13 16:23
 */
@Getter
public class AppReleaseEvent extends ApplicationEvent {
    private ReleaseVer releaseVer;

    public AppReleaseEvent(Object source, ReleaseVer releaseVer) {
        super(source);
        this.releaseVer = releaseVer;
    }
}
