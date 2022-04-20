package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorJvmClassLoadingDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmClassLoading;
import com.lyzhi.monitor.web.business.web.service.IMonitorJvmClassLoadingService;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmClassLoadingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * java虚拟机类加载信息服务实现类
 * </p>
 *
 */
@Service
public class MonitorJvmClassLoadingServiceImpl extends ServiceImpl<IMonitorJvmClassLoadingDao, MonitorJvmClassLoading> implements IMonitorJvmClassLoadingService {

    /**
     * java虚拟机类加载信息数据访问对象
     */
    @Autowired
    private IMonitorJvmClassLoadingDao monitorJvmClassLoadingDao;

    /**
     * <p>
     * 获取java虚拟机类加载信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return java虚拟机类加载信息表现层对象
     *
     */
    @Override
    public MonitorJvmClassLoadingVo getJvmClassLoadingInfo(String instanceId) {
        LambdaQueryWrapper<MonitorJvmClassLoading> loadingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        loadingLambdaQueryWrapper.eq(MonitorJvmClassLoading::getInstanceId, instanceId);
        MonitorJvmClassLoading monitorJvmClassLoading = this.monitorJvmClassLoadingDao.selectOne(loadingLambdaQueryWrapper);
        return MonitorJvmClassLoadingVo.builder().build().convertFor(monitorJvmClassLoading);
    }

}
