package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.constant.SysConstants;
import com.ray.admin.entity.SysMenu;
import com.ray.admin.entity.SysRole;
import com.ray.admin.entity.SysRoleMenu;
import com.ray.admin.mapper.SysMenuMapper;
import com.ray.admin.mapper.SysRoleMapper;
import com.ray.admin.mapper.SysRoleMenuMapper;
import com.ray.admin.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysRole> getByName(String name) {
        return sysRoleMapper.selectByName(name);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        return sysRoleMapper.deleteBatchIds(records);
    }

    @Override
    public List<SysMenu> findRoleMenus(long id) {
        SysRole sysRole = sysRoleMapper.selectById(id);

        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            return sysMenuMapper.selectList(null);
        }

        // todo 需要处理
        return sysMenuMapper.findRoleMenus(id);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (null == records || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu role : records) {
            sysRoleMenuMapper.insertSelective(role);
        }
        return 0;
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.selectList(null);
    }

    @Override
    public boolean save(SysRole entity) {
        if (null == entity.getId() || 0 == entity.getId()) {

            sysRoleMapper.insert(entity);
            return true;
        }
        sysRoleMapper.updateById(entity);
        return true;
    }

    @Override
    public IPage<SysRole> page(IPage<SysRole> page) {
        return sysRoleMapper.selectPage(page, null);
    }
}
