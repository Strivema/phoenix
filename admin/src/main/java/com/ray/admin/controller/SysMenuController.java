package com.ray.admin.controller;


import com.ray.admin.entity.SysMenu;
import com.ray.admin.service.ISysMenuService;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;

    @PreAuthorize("hasPermission('sys:menu:add') and hasPermission('sys:menu:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @PreAuthorize("hasPermission('sys:menu:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysMenuService.delete(records));
    }

    @PreAuthorize("hasPermission('sys:menu:view')")
    @GetMapping(value = "/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @PreAuthorize("hasPermission('sys:menu:view')")
    @GetMapping(value = "/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }

}
