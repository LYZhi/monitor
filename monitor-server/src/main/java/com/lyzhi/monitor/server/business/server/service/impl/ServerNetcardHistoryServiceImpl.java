package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerNetcardHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerNetcardHistory;
import com.lyzhi.monitor.server.business.server.service.IServerNetcardHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器网卡历史记录信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerNetcardHistoryServiceImpl extends ServiceImpl<IMonitorServerNetcardHistoryDao, MonitorServerNetcardHistory> implements IServerNetcardHistoryService {
}
