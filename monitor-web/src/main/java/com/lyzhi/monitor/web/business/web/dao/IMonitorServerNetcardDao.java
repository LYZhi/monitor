package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerNetcard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务器网卡数据访问对象
 * </p>
 *
 */
public interface IMonitorServerNetcardDao extends BaseMapper<MonitorServerNetcard> {

    /**
     * <p>
     * 获取服务器网卡地址
     * </p>
     *
     * @param ip 服务器IP
     * @return 网卡地址列表
     *
     */
    List<String> getNetcardAddress(@Param("ip") String ip);

}
