package com.ray.admin.controller;

import com.ray.common.utils.PasswordUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.constant.SysConstants;
import com.ray.admin.entity.SysUser;
import com.ray.admin.service.ISysUserService;
import com.ray.common.utils.FileUtils;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUser record) {
        SysUser user = sysUserService.getById(record.getId());
        if (user != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        if (record.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (user == null) {
                // 新增用户
                if (sysUserService.getByName(record.getName()) != null) {
                    return HttpResult.error("用户名已存在!");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            } else {
                // 修改用户, 且修改了密码
                if (!record.getPassword().equals(user.getPassword())) {
                    String password = PasswordUtils.encode(record.getPassword(), salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        for (SysUser record : records) {
            SysUser sysUser = sysUserService.getById(record.getId());
            if (sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }

    @GetMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.getByName(name));
    }

    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @GetMapping(value = "/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody Page<SysUser> pageRequest) {
        return HttpResult.ok(sysUserService.page(pageRequest));
    }

    @PostMapping(value = "/exportExcelUser")
    public void exportExcelUser(@RequestBody Page<SysUser> pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }

}
