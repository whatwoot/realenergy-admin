package com.ruoyi.project.business.config;

import com.ruoyi.project.business.config.prop.AppProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author quzhimin
 * @date 2025/1/11 17:04
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({AppProperties.class})
public class AppConfig {

}
