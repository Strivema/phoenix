package com.ray.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysUser;
import com.ray.admin.entity.SysUserRole;
import com.ray.admin.mapper.SysUserMapper;
import com.ray.admin.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public int delete(SysUser record) {
        return 0;
    }

    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    @Override
    public SysUser getByName(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String userName) {
        return null;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return null;
    }

    @Override
    public File createUserExcelFile(Page pageRequest) {
        return null;
    }
}
