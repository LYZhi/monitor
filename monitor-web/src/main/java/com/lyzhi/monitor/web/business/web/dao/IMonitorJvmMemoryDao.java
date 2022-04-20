package com.lyzhi.monitor.web.business.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmMemory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * java虚拟机内存信息数据访问对象
 * </p>
 *
 */
public interface IMonitorJvmMemoryDao extends BaseMapper<MonitorJvmMemory> {

    /**
     * <p>
     * 获取jvm内存类型
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return jvm内存类型
     *
     */
    List<String> getJvmMemoryTypes(@Param("instanceId") String instanceId);

}
