package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysDept;
import com.ray.admin.mapper.SysDeptMapper;
import com.ray.admin.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        return sysDeptMapper.deleteBatchIds(records);
    }

    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.selectAll();
        for (SysDept dept : depts) {
            if (null == dept.getParentId() || 0 == dept.getParentId()) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, depts);
        return sysDepts;
    }

    @Override
    public boolean save(SysDept entity) {
        if (entity.getId() == null || entity.getId() == 0) {
            sysDeptMapper.updateById(entity);
            return true;
        }
        sysDeptMapper.insert(entity);
        return true;
    }

    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        for (SysDept sysDept : sysDepts) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }


    }
}
