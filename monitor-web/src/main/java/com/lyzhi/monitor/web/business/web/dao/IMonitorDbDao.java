package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorDb;

import java.util.Map;

/**
 * <p>
 * 数据库表数据访问对象
 * </p>
 *
 */
public interface IMonitorDbDao extends BaseMapper<MonitorDb> {

    /**
     * <p>
     * 数据库正常率统计
     * </p>
     *
     * @return 数据库正常率统计信息
     *
     */
    Map<String, Object> getDbNormalRateStatistics();

}
