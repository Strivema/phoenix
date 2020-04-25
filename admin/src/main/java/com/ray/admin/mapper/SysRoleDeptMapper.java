package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysRoleDept;

public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {


    int insertSelective(SysRoleDept record);


    int updateByPrimaryKey(SysRoleDept record);
}