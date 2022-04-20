package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmMemoryHistory;
import com.lyzhi.monitor.web.business.web.vo.InstanceDetailPageJvmMemoryChartVo;

import java.util.List;

/**
 * <p>
 * java虚拟机内存历史记录服务类
 * </p>
 *
 */
public interface IMonitorJvmMemoryHistoryService extends IService<MonitorJvmMemoryHistory> {

    /**
     * <p>
     * 获取应用实例详情页面java虚拟机内存图表信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @param memoryType 内存类型
     * @param time       时间
     * @return 应用实例详情页面java虚拟机内存图表信息表现层对象
     *
     */
    List<InstanceDetailPageJvmMemoryChartVo> getInstanceDetailPageJvmMemoryChartInfo(String instanceId, String memoryType, String time);

}
