package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerOs;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerOsVo;

/**
 * <p>
 * 服务器操作系统服务类
 * </p>
 *
 */
public interface IMonitorServerOsService extends IService<MonitorServerOs> {

    /**
     * <p>
     * 获取服务器操作系统信息
     * </p>
     *
     * @param ip IP地址
     * @return 服务器操作系统信息表现层对象
     *
     */
    MonitorServerOsVo getMonitorServerOsInfo(String ip);

}
