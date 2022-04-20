package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorTcp;

import java.util.Map;

/**
 * <p>
 * TCP信息数据访问对象
 * </p>
 *
 */
public interface IMonitorTcpDao extends BaseMapper<MonitorTcp> {

    /**
     * <p>
     * TCP正常率统计
     * </p>
     *
     * @return TCP正常率统计信息
     *
     */
    Map<String, Object> getTcpNormalRateStatistics();
}
