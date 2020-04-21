package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysConfig;
import com.ray.admin.mapper.SysConfigMapper;
import com.ray.admin.service.ISysConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public List<SysConfig> findByLable(String lable) {
        return null;
    }

    @Override
    public int delete(List<SysConfig> records) {
        return 0;
    }

    @Override
    public int delete(SysConfig records) {
        return 0;
    }
}
