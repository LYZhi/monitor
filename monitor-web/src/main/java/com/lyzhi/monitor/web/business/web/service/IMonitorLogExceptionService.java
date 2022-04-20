package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorLogException;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorLogExceptionVo;

import java.util.List;

/**
 * <p>
 * 异常日志服务类
 * </p>
 *
 */
public interface IMonitorLogExceptionService extends IService<MonitorLogException> {

    /**
     * <p>
     * 获取异常日志列表
     * </p>
     *
     * @param current    当前页
     * @param size       每页显示条数
     * @param excName    异常名称
     * @param excMessage 异常信息
     * @param insertTime 插入时间
     * @return 简单分页模型
     *
     */
    Page<MonitorLogExceptionVo> getMonitorLogExceptionList(Long current, Long size, String excName, String excMessage, String insertTime);

    /**
     * <p>
     * 删除异常日志
     * </p>
     *
     * @param monitorLogExceptionVos 异常日志信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo deleteMonitorLogException(List<MonitorLogExceptionVo> monitorLogExceptionVos);

    /**
     * <p>
     * 获取异常日志信息
     * </p>
     *
     * @param id 异常日志ID
     * @return 异常日志表现层对象
     *
     */
    MonitorLogExceptionVo getMonitorLogExceptionInfo(Long id);
}
