package com.lyzhi.monitor.agent.business.client.controller;

import com.lyzhi.monitor.agent.business.client.service.IServerService;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 服务器信息控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/server")
@Api(tags = "信息包.服务器信息包")
public class ServerController {

    /**
     * 服务器信息服务接口
     */
    @Autowired
    private IServerService serverService;

    /**
     * <p>
     * 监控代理程序接收监控客户端程序发的服务器信息包，并返回结果
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "接收和响应监控客户端程序发的服务器信息包", notes = "接收服务器信息包")
    @PostMapping("/accept-server-package")
    public BaseResponsePackage acceptServerPackage(@RequestBody ServerPackage serverPackage) {
        return this.serverService.dealServerPackage(serverPackage);
    }
}
