package com.ray.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysConfig;
import com.ray.admin.service.ISysConfigService;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

    @Autowired
    private ISysConfigService sysConfigService;

    @PreAuthorize("hasPermission('sys:config:add') and hasPermission('sys:config:edit')")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PreAuthorize("hasPermission('sys:config:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @PreAuthorize("hasPermission('sys:config:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysConfig> page) {
        return HttpResult.ok(sysConfigService.page(page));
    }

    @PreAuthorize("hasPermission('sys:config:view')")
    @GetMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}
