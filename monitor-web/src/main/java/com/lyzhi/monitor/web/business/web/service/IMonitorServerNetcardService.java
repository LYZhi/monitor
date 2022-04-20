package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerNetcard;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerNetcardVo;

import java.util.List;

/**
 * <p>
 * 服务器网卡服务类
 * </p>
 *
 */
public interface IMonitorServerNetcardService extends IService<MonitorServerNetcard> {

    /**
     * <p>
     * 获取服务器详情页面服务器网卡信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器详情页面服务器网卡信息表现层对象
     *
     */
    List<ServerDetailPageServerNetcardVo> getServerDetailPageServerNetcardInfo(String ip);

}
