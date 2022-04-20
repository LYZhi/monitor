package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorRole;
import com.lyzhi.monitor.web.business.web.vo.MonitorRoleVo;

/**
 * <p>
 * 监控用户角色服务类
 * </p>
 *
 */
public interface IMonitorRoleService extends IService<MonitorRole> {

    /**
     * <p>
     * 获取监控角色列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param roleId  角色ID
     * @return 分页Page对象
     *
     */
    Page<MonitorRoleVo> getMonitorRoleList(Long current, Long size, Long roleId);
}
