package com.lyzhi.monitor.server.business.server.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.server.business.server.core.PackageConstructor;
import com.lyzhi.monitor.server.business.server.service.IHeartbeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 心跳包控制器
 * </p>
 *
 */
@Slf4j
@RestController
@RequestMapping("/heartbeat")
@Api(tags = "信息包.心跳包")
public class HeartbeatController {

    /**
     * 心跳服务接口
     */
    @Autowired
    private IHeartbeatService heartbeatService;

    /**
     * <p>
     * 监控服务端程序接收监控代理端程序或者监控客户端程序发的心跳包，并返回结果
     * </p>
     *
     * @param heartbeatPackage 心跳包
     * @return {@link BaseResponsePackage}
     * @throws NetException 自定义获取网络信息异常
     *
     */
    @ApiOperation(value = "接收和响应监控代理端程序或者监控客户端程序发的心跳包", notes = "接收心跳包")
    @PostMapping("/accept-heartbeat-package")
    public BaseResponsePackage acceptHeartbeatPackage(@RequestBody HeartbeatPackage heartbeatPackage) throws NetException {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        // 返回结果
        Result result = this.heartbeatService.dealHeartbeatPackage(heartbeatPackage);
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(result);
        // 时间差（毫秒）
        String betweenDay = timer.intervalPretty();
        if (timer.intervalSecond() > 1) {
            log.warn("处理心跳包耗时：{}", betweenDay);
        }
        return baseResponsePackage;
    }

}
