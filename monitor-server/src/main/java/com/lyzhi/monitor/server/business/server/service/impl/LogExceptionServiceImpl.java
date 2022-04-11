package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.server.business.server.dao.IMonitorLogExceptionDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorLogException;
import com.lyzhi.monitor.server.business.server.service.ILogExceptionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 异常日志服务层接口实现类
 * </p>
 *
 */
@Service
public class LogExceptionServiceImpl extends ServiceImpl<IMonitorLogExceptionDao, MonitorLogException> implements ILogExceptionService {

}
