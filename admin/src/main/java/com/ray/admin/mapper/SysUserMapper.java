package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Component
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser seleclByName(String username);
}
