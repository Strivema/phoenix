package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ray.admin.entity.SysDict;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Component
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<SysDict> findByLabel(String label);

    IPage<SysDict> selectPageVo(IPage<SysDict> page, String label);
}
