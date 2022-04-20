package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorTcp;
import com.lyzhi.monitor.web.business.web.vo.HomeTcpVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorTcpVo;

import java.util.List;

/**
 * <p>
 * TCP信息服务类
 * </p>
 *
 */
public interface IMonitorTcpService extends IService<MonitorTcp> {

    /**
     * <p>
     * 获取TCP列表
     * </p>
     *
     * @param current        当前页
     * @param size           每页显示条数
     * @param hostnameSource 主机名（来源）
     * @param hostnameTarget 主机名（目的地）
     * @param portTarget     目标端口
     * @param status         状态（0：网络不通，1：网络正常）
     * @return 简单分页模型
     *
     */
    Page<MonitorTcpVo> getMonitorTcpList(Long current, Long size, String hostnameSource, String hostnameTarget, Integer portTarget, String status);

    /**
     * <p>
     * 删除TCP
     * </p>
     *
     * @param monitorTcpVos TCP信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorTcp(List<MonitorTcpVo> monitorTcpVos);

    /**
     * <p>
     * 添加TCP信息
     * </p>
     *
     * @param monitorTcpVo TCP信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo addMonitorTcp(MonitorTcpVo monitorTcpVo);

    /**
     * <p>
     * 编辑TCP信息
     * </p>
     *
     * @param monitorTcpVo TCP信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorTcp(MonitorTcpVo monitorTcpVo);

    /**
     * <p>
     * 获取home页的TCP信息
     * </p>
     *
     * @return home页的TCP信息表现层对象
     *
     */
    HomeTcpVo getHomeTcpInfo();
}
