package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorAlarmRecord;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 告警记录数据访问对象
 * </p>
 *
 */
public interface IMonitorAlarmRecordDao extends BaseMapper<MonitorAlarmRecord> {

    /**
     * <p>
     * 获取最近7天的告警统计信息
     * </p>
     *
     * @return 最近7天的告警统计信息
     *
     */
    List<Map<String, Object>> getLast7DaysAlarmRecordStatistics();

    /**
     * <p>
     * 告警成功率统计
     * </p>
     *
     * @return 告警成功率统计信息
     *
     */
    Map<String, Object> getAlarmRecordSuccessRateStatistics();

    /**
     * <p>
     * 获取告警类型统计信息
     * </p>
     *
     * @return 告警类型统计信息
     *
     */
    List<Map<String, Object>> getAlarmRecordTypeStatistics();
}
