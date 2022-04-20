package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerCpuHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerCpuHistory;
import com.lyzhi.monitor.server.business.server.service.IServerCpuHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器CPU历史记录信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerCpuHistoryServiceImpl extends ServiceImpl<IMonitorServerCpuHistoryDao, MonitorServerCpuHistory> implements IServerCpuHistoryService {
}
