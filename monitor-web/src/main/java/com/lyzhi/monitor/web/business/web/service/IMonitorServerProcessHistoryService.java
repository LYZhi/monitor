package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerProcessHistory;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerProcessChartVo;

import java.util.List;

/**
 * <p>
 * 服务器进程历史记录服务类
 * </p>
 *
 */
public interface IMonitorServerProcessHistoryService extends IService<MonitorServerProcessHistory> {

    /**
     * <p>
     * 获取服务器详情页面服务器进程图表信息
     * </p>
     *
     * @param ip   服务器IP地址
     * @param time 时间
     * @return 服务器详情页面服务器进程图表信息表现层对象
     *
     */
    List<ServerDetailPageServerProcessChartVo> getServerDetailPageServerProcessChartInfo(String ip, String time);

}
