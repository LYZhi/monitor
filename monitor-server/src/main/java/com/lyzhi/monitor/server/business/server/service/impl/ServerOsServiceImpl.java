package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerOsDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerOs;
import com.lyzhi.monitor.server.business.server.service.IServerOsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器操作系统信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerOsServiceImpl extends ServiceImpl<IMonitorServerOsDao, MonitorServerOs> implements IServerOsService {
}
