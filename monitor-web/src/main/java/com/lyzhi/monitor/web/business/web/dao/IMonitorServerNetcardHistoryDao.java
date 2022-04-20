package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerNetcardHistory;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerNetworkSpeedChartVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务器网卡历史记录数据访问对象
 * </p>
 *
 */
public interface IMonitorServerNetcardHistoryDao extends BaseMapper<MonitorServerNetcardHistory> {


    /**
     * <p>
     * 获取服务器详情页面服务器网速图表信息
     * </p>
     *
     * @param params 请求参数
     * @return 服务器详情页面服务器网速图表信息
     *
     */
    List<ServerDetailPageServerNetworkSpeedChartVo> getServerDetailPageServerNetworkSpeedChartInfo(@Param("params") Map<String, Object> params);

}
