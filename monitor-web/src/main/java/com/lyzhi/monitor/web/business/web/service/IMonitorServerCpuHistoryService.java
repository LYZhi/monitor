package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerCpuHistory;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerCpuChartVo;

import java.util.List;

/**
 * <p>
 * 服务器CPU历史记录服务类
 * </p>
 *
 */
public interface IMonitorServerCpuHistoryService extends IService<MonitorServerCpuHistory> {

    /**
     * <p>
     * 获取服务器详情页面服务器CPU图表信息
     * </p>
     *
     * @param ip   服务器IP地址
     * @param time 时间
     * @return 服务器详情页面服务器CPU图表信息表现层对象
     *
     */
    List<ServerDetailPageServerCpuChartVo> getServerDetailPageServerCpuChartInfo(String ip, String time);

}
