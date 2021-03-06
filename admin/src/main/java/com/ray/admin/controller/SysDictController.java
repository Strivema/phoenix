package com.ray.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysDict;
import com.ray.admin.service.ISysConfigService;
import com.ray.admin.service.ISysDictService;
import com.ray.admin.service.impl.SysDictServiceImpl;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("dict")
public class SysDictController {


    @Autowired
    private ISysDictService sysDictService;

    @PreAuthorize("hasPermission('sys:dict:edit') and hasPermission('sys:dict:add')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.saveOrUpdate(record));
    }

    @PreAuthorize("hasPermission('sys:dict:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    @PreAuthorize("hasPermission('sys:dict:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysDict> pageRequest) {
        return HttpResult.ok(sysDictService.page(pageRequest));
    }

    @PreAuthorize("hasPermission('sys:dict:view')")
    @GetMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }
}
