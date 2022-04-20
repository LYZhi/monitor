package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmMemory;

import java.util.List;

/**
 * <p>
 * java虚拟机内存信息服务类
 * </p>
 *
 */
public interface IMonitorJvmMemoryService extends IService<MonitorJvmMemory> {

    /**
     * <p>
     * 获取jvm内存类型
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return jvm内存类型
     *
     */
    List<String> getJvmMemoryTypes(String instanceId);
}
