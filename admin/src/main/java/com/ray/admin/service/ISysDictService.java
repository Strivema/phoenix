package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysDict;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysDictService extends IService<SysDict> {
    int delete(SysDict record);

    int delete(List<SysDict> records);

    List<SysDict> findByLabel(String label);

}
