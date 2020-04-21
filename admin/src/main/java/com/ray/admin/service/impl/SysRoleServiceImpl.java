package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysRole;
import com.ray.admin.entity.SysRoleMenu;
import com.ray.admin.mapper.SysRoleMapper;
import com.ray.admin.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<SysRole> getByName(String name) {
        return null;
    }

    @Override
    public int delete(SysRole record) {
        return 0;
    }

    @Override
    public int delete(List<SysRole> records) {
        return 0;
    }

    @Override
    public List<SysRole> findRoleMenus(long id) {
        return null;
    }

    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        return 0;
    }
}
