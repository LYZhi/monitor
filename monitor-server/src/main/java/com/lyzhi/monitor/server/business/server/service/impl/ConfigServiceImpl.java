package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorConfigDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorConfig;
import com.lyzhi.monitor.server.business.server.service.IConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 监控配置服务实现
 * </p>
 *
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<IMonitorConfigDao, MonitorConfig> implements IConfigService {
}
