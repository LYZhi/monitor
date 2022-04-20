package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.service.IMonitorServerCpuService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerCpuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 服务器CPU
 * </p>
 *
 */
@Api(tags = "服务器.服务器CPU")
@RestController
@RequestMapping("/monitor-server-cpu")
public class MonitorServerCpuController {

    /**
     * 服务器CPU服务类
     */
    @Autowired
    private IMonitorServerCpuService monitorServerCpuService;

    /**
     * <p>
     * 获取服务器详情页面服务器CPU信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取服务器详情页面服务器CPU信息")
    @ResponseBody
    @GetMapping("/get-server-detail-page-server-cpu-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ip", value = "服务器IP地址", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getServerDetailPageServerCpuInfo(@RequestParam(name = "ip") String ip) {
        List<MonitorServerCpuVo> monitorServerCpuVos = this.monitorServerCpuService.getServerDetailPageServerCpuInfo(ip);
        return LayUiAdminResultVo.ok(monitorServerCpuVos);
    }

}

