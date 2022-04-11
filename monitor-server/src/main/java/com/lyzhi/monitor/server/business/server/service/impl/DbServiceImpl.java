package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorDbDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorDb;
import com.lyzhi.monitor.server.business.server.service.IDbService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库表服务接口实现
 * </p>
 *
 */
@Service
public class DbServiceImpl extends ServiceImpl<IMonitorDbDao, MonitorDb> implements IDbService {
}
