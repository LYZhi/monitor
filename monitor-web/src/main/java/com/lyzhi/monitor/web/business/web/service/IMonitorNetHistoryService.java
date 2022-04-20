package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.web.business.web.entity.MonitorNetHistory;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.NetworkAvgTimeChartVo;

/**
 * <p>
 * 网络信息历史记录服务类
 * </p>
 *
 */
public interface IMonitorNetHistoryService extends IService<MonitorNetHistory> {

    /**
     * <p>
     * 获取PING耗时图表信息
     * </p>
     *
     * @param id        网络ID
     * @param ipSource  IP地址（来源）
     * @param ipTarget  IP地址（目的地）
     * @param dateValue 时间
     * @return layUiAdmin响应对象
     *
     */
    NetworkAvgTimeChartVo getAvgTimeChartInfo(Long id, String ipSource, String ipTarget, String dateValue);

    /**
     * <p>
     * 清理网络监控历史数据
     * </p>
     *
     * @param id   网络ID
     * @param time 时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo clearMonitorNetworkHistory(String id, String time);
}
