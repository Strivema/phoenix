package com.ray.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Marie
 * @date 2020/4/20 12:10 AM
 **/
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    // jdbc connection pool
    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    // filter
    private String filters;


}
