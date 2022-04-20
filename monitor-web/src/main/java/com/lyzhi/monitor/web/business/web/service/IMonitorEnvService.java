package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorEnv;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorEnvVo;

import java.util.List;

/**
 * <p>
 * 监控环境服务类
 * </p>
 *
 */
public interface IMonitorEnvService extends IService<MonitorEnv> {

    /**
     * <p>
     * 获取监控环境列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param envName 环境名称
     * @param envDesc 环境描述
     * @return 简单分页模型
     *
     */
    Page<MonitorEnvVo> getMonitorEnvList(Long current, Long size, String envName, String envDesc);

    /**
     * <p>
     * 添加环境信息
     * </p>
     *
     * @param monitorEnvVo 监控环境信息表现层对象
     * @return layUiAdmin响应对象：如果已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo saveMonitorEnv(MonitorEnvVo monitorEnvVo);

    /**
     * <p>
     * 编辑环境信息
     * </p>
     *
     * @param monitorEnvVo 监控环境信息表现层对象
     * @return layUiAdmin响应对象：如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorEnv(MonitorEnvVo monitorEnvVo);

    /**
     * <p>
     * 删除环境信息
     * </p>
     *
     * @param monitorEnvVos 监控环境信息表现层对象
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorEnv(List<MonitorEnvVo> monitorEnvVos);
}
