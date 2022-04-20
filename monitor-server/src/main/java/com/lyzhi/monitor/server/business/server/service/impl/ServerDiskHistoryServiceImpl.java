package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerDiskHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerDiskHistory;
import com.lyzhi.monitor.server.business.server.service.IServerDiskHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器磁盘历史记录服务层实现类
 * </p>
 *
 */
@Service
public class ServerDiskHistoryServiceImpl extends ServiceImpl<IMonitorServerDiskHistoryDao, MonitorServerDiskHistory> implements IServerDiskHistoryService {
}
