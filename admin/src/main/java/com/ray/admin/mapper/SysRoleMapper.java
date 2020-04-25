package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Component
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectByName(String name);
}
