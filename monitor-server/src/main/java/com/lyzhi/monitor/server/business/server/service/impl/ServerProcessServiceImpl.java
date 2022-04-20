package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerProcessDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerProcess;
import com.lyzhi.monitor.server.business.server.service.IServerProcessService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器进程信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerProcessServiceImpl extends ServiceImpl<IMonitorServerProcessDao, MonitorServerProcess> implements IServerProcessService {
}
