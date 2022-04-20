package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorAlarmRecord;
import com.lyzhi.monitor.web.business.web.vo.HomeAlarmRecordVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorAlarmRecordVo;

import java.util.List;

/**
 * <p>
 * 告警记录服务类
 * </p>
 *
 */
public interface IMonitorAlarmRecordService extends IService<MonitorAlarmRecord> {

    /**
     * <p>
     * 获取home页的告警记录信息
     * </p>
     *
     * @return home页的告警记录表现层对象
     *
     */
    HomeAlarmRecordVo getHomeAlarmRecordInfo();

    /**
     * <p>
     * 获取监控告警列表
     * </p>
     *
     * @param current    当前页
     * @param size       每页显示条数
     * @param type       告警类型
     * @param level      告警级别
     * @param status     告警状态
     * @param title      告警标题
     * @param content    告警内容
     * @param number     被告警人号码
     * @param insertDate 记录日期
     * @param updateDate 告警日期
     * @return 分页Page对象
     *
     */
    Page<MonitorAlarmRecordVo> getMonitorAlarmRecordList(Long current, Long size, String type, String level,
                                                         String status, String title, String content,
                                                         String number, String insertDate, String updateDate);

    /**
     * <p>
     * 获取监控告警列表
     * </p>
     *
     * @param type    告警类型
     * @param level   告警级别
     * @param status  告警状态
     * @param title   告警标题
     * @param content 告警内容
     * @return 监控告警表现层对象列表
     *
     */
    List<MonitorAlarmRecordVo> getMonitorAlarmRecordList(String type, String level, String status, String title, String content);

    /**
     * <p>
     * 删除告警记录
     * </p>
     *
     * @param monitorAlarmRecordVos 告警记录
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorAlarmRecord(List<MonitorAlarmRecordVo> monitorAlarmRecordVos);

    /**
     * <p>
     * 获取最近7天的告警统计信息
     * </p>
     *
     * @return layUiAdmin响应对象
     *
     */
    LayUiAdminResultVo getLast7DaysAlarmRecordStatistics();

    /**
     * <p>
     * 获取告警类型统计信息
     * </p>
     *
     * @return layUiAdmin响应对象
     *
     */
    LayUiAdminResultVo getAlarmRecordTypeStatistics();

    /**
     * <p>
     * 获取监控告警记录信息
     * </p>
     *
     * @param id 告警记录ID
     * @return 监控告警表现层对象
     *
     */
    MonitorAlarmRecordVo getMonitorAlarmRecordDetail(Long id);

    /**
     * <p>
     * 获取最新的5条告警记录
     * </p>
     *
     * @return layUiAdmin响应对象
     *
     */
    LayUiAdminResultVo getLast5AlarmRecord();
}
