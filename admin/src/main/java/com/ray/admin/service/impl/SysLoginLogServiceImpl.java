package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysLoginLog;
import com.ray.admin.mapper.SysLoginLogMapper;
import com.ray.admin.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统登录日志 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {

    @Override
    public int delete(SysLoginLog record) {
        return 0;
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        return 0;
    }
}
