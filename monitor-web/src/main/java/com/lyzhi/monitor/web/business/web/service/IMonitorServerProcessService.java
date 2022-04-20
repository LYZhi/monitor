package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerProcess;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerProcessVo;

import java.util.List;

/**
 * <p>
 * 服务器进程服务类
 * </p>
 *
 */
public interface IMonitorServerProcessService extends IService<MonitorServerProcess> {

    /**
     * <p>
     * 获取服务器详情页面服务器进程信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器进程表现层对象
     *
     */
    List<MonitorServerProcessVo> getServerDetailPageServerProcessInfo(String ip);

}
