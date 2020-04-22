package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 系统配置表 Mapper 接口
 * </p>
 *
 * @author Marie
 * @since 2020-04-19
 */
@Component
public interface SysConfigMapper extends BaseMapper<SysConfig> {


    List<SysConfig> findByLable(String lable);

    IPage<SysConfig> selectPageVo(Page<?> page, String lable);

}
