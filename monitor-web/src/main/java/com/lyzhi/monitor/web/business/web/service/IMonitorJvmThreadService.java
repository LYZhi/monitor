package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmThread;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmThreadVo;

/**
 * <p>
 * java虚拟机线程信息服务类
 * </p>
 *
 */
public interface IMonitorJvmThreadService extends IService<MonitorJvmThread> {

    /**
     * <p>
     * 获取java虚拟机线程信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机线程信息表现层对象
     *
     */
    MonitorJvmThreadVo getJvmThreadInfo(String instanceId);
}
