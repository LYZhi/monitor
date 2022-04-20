package com.lyzhi.monitor.web.business.web.controller;


import com.lyzhi.monitor.web.business.web.service.IMonitorJvmRuntimeService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmRuntimeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * java虚拟机运行时信息
 * </p>
 *
 */
@Api(tags = "应用程序.java虚拟机运行时信息")
@RestController
@RequestMapping("/monitor-jvm-runtime")
public class MonitorJvmRuntimeController {

    /**
     * java虚拟机运行时信息服务类
     */
    @Autowired
    private IMonitorJvmRuntimeService monitorJvmRuntimeService;

    /**
     * <p>
     * 获取java虚拟机运行时信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取java虚拟机运行时信息")
    @ResponseBody
    @GetMapping("/get-jvm-runtime-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "instanceId", value = "应用实例ID", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getJvmRuntimeInfo(@RequestParam(name = "instanceId") String instanceId) {
        MonitorJvmRuntimeVo monitorJvmRuntimeVo = this.monitorJvmRuntimeService.getJvmRuntimeInfo(instanceId);
        return LayUiAdminResultVo.ok(monitorJvmRuntimeVo);
    }

}

