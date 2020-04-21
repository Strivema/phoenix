package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysDept;
import com.ray.admin.mapper.SysDeptMapper;
import com.ray.admin.service.ISysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public int delete(SysDept record) {
        return 0;
    }

    @Override
    public int delete(List<SysDept> records) {
        return 0;
    }

    @Override
    public List<SysDept> findTree() {
        return null;
    }
}
