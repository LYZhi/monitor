package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerPowerSourcesDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerPowerSources;
import com.lyzhi.monitor.server.business.server.service.IServerPowerSourcesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器电池信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerPowerSourcesServiceImpl extends ServiceImpl<IMonitorServerPowerSourcesDao, MonitorServerPowerSources> implements IServerPowerSourcesService {
}
