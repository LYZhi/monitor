package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorServerSensorsDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerSensors;
import com.lyzhi.monitor.web.business.web.service.IMonitorServerSensorsService;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerSensorsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器传感器服务实现类
 * </p>
 *
 */
@Service
public class MonitorServerSensorsServiceImpl extends ServiceImpl<IMonitorServerSensorsDao, MonitorServerSensors> implements IMonitorServerSensorsService {

    /**
     * 服务器传感器数据访问对象
     */
    @Autowired
    private IMonitorServerSensorsDao monitorServerSensorsDao;

    /**
     * <p>
     * 获取服务器详情页面服务器传感器信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器传感器信息表现层对象
     *
     */
    @Override
    public MonitorServerSensorsVo getServerDetailPageServerSensorsInfo(String ip) {
        LambdaQueryWrapper<MonitorServerSensors> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorServerSensors::getIp, ip);
        MonitorServerSensors monitorServerSensors = this.monitorServerSensorsDao.selectOne(lambdaQueryWrapper);
        return MonitorServerSensorsVo.builder().build().convertFor(monitorServerSensors);
    }

    /**
     * <p>
     * 获取CPU平均温度
     * </p>
     *
     * @param ip 服务器IP地址
     * @return CPU平均温度
     *
     */
    @Override
    public Double getCpuTemperatureInfo(String ip) {
        LambdaQueryWrapper<MonitorServerSensors> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorServerSensors::getIp, ip);
        MonitorServerSensors monitorServerSensors = this.monitorServerSensorsDao.selectOne(lambdaQueryWrapper);
        if (monitorServerSensors != null) {
            String cpuTemperature = monitorServerSensors.getCpuTemperature();
            if (!StringUtils.equals(cpuTemperature, "未知")) {
                return Double.valueOf(cpuTemperature.replace("℃", "").trim());
            }
        }
        return Double.NaN;
    }

}
