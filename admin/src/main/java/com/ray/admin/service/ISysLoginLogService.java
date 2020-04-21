package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysLoginLog;

import java.util.List;

/**
 * <p>
 * 系统登录日志 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysLoginLogService extends IService<SysLoginLog> {
    int delete(SysLoginLog record);

    int delete(List<SysLoginLog> records);

}
