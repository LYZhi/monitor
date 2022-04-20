package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorNet;

import java.util.Map;

/**
 * <p>
 * 网络信息数据访问对象
 * </p>
 *
 */
public interface IMonitorNetDao extends BaseMapper<MonitorNet> {

    /**
     * <p>
     * 网络正常率统计
     * </p>
     *
     * @return 网络正常率统计信息
     *
     */
    Map<String, Object> getNetNormalRateStatistics();

}
