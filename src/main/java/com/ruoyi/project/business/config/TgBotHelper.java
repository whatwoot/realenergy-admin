package com.ruoyi.project.business.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.project.business.config.prop.TgBotProperties;
import com.ruoyi.project.business.dto.TgNotifyDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @authro fun
 * @date 2025/4/7 19:28
 */
@Slf4j
public class TgBotHelper {
    private TgBotProperties tgBotProperties;

    public TgBotHelper(TgBotProperties tgBotProperties) {
        this.tgBotProperties = tgBotProperties;
    }

    public void notifyTo(TgNotifyDTO req) {
        if (!Boolean.TRUE.equals(tgBotProperties.getEnable())) {
            log.info("Tg-notify {}", JSONObject.toJSONString(req));
            return;
        }
        try {
            String body = HttpRequest.post(tgBotProperties.getApi())
                    .body(JSONObject.toJSONString(req), ContentType.JSON.getValue())
                    .execute().body();
            log.info("Tg-notify {}, {}", req.getTx(), body);
        } catch (Throwable e) {
            log.info("Tg-notify retry {}", req.getTx());
            try {
                // 重试一次
                String body = HttpRequest.post(tgBotProperties.getApi())
                        .body(JSONObject.toJSONString(req), ContentType.JSON.getValue())
                        .execute().body();
                log.info("Tg-notify try {}, {}", req.getTx(), body);
            } catch (Throwable ex) {
                log.warn(StrUtil.format("Tg-notify fail: {}", req.getTx()), e);
            }
        }
    }
}
