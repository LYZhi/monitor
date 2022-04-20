package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorNetHistoryDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorNetHistory;
import com.lyzhi.monitor.server.business.server.service.INetHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网络信息历史记录服务实现类
 * </p>
 *
 */
@Service
public class NetHistoryServiceImpl extends ServiceImpl<IMonitorNetHistoryDao, MonitorNetHistory> implements INetHistoryService {

}
