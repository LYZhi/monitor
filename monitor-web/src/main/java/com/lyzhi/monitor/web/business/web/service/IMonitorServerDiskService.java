package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerDisk;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerDiskChartVo;

import java.util.List;

/**
 * <p>
 * 服务器磁盘服务类
 * </p>
 *
 */
public interface IMonitorServerDiskService extends IService<MonitorServerDisk> {

    /**
     * <p>
     * 获取服务器详情页面服务器磁盘图表信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器详情页面服务器磁盘图表信息表现层对象
     *
     */
    List<ServerDetailPageServerDiskChartVo> getServerDetailPageServerDiskChartInfo(String ip);

}
