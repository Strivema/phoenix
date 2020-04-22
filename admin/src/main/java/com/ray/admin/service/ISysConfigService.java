package com.ray.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.admin.entity.SysConfig;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */

public interface ISysConfigService extends IService<SysConfig> {

    List<SysConfig> findByLabel(String label);

    int delete(List<SysConfig> records);

    int delete(SysConfig records);

    IPage<SysConfig> page(Page<SysConfig> page);


}
