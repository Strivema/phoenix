package com.ray.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ray.admin.entity.SysConfig;
import org.apache.ibatis.annotations.Param;
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


    List<SysConfig> findByLabel(@Param("label") String label);

    IPage<SysConfig> selectPageVo(Page<SysConfig> page, @Param("label") String label);

    boolean save(SysConfig record);

    boolean updateByPrimaryKey(SysConfig record);
}
