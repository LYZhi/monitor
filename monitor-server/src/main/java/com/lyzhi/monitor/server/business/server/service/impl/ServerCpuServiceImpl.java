package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerCpuDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerCpu;
import com.lyzhi.monitor.server.business.server.service.IServerCpuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器CPU信息服务层接口实现类
 * </p>
 *
 */
@Service
public class ServerCpuServiceImpl extends ServiceImpl<IMonitorServerCpuDao, MonitorServerCpu> implements IServerCpuService {
}
