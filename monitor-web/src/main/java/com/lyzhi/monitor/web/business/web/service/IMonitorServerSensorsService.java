package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerSensors;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerSensorsVo;

/**
 * <p>
 * 服务器传感器服务类
 * </p>
 *
 */
public interface IMonitorServerSensorsService extends IService<MonitorServerSensors> {

    /**
     * <p>
     * 获取服务器详情页面服务器传感器信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器传感器信息表现层对象
     *
     */
    MonitorServerSensorsVo getServerDetailPageServerSensorsInfo(String ip);

    /**
     * <p>
     * 获取CPU平均温度
     * </p>
     *
     * @param ip 服务器IP地址
     * @return CPU平均温度
     *
     */
    Double getCpuTemperatureInfo(String ip);

}
