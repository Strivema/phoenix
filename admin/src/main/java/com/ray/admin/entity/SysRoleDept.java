package com.ray.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Marie
 * @date 2020/4/21 7:20 PM
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleDept extends BaseEntity {
    private Long roleId;

    private Long deptId;

}
