package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorTcpIpDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorTcpIp;
import com.lyzhi.monitor.server.business.server.service.ITcpIpService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * TCP/IP信息服务接口实现
 * </p>
 *
 */
@Service
public class TcpIpServiceImpl extends ServiceImpl<IMonitorTcpIpDao, MonitorTcpIp> implements ITcpIpService {
}
