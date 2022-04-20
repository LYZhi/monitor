package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmGarbageCollector;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmGarbageCollectorVo;

import java.util.List;

/**
 * <p>
 * java虚拟机GC信息服务类
 * </p>
 *
 */
public interface IMonitorJvmGarbageCollectorService extends IService<MonitorJvmGarbageCollector> {

    /**
     * <p>
     * 获取java虚拟机GC信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机GC信息表现层对象
     *
     */
    List<MonitorJvmGarbageCollectorVo> getJvmGcInfo(String instanceId);
}
