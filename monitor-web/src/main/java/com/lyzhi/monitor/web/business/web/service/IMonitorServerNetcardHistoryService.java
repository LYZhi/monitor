package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerNetcardHistory;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerNetworkSpeedChartVo;

import java.util.List;

/**
 * <p>
 * 服务器网卡历史记录服务类
 * </p>
 *
 */
public interface IMonitorServerNetcardHistoryService extends IService<MonitorServerNetcardHistory> {

    /**
     * <p>
     * 获取服务器详情页面服务器网速图表信息
     * </p>
     *
     * @param ip      服务器IP地址
     * @param address 服务器网卡地址
     * @param time    时间
     * @return 服务器详情页面服务器网速图表信息表现层对象
     *
     */
    List<ServerDetailPageServerNetworkSpeedChartVo> getServerDetailPageServerNetworkSpeedChartInfo(String ip, String address, String time);

}
