package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysRole;
import com.ray.admin.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysRoleService extends IService<SysRole> {
    List<SysRole> getByName(String name);

    int delete(SysRole record);

    int delete(List<SysRole> records);

    List<SysRole> findRoleMenus(long id);

    int saveRoleMenus(List<SysRoleMenu> records);


}
