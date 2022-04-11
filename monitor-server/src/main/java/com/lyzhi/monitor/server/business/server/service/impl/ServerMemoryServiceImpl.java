package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerMemoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerMemory;
import com.lyzhi.monitor.server.business.server.service.IServerMemoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器内存信息服务层接口实现类
 * </p>
 *
 */
@Service
public class ServerMemoryServiceImpl extends ServiceImpl<IMonitorServerMemoryDao, MonitorServerMemory> implements IServerMemoryService {
}
