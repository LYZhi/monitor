package com.lyzhi.monitor.common.util.server.oshi;

import cn.hutool.core.util.NumberUtil;
import com.lyzhi.monitor.common.domain.server.SensorsDomain;
import com.lyzhi.monitor.common.init.InitOshi;
import com.google.common.collect.Lists;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

import java.util.List;

/**
 * <p>
 * 传感器工具类
 * </p>
 *
 */
public class SensorsUtils extends InitOshi {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private SensorsUtils() {
    }

    /**
     * <p>
     * 获取传感器信息
     * </p>
     *
     * @return {@link SensorsDomain}

     */
    public static SensorsDomain getSensorsInfo() {
        HardwareAbstractionLayer hardwareAbstractionLayer = SYSTEM_INFO.getHardware();
        Sensors sensors = hardwareAbstractionLayer.getSensors();
        double cpuTemperature = NumberUtil.round(sensors.getCpuTemperature(), 2).doubleValue();
        double cpuVoltage = NumberUtil.round(sensors.getCpuVoltage(), 2).doubleValue();
        int[] fanSpeeds = sensors.getFanSpeeds();
        SensorsDomain sensorDomain = new SensorsDomain();
        sensorDomain.setCpuTemperature(cpuTemperature != 0 ? cpuTemperature + "℃" : "未知");
        sensorDomain.setCpuVoltage(cpuVoltage != 0 ? cpuVoltage + "V" : "未知");
        List<SensorsDomain.FanSpeedDomain> fanSpeedDomains = Lists.newArrayList();
        for (int fanSpeed : fanSpeeds) {
            SensorsDomain.FanSpeedDomain fanSpeedDomain = new SensorsDomain.FanSpeedDomain();
            fanSpeedDomain.setFanSpeed(fanSpeed != 0 ? fanSpeed + "rpm" : "未知");
            fanSpeedDomains.add(fanSpeedDomain);
            sensorDomain.setFanSpeedDomainList(fanSpeedDomains);
        }
        return sensorDomain;
    }

}
