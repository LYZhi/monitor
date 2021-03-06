package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.entity.MonitorNet;
import com.lyzhi.monitor.web.business.web.vo.HomeNetVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorNetVo;

import java.util.List;

/**
 * <p>
 * 网络信息服务类
 * </p>
 *
 */
public interface IMonitorNetService extends IService<MonitorNet> {

    /**
     * <p>
     * 获取home页的网络信息
     * </p>
     *
     * @return home页的网络信息表现层对象
     *
     */
    HomeNetVo getHomeNetInfo();

    /**
     * <p>
     * 获取网络列表
     * </p>
     *
     * @param current  当前页
     * @param size     每页显示条数
     * @param ipSource IP地址（来源）
     * @param ipTarget IP地址（目的地）
     * @param status   状态（0：网络不通，1：网络正常）
     * @return 简单分页模型
     *
     */
    Page<MonitorNetVo> getMonitorNetList(Long current, Long size, String ipSource, String ipTarget, String status);

    /**
     * <p>
     * 删除网络
     * </p>
     *
     * @param monitorNetVos 网络信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorNet(List<MonitorNetVo> monitorNetVos);

    /**
     * <p>
     * 编辑网络信息
     * </p>
     *
     * @param monitorNetVo 网络信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorNetwork(MonitorNetVo monitorNetVo);

    /**
     * <p>
     * 添加网络信息
     * </p>
     *
     * @param monitorNetVo 网络信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     * @throws NetException 自定义获取网络信息异常
     *
     */
    LayUiAdminResultVo addMonitorNetwork(MonitorNetVo monitorNetVo) throws NetException;

    /**
     * <p>
     * 获取被监控网络源IP地址，获取失败则返回null。
     * </p>
     *
     * @return 被监控网络源IP地址
     *
     */
    String getSourceIp();
}
