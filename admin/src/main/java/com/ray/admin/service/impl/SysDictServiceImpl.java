package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysDict;
import com.ray.admin.mapper.SysDictMapper;
import com.ray.admin.service.ISysDictService;
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

    @Override
    public int delete(SysDict record) {
        return 0;
    }

    @Override
    public int delete(List<SysDict> records) {
        return 0;
    }

    @Override
    public List<SysDict> findByLable(String lable) {
        return null;
    }
}
