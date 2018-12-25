package com.duteliang.core.config;

import com.duteliang.core.config.properties.DruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 默认的配置
 *
 * @author zl
 * @date 2018-12-25 12:08
 */
@Configuration
@PropertySource("classpath:/default-config.properties")
public class DefaultPropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidProperties druidProperties() {
        return new DruidProperties();
    }

}
