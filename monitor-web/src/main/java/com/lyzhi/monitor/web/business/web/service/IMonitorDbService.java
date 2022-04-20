package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorDb;
import com.lyzhi.monitor.web.business.web.vo.HomeDbVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorDbVo;

import java.util.List;

/**
 * <p>
 * 数据库表服务类
 * </p>
 *
 */
public interface IMonitorDbService extends IService<MonitorDb> {

    /**
     * <p>
     * 获取数据库列表
     * </p>
     *
     * @param current  当前页
     * @param size     每页显示条数
     * @param connName 数据库连接名
     * @param url      数据库URL
     * @param dbType   数据库类型
     * @param isOnline 数据库状态
     * @return 简单分页模型
     *
     */
    Page<MonitorDbVo> getMonitorDbList(Long current, Long size, String connName, String url, String dbType, String isOnline);

    /**
     * <p>
     * 编辑数据库信息
     * </p>
     *
     * @param monitorDbVo 数据库信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editMonitorDb(MonitorDbVo monitorDbVo);

    /**
     * <p>
     * 添加数据库信息
     * </p>
     *
     * @param monitorDbVo 数据库信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo addMonitorDb(MonitorDbVo monitorDbVo);

    /**
     * <p>
     * 删除数据库信息
     * </p>
     *
     * @param monitorDbVos 数据库信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorDb(List<MonitorDbVo> monitorDbVos);

    /**
     * <p>
     * 获取home页的数据库信息
     * </p>
     *
     * @return home页的数据库信息表现层对象
     *
     */
    HomeDbVo getHomeDbInfo();

}
