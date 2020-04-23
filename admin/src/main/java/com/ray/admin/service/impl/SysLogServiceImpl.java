package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysLog;
import com.ray.admin.mapper.SysLogMapper;
import com.ray.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统操作日志 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int delete(List<SysLog> records) {
        return sysLogMapper.deleteBatchIds(records);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteById(record.getId());
    }

    @Override
    public IPage<SysLog> page(IPage<SysLog> page) {
        return sysLogMapper.selectPage(page, null);
    }
}
