package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmClassLoading;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmClassLoadingVo;

/**
 * <p>
 * java虚拟机类加载信息服务类
 * </p>
 *
 */
public interface IMonitorJvmClassLoadingService extends IService<MonitorJvmClassLoading> {

    /**
     * <p>
     * 获取java虚拟机类加载信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机类加载信息表现层对象
     *
     */
    MonitorJvmClassLoadingVo getJvmClassLoadingInfo(String instanceId);
}
