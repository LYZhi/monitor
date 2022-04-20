package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmRuntime;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmRuntimeVo;

/**
 * <p>
 * java虚拟机运行时信息服务类
 * </p>
 *
 */
public interface IMonitorJvmRuntimeService extends IService<MonitorJvmRuntime> {

    /**
     * <p>
     * 获取java虚拟机运行时信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机运行时信息表现层对象
     *
     */
    MonitorJvmRuntimeVo getJvmRuntimeInfo(String instanceId);
}
