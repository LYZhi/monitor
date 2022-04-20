package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerPowerSources;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerPowerSourcesVo;

import java.util.List;

/**
 * <p>
 * 服务器电池服务类
 * </p>
 *
 */
public interface IMonitorServerPowerSourcesService extends IService<MonitorServerPowerSources> {

    /**
     * <p>
     * 获取服务器详情页面服务器电池信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器电池信息表现层对象
     *
     */
    List<MonitorServerPowerSourcesVo> getServerDetailPageServerPowerSourcesInfo(String ip);

    /**
     * <p>
     * 获取电池平均剩余容量百分比
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 电池平均剩余容量百分比
     *
     */
    Double getRemainingCapacityPercentAvg(String ip);

}
