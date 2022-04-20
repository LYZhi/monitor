package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerOs;

import java.util.Map;

/**
 * <p>
 * 服务器操作系统数据访问对象
 * </p>
 *
 */
public interface IMonitorServerOsDao extends BaseMapper<MonitorServerOs> {

    /**
     * <p>
     * 服务器类型统计
     * </p>
     *
     * @return 服务器类型统计信息
     *
     */
    Map<String, Object> getServerOsTypeStatistics();

}
