package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorTcpHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorTcpHistory;
import com.lyzhi.monitor.server.business.server.service.ITcpHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * TCP信息历史记录服务实现类
 * </p>
 *
 */
@Service
public class TcpHistoryServiceImpl extends ServiceImpl<IMonitorTcpHistoryDao, MonitorTcpHistory> implements ITcpHistoryService {

}
