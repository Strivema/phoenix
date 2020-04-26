package com.ray.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysLoginLog;
import com.ray.admin.service.ISysLoginLogService;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统登录日志 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {
    @Autowired
    private ISysLoginLogService sysLoginLogService;


    @PreAuthorize("hasPermission('sys:loginlog:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysLoginLog> pageRequest) {
        return HttpResult.ok(sysLoginLogService.page(pageRequest));
    }

    @PreAuthorize("hasPermission('sys:loginlog:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }

}
