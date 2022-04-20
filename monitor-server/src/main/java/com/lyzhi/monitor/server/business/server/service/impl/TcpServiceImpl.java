package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorTcpDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorTcp;
import com.lyzhi.monitor.server.business.server.service.ITcpService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * TCP信息服务接口实现
 * </p>
 *
 */
@Service
public class TcpServiceImpl extends ServiceImpl<IMonitorTcpDao, MonitorTcp> implements ITcpService {
}
