package com.ruoyi.project.business.config.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author quzhimin
 * @date 2025/1/11 17:09
 */
@Data
@ConfigurationProperties(prefix = "app.config")
public class AppProperties {
    private String prefix;
}
