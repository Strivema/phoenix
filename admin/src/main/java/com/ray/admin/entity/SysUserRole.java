package com.ray.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Marie
 * @date 2020/4/21 7:21 PM
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRole extends BaseEntity {
    private Long userId;

    private Long roleId;
}
