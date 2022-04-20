package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerProcessHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerProcessHistory;
import com.lyzhi.monitor.server.business.server.service.IServerProcessHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器进程历史记录信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerProcessHistoryServiceImpl extends ServiceImpl<IMonitorServerProcessHistoryDao, MonitorServerProcessHistory> implements IServerProcessHistoryService {
}
