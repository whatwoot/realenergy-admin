package com.ruoyi.project.business.event;

import cn.hutool.http.HttpRequest;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.domain.ReleaseVer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @authro fun
 * @date 2025/5/13 16:23
 */
@Slf4j
@Component
public class AppReleaseListener {

    @Autowired
    private AppProperties appProperties;

    @EventListener
    public void refresh(AppReleaseEvent event) {
        try {
            String body = HttpRequest.get(appProperties.getPrefix() + AppApi.APP_RELEASE_REFRESH).execute().body();
            log.info("App-refresh {}", body);
        } catch (Throwable e) {
            log.warn("App-refresh failed", e);
        }
    }
}
