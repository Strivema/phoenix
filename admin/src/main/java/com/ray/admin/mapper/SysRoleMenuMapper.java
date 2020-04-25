package com.ray.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;


public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    int insertSelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    List<SysRoleMenu> findAll();

    int deleteByRoleId(@Param(value = "roleId") Long roleId);
}