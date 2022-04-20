package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorJvmMemoryDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmMemory;
import com.lyzhi.monitor.web.business.web.service.IMonitorJvmMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * java虚拟机内存信息服务实现类
 * </p>
 *
 */
@Service
public class MonitorJvmMemoryServiceImpl extends ServiceImpl<IMonitorJvmMemoryDao, MonitorJvmMemory> implements IMonitorJvmMemoryService {

    /**
     * java虚拟机内存信息数据访问对象
     */
    @Autowired
    private IMonitorJvmMemoryDao monitorJvmMemoryDao;

    /**
     * <p>
     * 获取jvm内存类型
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return jvm内存类型
     *
     */
    @Override
    public List<String> getJvmMemoryTypes(String instanceId) {
        return this.monitorJvmMemoryDao.getJvmMemoryTypes(instanceId);
    }

}
