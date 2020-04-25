package com.ray.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {


    int insertSelective(SysUserRole record);

    List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

    int deleteByUserId(@Param(value = "userId") Long userId);
}