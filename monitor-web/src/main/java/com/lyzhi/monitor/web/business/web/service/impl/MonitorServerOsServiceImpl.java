package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorServerOsDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerOs;
import com.lyzhi.monitor.web.business.web.service.IMonitorServerOsService;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerOsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器操作系统服务实现类
 * </p>
 *
 */
@Service
public class MonitorServerOsServiceImpl extends ServiceImpl<IMonitorServerOsDao, MonitorServerOs> implements IMonitorServerOsService {

    /**
     * 服务器操作系统数据访问对象
     */
    @Autowired
    private IMonitorServerOsDao monitorServerOsDao;

    /**
     * <p>
     * 获取服务器操作系统信息
     * </p>
     *
     * @param ip IP地址
     * @return 服务器操作系统信息表现层对象
     *
     */
    @Override
    public MonitorServerOsVo getMonitorServerOsInfo(String ip) {
        LambdaQueryWrapper<MonitorServerOs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorServerOs::getIp, ip);
        MonitorServerOs monitorServerOs = monitorServerOsDao.selectOne(lambdaQueryWrapper);
        return MonitorServerOsVo.builder().build().convertFor(monitorServerOs);
    }

}
