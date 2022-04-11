package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.server.business.server.dao.IMonitorNetDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorNet;
import com.lyzhi.monitor.server.business.server.service.INetService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网络信息服务接口实现
 * </p>
 *
 */
@Service
public class NetServiceImpl extends ServiceImpl<IMonitorNetDao, MonitorNet> implements INetService {

    /**
     * <p>
     * 获取被监控网络源IP地址
     * </p>
     *
     * @return 被监控网络源IP地址
     * @throws NetException 自定义获取网络信息异常
     *
     */
    @Override
    public String getSourceIp() throws NetException {
        return NetUtils.getLocalIp();
    }

}