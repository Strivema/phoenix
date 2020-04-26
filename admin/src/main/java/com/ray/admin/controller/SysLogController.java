package com.ray.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysLog;
import com.ray.admin.service.ISysLogService;
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
 * 系统操作日志 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("log")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @PreAuthorize("hasPermission('sys:log:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysLog> pageRequest) {
        return HttpResult.ok(sysLogService.page(pageRequest));
    }

    @PreAuthorize("hasPermission('sys:log:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }

}
