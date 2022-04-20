package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorServer;
import com.lyzhi.monitor.web.business.web.vo.HomeServerVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerVo;

import java.util.List;

/**
 * <p>
 * 服务器服务类
 * </p>
 *
 */
public interface IMonitorServerService extends IService<MonitorServer> {

    /**
     * <p>
     * 获取home页的服务器信息
     * </p>
     *
     * @return home页的服务器表现层对象
     *
     */
    HomeServerVo getHomeServerInfo();

    /**
     * <p>
     * 获取服务器列表
     * </p>
     *
     * @param current      当前页
     * @param size         每页显示条数
     * @param ip           IP
     * @param serverName   服务器名
     * @param isOnline     状态
     * @param monitorEnv   监控环境
     * @param monitorGroup 监控分组
     * @return 简单分页模型
     *
     */
    Page<MonitorServerVo> getMonitorServerList(Long current, Long size, String ip, String serverName, String isOnline, String monitorEnv, String monitorGroup);

    /**
     * <p>
     * 删除服务器
     * </p>
     *
     * @param monitorServerVos 服务器信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorServer(List<MonitorServerVo> monitorServerVos);

    /**
     * <p>
     * 获取服务器网卡地址
     * </p>
     *
     * @param ip 服务器IP
     * @return 网卡地址列表
     *
     */
    List<String> getNetcardAddress(String ip);

    /**
     * <p>
     * 清理服务器监控历史数据
     * </p>
     *
     * @param ip   IP地址
     * @param time 时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo clearMonitorServerHistory(String ip, String time);

    /**
     * <p>
     * 编辑服务器信息
     * </p>
     *
     * @param monitorServerVo 服务器信息
     * @return 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorServer(MonitorServerVo monitorServerVo);

    /**
     * <p>
     * 根据条件获取服务器信息
     * </p>
     *
     * @param id 服务器主键ID
     * @param ip IP地址
     * @return MonitorServerVo 服务器信息
     *
     */
    MonitorServerVo getMonitorServerInfo(Long id, String ip);
}