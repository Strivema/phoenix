package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ray.admin.entity.SysMenu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Component
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectByUser(String name);

    List<SysMenu> findRoleMenus(long id);
}
