package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    SysUser selectByName(String username);

    IPage<SysUser> selectPageVo(IPage<SysUser> page, String name, String email);

    IPage<SysUser> selectByPageName(IPage<SysUser> page, String name);

}
