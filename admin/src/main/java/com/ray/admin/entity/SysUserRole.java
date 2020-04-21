package com.ray.admin.entity;

import lombok.Data;

/**
 * @author Marie
 * @date 2020/4/21 7:21 PM
 **/
@Data
public class SysUserRole extends BaseEntity {
    private Long userId;

    private Long roleId;
}
