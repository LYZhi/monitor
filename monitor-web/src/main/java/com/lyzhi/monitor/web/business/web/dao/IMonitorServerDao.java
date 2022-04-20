package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyzhi.monitor.web.business.web.entity.MonitorServer;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 服务器数据访问对象
 * </p>
 *
 */
public interface IMonitorServerDao extends BaseMapper<MonitorServer> {

    /**
     * <p>
     * 服务器在线率统计
     * </p>
     *
     * @return 服务器在线率统计信息
     *
     */
    Map<String, Object> getServerOnlineRateStatistics();

    /**
     * <p>
     * 获取服务器列表
     * </p>
     *
     * @param criteria 查询条件
     * @param ipage    分页Page对象接口
     * @return 服务器信息表现层对象
     *
     */
    IPage<MonitorServerVo> getMonitorServerList(IPage<MonitorServer> ipage, @Param("criteria") Map<String, Object> criteria);
}
