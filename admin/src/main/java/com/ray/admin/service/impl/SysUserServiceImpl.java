package com.ray.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.admin.entity.SysMenu;
import com.ray.admin.entity.SysRole;
import com.ray.admin.entity.SysUser;
import com.ray.admin.entity.SysUserRole;
import com.ray.admin.mapper.SysMenuMapper;
import com.ray.admin.mapper.SysRoleMapper;
import com.ray.admin.mapper.SysUserMapper;
import com.ray.admin.mapper.SysUserRoleMapper;
import com.ray.admin.service.ISysUserService;
import com.ray.common.utils.PoiUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

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

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper sysMenuService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public boolean save(SysUser entity) {
        Long id = null;
        if (entity.getId() == null || entity.getId() == 0) {
            // 新增用户
            sysUserMapper.insert(entity);
            id = entity.getId();
        } else {
            // 更新用户信息
            sysUserMapper.updateById(entity);
        }
// 更新用户角色
        if (id != null && id == 0) {
            return true;
        }
        if (id != null) {
            for (SysUserRole sysUserRole : entity.getUserRoles()) {
                sysUserRole.setUserId(id);
            }
        } else {
            sysUserRoleMapper.deleteByUserId(entity.getId());
        }
        for (SysUserRole sysUserRole : entity.getUserRoles()) {
            sysUserRoleMapper.insertSelective(sysUserRole);
        }
        return true;

    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {
        return sysUserMapper.deleteBatchIds(records);
    }

    @Override
    public SysUser getByName(String username) {
        return sysUserMapper.selectByName(username);
    }

    @Override
    public Set<String> findPermissions(String userName) {

        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.selectByUser(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public File createUserExcelFile(Page pageRequest) {
        IPage page = page(pageRequest);
        List records = page.getRecords();
        return createUserExcelFile(records);
    }

    private static File createUserExcelFile(List<?> records) {
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getDeptName());
            row.getCell(++columnIndex).setCellValue(user.getRoleNames());
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(DateUtil.formatDate(user.getCreateTime()));
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(DateUtil.formatDate(user.getLastUpdateTime()));
        }
        return PoiUtils.createExcelFile(workbook, "download_user");
    }

    @Override
    public IPage<SysUser> page(IPage<SysUser> page) {
        IPage pageResult = null;
        String name = page.getRecords().get(0).getName();
        String email = page.getRecords().get(0).getEmail();
        if (name != null) {
            if (email != null) {
                pageResult = sysUserMapper.selectPageVo(page, name, email);
            } else {
                pageResult = sysUserMapper.selectByPageName(page, name);
            }
        } else {
            pageResult = sysUserMapper.selectPage(page, null);
        }
// 加载用户角色信息
        findUserRoles(pageResult);
        return pageResult;
    }

    private void findUserRoles(IPage page) {
        List records = page.getRecords();
        for (Object object : records) {
            SysUser sysUser = (SysUser) object;

            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRolName(userRoles));
        }


    }

    private String getRolName(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<SysUserRole> iterator = userRoles.iterator(); iterator.hasNext(); ) {
            SysUserRole userRole = iterator.next();
            SysRole sysRole = sysRoleMapper.selectById(userRole.getRoleId());
            if (null == sysRole) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iterator.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
