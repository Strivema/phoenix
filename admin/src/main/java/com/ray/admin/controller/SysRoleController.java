package com.ray.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.constant.SysConstants;
import com.ray.admin.entity.SysRole;
import com.ray.admin.entity.SysRoleMenu;
import com.ray.admin.mapper.SysRoleMapper;
import com.ray.admin.service.ISysRoleService;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("role")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.getById(record.getId());
        if (role != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if ((record.getId() == null || record.getId() == 0) && !sysRoleService.getByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysRole> pageRequest) {
        return HttpResult.ok(sysRoleService.page(pageRequest));
    }

    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @GetMapping(value = "/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    @PostMapping(value = "/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for (SysRoleMenu record : records) {
            SysRole sysRole = sysRoleMapper.selectById(record.getRoleId());
            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }

}
