package com.lyzhi.monitor.server.business.server.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;
import com.lyzhi.monitor.server.business.server.core.PackageConstructor;
import com.lyzhi.monitor.server.business.server.service.IServerService;
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
 * 服务器信息包控制器
 * </p>
 *
 */
@Slf4j
@RestController
@RequestMapping("/server")
@Api(tags = "信息包.服务器信息包")
public class ServerController {

    /**
     * 服务器信息服务层接口
     */
    @Autowired
    private IServerService serverService;

    /**
     * <p>
     * 监控服务端程序接收监控代理端程序或者监控客户端程序发的服务器信息包，并返回结果
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "接收和响应监控代理端程序或者监控客户端程序发的服务器信息包", notes = "接收服务器信息包")
    @PostMapping("/accept-server-package")
    public BaseResponsePackage acceptServerPackage(@RequestBody ServerPackage serverPackage) {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        Result result = this.serverService.dealServerPackage(serverPackage);
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(result);
        // 时间差（毫秒）
        String betweenDay = timer.intervalPretty();
        if (timer.intervalSecond() > 1) {
            log.warn("处理服务器信息包耗时：{}", betweenDay);
        }
        return baseResponsePackage;
    }

}
