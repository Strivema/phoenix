package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysDict;
import com.ray.admin.mapper.SysDictMapper;
import com.ray.admin.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public int delete(SysDict record) {

        return sysDictMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        return sysDictMapper.deleteBatchIds(records);
    }

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public boolean saveOrUpdate(SysDict entity) {
        if (null == entity.getId() || 0 == entity.getId()) {

            sysDictMapper.insert(entity);
        } else {
            sysDictMapper.updateById(entity);
        }
        return true;
    }

    @Override
    public IPage<SysDict> page(IPage<SysDict> page) {
        return sysDictMapper.selectPageVo(page,page.getRecords().get(0).getLabel());
    }
}
