package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerMemoryHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerMemoryHistory;
import com.lyzhi.monitor.server.business.server.service.IServerMemoryHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器内存历史记录信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerMemoryHistoryServiceImpl extends ServiceImpl<IMonitorServerMemoryHistoryDao, MonitorServerMemoryHistory> implements IServerMemoryHistoryService {
}
