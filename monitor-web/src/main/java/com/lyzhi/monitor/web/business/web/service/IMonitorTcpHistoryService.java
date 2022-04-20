package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorTcpHistory;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.TcpAvgTimeChartVo;

/**
 * <p>
 * TCP信息历史记录服务类
 * </p>
 *
 */
public interface IMonitorTcpHistoryService extends IService<MonitorTcpHistory> {

    /**
     * <p>
     * 获取TCP连接耗时图表信息
     * </p>
     *
     * @param id             TCP ID
     * @param hostnameSource 主机名（来源）
     * @param hostnameTarget 主机名（目的地）
     * @param portTarget     端口号
     * @param dateValue      时间
     * @return layUiAdmin响应对象
     *
     */
    TcpAvgTimeChartVo getAvgTimeChartInfo(Long id, String hostnameSource, String hostnameTarget, Integer portTarget, String dateValue);

    /**
     * <p>
     * 清理TCP监控历史数据
     * </p>
     *
     * @param id   TCP ID
     * @param time 时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo clearMonitorTcpHistory(String id, String time);
}
