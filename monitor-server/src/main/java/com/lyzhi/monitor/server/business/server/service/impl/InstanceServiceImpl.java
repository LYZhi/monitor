package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorInstanceDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorInstance;
import com.lyzhi.monitor.server.business.server.service.IInstanceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 应用实例服务接口实现
 * </p>
 *
 */
@Service
public class InstanceServiceImpl extends ServiceImpl<IMonitorInstanceDao, MonitorInstance> implements IInstanceService {
}
