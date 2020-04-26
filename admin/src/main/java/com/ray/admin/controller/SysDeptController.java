package com.ray.admin.controller;


import com.ray.admin.entity.SysDept;
import com.ray.admin.service.ISysDeptService;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 机构管理 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {
    @Autowired
    private ISysDeptService sysDeptService;

    @PreAuthorize("hasPermission('sys:dept:add') and hasPermission('sys:dept:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PreAuthorize("hasPermission('sys:dept:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @PreAuthorize("hasPermission('sys:dept:view')")
    @GetMapping(value = "/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }

}
