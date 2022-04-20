package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerCpuHistory;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerCpuChartVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务器CPU历史记录数据访问对象
 * </p>
 *
 */
public interface IMonitorServerCpuHistoryDao extends BaseMapper<MonitorServerCpuHistory> {

    /**
     * <p>
     * 获取服务器详情页面服务器CPU图表信息
     * </p>
     *
     * @param params 请求参数
     * @return 服务器详情页面服务器CPU图表信息表现层对象
     *
     */
    List<ServerDetailPageServerCpuChartVo> getServerDetailPageServerCpuChartInfo(@Param("params") Map<String, Object> params);

}
