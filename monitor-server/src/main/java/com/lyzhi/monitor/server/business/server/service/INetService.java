package com.lyzhi.monitor.server.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.server.business.server.entity.MonitorNet;

/**
 * <p>
 * 网络信息服务接口
 * </p>
 *
 */
public interface INetService extends IService<MonitorNet> {

    /**
     * <p>
     * 获取被监控网络源IP地址
     * </p>
     *
     * @return 被监控网络源IP地址
     * @throws NetException 自定义获取网络信息异常
     *
     */
    String getSourceIp() throws NetException;
}
