package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorInstance;

import java.util.Map;

/**
 * <p>
 * 应用实例数据访问对象
 * </p>
 *
 */
public interface IMonitorInstanceDao extends BaseMapper<MonitorInstance> {

    /**
     * <p>
     * 应用实例在线率统计
     * </p>
     *
     * @return 应用实例线率统计信息
     *
     */
    Map<String, Object> getInstanceOnlineRateStatistics();
}
