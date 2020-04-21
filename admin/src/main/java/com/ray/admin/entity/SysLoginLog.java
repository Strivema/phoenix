package com.ray.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统登录日志
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysLoginLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）
     */
    private String status;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private LocalDateTime lastUpdateTime;


}
