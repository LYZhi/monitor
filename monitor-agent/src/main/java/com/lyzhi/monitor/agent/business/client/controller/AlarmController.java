package com.lyzhi.monitor.agent.business.client.controller;

import com.lyzhi.monitor.agent.business.client.service.IAlarmService;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 告警控制器
 * </p>
 *
 */
@Api(tags = "信息包.告警包")
@RestController
@RequestMapping("/alarm")
public class AlarmController {

    /**
     * 告警服务层接口
     */
    @Autowired
    private IAlarmService alarmService;

    /**
     * <p>
     * 监控代理程序接收监控客户端程序发的告警包，并返回结果
     * </p>
     *
     * @param heartbeatPackage 告警包
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "接收和响应监控客户端程序发的告警包", notes = "接收告警包")
    @PostMapping("/accept-alarm-package")
    public BaseResponsePackage acceptAlarmPackage(@RequestBody AlarmPackage heartbeatPackage) {
        return this.alarmService.dealAlarmPackage(heartbeatPackage);
    }

}
