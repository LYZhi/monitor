package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerSensorsDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerSensors;
import com.lyzhi.monitor.server.business.server.service.IServerSensorsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器传感器信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerSensorsServiceImpl extends ServiceImpl<IMonitorServerSensorsDao, MonitorServerSensors> implements IServerSensorsService {
}
