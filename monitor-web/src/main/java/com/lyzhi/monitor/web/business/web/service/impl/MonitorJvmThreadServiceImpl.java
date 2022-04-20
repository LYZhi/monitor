package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorJvmThreadDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmThread;
import com.lyzhi.monitor.web.business.web.service.IMonitorJvmThreadService;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmThreadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * java虚拟机线程信息服务实现类
 * </p>
 *
 */
@Service
public class MonitorJvmThreadServiceImpl extends ServiceImpl<IMonitorJvmThreadDao, MonitorJvmThread> implements IMonitorJvmThreadService {

    /**
     * java虚拟机线程信息数据访问对象
     */
    @Autowired
    private IMonitorJvmThreadDao monitorJvmThreadDao;

    /**
     * <p>
     * 获取java虚拟机线程信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机线程信息表现层对象
     *
     */
    @Override
    public MonitorJvmThreadVo getJvmThreadInfo(String instanceId) {
        LambdaQueryWrapper<MonitorJvmThread> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorJvmThread::getInstanceId, instanceId);
        MonitorJvmThread monitorJvmThread = this.monitorJvmThreadDao.selectOne(lambdaQueryWrapper);
        return MonitorJvmThreadVo.builder().build().convertFor(monitorJvmThread);
    }

}
