package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysMenuService extends IService<SysMenu> {
    int delete(SysMenu record);

    int delete(List<SysMenu> records);

    List<SysMenu> findTree(String name, int num);

}
