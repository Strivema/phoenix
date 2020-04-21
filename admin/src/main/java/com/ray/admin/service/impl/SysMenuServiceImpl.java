package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysMenu;
import com.ray.admin.mapper.SysMenuMapper;
import com.ray.admin.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public int delete(SysMenu record) {
        return 0;
    }

    @Override
    public int delete(List<SysMenu> records) {
        return 0;
    }

    @Override
    public List<SysMenu> findTree(String name, int num) {
        return null;
    }
}
