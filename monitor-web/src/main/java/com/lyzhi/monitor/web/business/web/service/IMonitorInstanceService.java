package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorInstance;
import com.lyzhi.monitor.web.business.web.vo.HomeInstanceVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorInstanceVo;

import java.util.List;

/**
 * <p>
 * 应用实例服务类
 * </p>
 *
 */
public interface IMonitorInstanceService extends IService<MonitorInstance> {

    /**
     * <p>
     * 获取home页的应用实例信息
     * </p>
     *
     * @return home页的应用实例表现层对象
     *
     */
    HomeInstanceVo getHomeInstanceInfo();

    /**
     * <p>
     * 获取应用程序列表
     * </p>
     *
     * @param current      当前页
     * @param size         每页显示条数
     * @param instanceName 应用实例名
     * @param endpoint     端点
     * @param isOnline     应用状态
     * @param monitorEnv   监控环境
     * @param monitorGroup 监控分组
     * @return 简单分页模型
     *
     */
    Page<MonitorInstanceVo> getMonitorInstanceList(Long current, Long size, String instanceName, String endpoint, String isOnline, String monitorEnv, String monitorGroup);

    /**
     * <p>
     * 删除应用程序
     * </p>
     *
     * @param monitorInstanceVos 应用程序信息
     * @return layUiAdmin响应对象：如果删除用户成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorInstance(List<MonitorInstanceVo> monitorInstanceVos);

    /**
     * <p>
     * 清理应用程序监控历史数据
     * </p>
     *
     * @param instanceId 应用实例ID
     * @param time       时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo clearMonitorInstanceHistory(String instanceId, String time);

    /**
     * <p>
     * 根据条件获取应用程序信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return 应用程序信息
     *
     */
    MonitorInstanceVo getMonitorInstanceInfo(String instanceId);

    /**
     * <p>
     * 编辑应用程序信息
     * </p>
     *
     * @param monitorInstanceVo 应用程序信息
     * @return 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorInstance(MonitorInstanceVo monitorInstanceVo);
}
