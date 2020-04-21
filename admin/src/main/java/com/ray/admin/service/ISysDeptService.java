package com.ray.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysDept;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
public interface ISysDeptService extends IService<SysDept> {
    int delete(SysDept record);

    int delete(List<SysDept> records);

    List<SysDept> findTree();

}
