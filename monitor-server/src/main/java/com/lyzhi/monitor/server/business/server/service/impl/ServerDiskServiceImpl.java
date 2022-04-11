package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorServerDiskDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerDisk;
import com.lyzhi.monitor.server.business.server.service.IServerDiskService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器磁盘信息服务层接口实现
 * </p>
 *
 */
@Service
public class ServerDiskServiceImpl extends ServiceImpl<IMonitorServerDiskDao, MonitorServerDisk> implements IServerDiskService {
}
