package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.service.IMonitorServerNetcardService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerNetcardVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 服务器网卡
 * </p>
 *
 */
@Api(tags = "服务器.服务器网卡")
@RestController
@RequestMapping("/monitor-server-netcard")
public class MonitorServerNetcardController {

    /**
     * 服务器网卡服务类
     */
    @Autowired
    private IMonitorServerNetcardService monitorServerNetcardService;

    /**
     * <p>
     * 获取服务器详情页面服务器网卡信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取服务器详情页面服务器网卡信息")
    @ResponseBody
    @GetMapping("/get-server-detail-page-server-netcard-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ip", value = "服务器IP地址", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getServerDetailPageServerNetcardInfo(@RequestParam(name = "ip") String ip) {
        List<ServerDetailPageServerNetcardVo> serverDetailPageServerNetcardVos = this.monitorServerNetcardService.getServerDetailPageServerNetcardInfo(ip);
        return LayUiAdminResultVo.ok(serverDetailPageServerNetcardVos);
    }

}

