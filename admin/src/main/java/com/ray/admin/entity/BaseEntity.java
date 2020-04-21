package com.ray.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Marie
 * @date 2020/4/21 5:20 PM
 **/
@Data
public class BaseEntity {
    private Long id;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

}
