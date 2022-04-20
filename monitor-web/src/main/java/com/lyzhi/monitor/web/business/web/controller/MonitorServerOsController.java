package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.service.IMonitorServerOsService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerOsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 服务器操作系统
 * </p>
 *
 */
@Api(tags = "服务器.服务器操作系统")
@Controller
@RequestMapping("/monitor-server-os")
public class MonitorServerOsController {

    /**
     * 服务器操作系统服务类
     */
    @Autowired
    private IMonitorServerOsService monitorServerOsService;

    /**
     * <p>
     * 获取服务器操作系统信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取服务器操作系统信息")
    @ResponseBody
    @GetMapping("/get-server-os-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ip", value = "服务器IP地址", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getMonitorServerOsInfo(@RequestParam(name = "ip") String ip) {
        MonitorServerOsVo monitorServerOsVo = this.monitorServerOsService.getMonitorServerOsInfo(ip);
        return LayUiAdminResultVo.ok(monitorServerOsVo);
    }

}

