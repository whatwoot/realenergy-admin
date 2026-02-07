package com.ruoyi.project.business.config;

import com.ruoyi.project.business.config.prop.TgBotProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authro fun
 * @date 2025/4/7 19:25
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({TgBotProperties.class})
public class TgBotConfig {

    @Bean
    @ConditionalOnProperty("tg.bot.config.api")
    public TgBotHelper tgBotHelper(TgBotProperties tgBotProperties) {
        log.info("tgBotHelper init");
        return new TgBotHelper(tgBotProperties);
    }
}
