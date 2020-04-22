package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysConfig;
import com.ray.admin.mapper.SysConfigMapper;
import com.ray.admin.service.ISysConfigService;
import com.ray.core.exception.PhoenixException;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int delete(SysConfig record) {
        if (null == record.getId()) {

        }
        return sysConfigMapper.deleteById(record.getId());
    }


    public IPage<SysConfig> page(Page<SysConfig> page) {

        return sysConfigMapper.selectPageVo(page, page.getRecords().get(0).getLabel());
    }

    public boolean save(SysConfig record) {
        if (null == record || record.getId() == 0) {
            return sysConfigMapper.save(record);
        }
        return sysConfigMapper.updateByPrimaryKey(record);
    }

}
