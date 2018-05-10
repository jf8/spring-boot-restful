package com.fosun.beauty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Beauty.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link com.fosun.beauty.common.config.FosunProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
