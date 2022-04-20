package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerCpu;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerCpuVo;

import java.util.List;

/**
 * <p>
 * 服务器CPU服务类
 * </p>
 *
 */
public interface IMonitorServerCpuService extends IService<MonitorServerCpu> {

    /**
     * <p>
     * 获取服务器详情页面服务器CPU信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器CPU信息表现层对象
     *
     */
    List<MonitorServerCpuVo> getServerDetailPageServerCpuInfo(String ip);

}
