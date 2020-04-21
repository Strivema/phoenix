package com.ray.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDict extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private BigDecimal sort;

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

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;


}
