package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerNetcardDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerNetcard;
import com.lyzhi.monitor.server.business.server.service.IServerNetcardService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器网卡信息服务层实现类
 * </p>
 *
 */
@Service
public class ServerNetcardServiceImpl extends ServiceImpl<IMonitorServerNetcardDao, MonitorServerNetcard> implements IServerNetcardService {
}
