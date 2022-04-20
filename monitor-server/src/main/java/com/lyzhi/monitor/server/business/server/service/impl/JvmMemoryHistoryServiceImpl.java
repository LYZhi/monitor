package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorJvmMemoryHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorJvmMemoryHistory;
import com.lyzhi.monitor.server.business.server.service.IJvmMemoryHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * java虚拟机内存历史记录服务实现类
 * </p>
 *
 */
@Service
public class JvmMemoryHistoryServiceImpl extends ServiceImpl<IMonitorJvmMemoryHistoryDao, MonitorJvmMemoryHistory> implements IJvmMemoryHistoryService {
}
