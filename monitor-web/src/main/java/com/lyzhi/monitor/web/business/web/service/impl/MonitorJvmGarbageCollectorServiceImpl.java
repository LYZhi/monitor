package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorJvmGarbageCollectorDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmGarbageCollector;
import com.lyzhi.monitor.web.business.web.service.IMonitorJvmGarbageCollectorService;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmGarbageCollectorVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * java虚拟机GC信息服务实现类
 * </p>
 *
 */
@Service
public class MonitorJvmGarbageCollectorServiceImpl extends ServiceImpl<IMonitorJvmGarbageCollectorDao, MonitorJvmGarbageCollector> implements IMonitorJvmGarbageCollectorService {

    /**
     * java虚拟机GC信息数据访问对象
     */
    @Autowired
    private IMonitorJvmGarbageCollectorDao monitorJvmGarbageCollectorDao;

    /**
     * <p>
     * 获取java虚拟机GC信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机GC信息表现层对象
     *
     */
    @Override
    public List<MonitorJvmGarbageCollectorVo> getJvmGcInfo(String instanceId) {
        LambdaQueryWrapper<MonitorJvmGarbageCollector> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorJvmGarbageCollector::getInstanceId, instanceId);
        List<MonitorJvmGarbageCollector> monitorJvmGarbageCollectors = this.monitorJvmGarbageCollectorDao.selectList(lambdaQueryWrapper);
        // 返回值
        List<MonitorJvmGarbageCollectorVo> monitorJvmGarbageCollectorVos = Lists.newLinkedList();
        for (MonitorJvmGarbageCollector monitorJvmGarbageCollector : monitorJvmGarbageCollectors) {
            MonitorJvmGarbageCollectorVo monitorJvmGarbageCollectorVo = MonitorJvmGarbageCollectorVo.builder().build().convertFor(monitorJvmGarbageCollector);
            monitorJvmGarbageCollectorVos.add(monitorJvmGarbageCollectorVo);
        }
        return monitorJvmGarbageCollectorVos;
    }

}
