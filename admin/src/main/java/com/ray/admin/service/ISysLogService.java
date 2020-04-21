package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysLog;

import java.util.List;

/**
 * <p>
 * 系统操作日志 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysLogService extends IService<SysLog> {
    int delete(List<SysLog> records);

    int delete(SysLog record);

}
