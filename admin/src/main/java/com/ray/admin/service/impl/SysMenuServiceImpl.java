package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.constant.SysConstants;
import com.ray.admin.entity.SysMenu;
import com.ray.admin.mapper.SysMenuMapper;
import com.ray.admin.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        return sysMenuMapper.deleteBatchIds(records);
    }

    @Override
    public List<SysMenu> findTree(String name, int num) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = selectByUser(name);
        for (SysMenu menu : menus) {
            if (null == menu.getParentId() || 0 == menu.getParentId()) {
                menu.setLevel(0);
                if (!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, num);
        return sysMenus;
    }

    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int num) {
        for (SysMenu sysMenu : sysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (num == 1 && menu.getType() == 2) {
                    continue;
                }
                if (null != sysMenu.getId() && sysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel() + 1);
                    if (exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort(((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum())));
            findChildren(children, menus, num);
        }

    }

    private List<SysMenu> selectByUser(String name) {
        if (null == name || "".equals(name) || SysConstants.ADMIN.equalsIgnoreCase(name)) {
            return sysMenuMapper.selectList(null);
        }
        return sysMenuMapper.selectByUser(name);
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        boolean exists = false;

        for (SysMenu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getId())) {
                exists = true;
            }
        }
        return exists;

    }
}
