package com.lyzhi.monitor.web.business.web.controller;


import com.lyzhi.monitor.web.business.web.service.IMonitorJvmGarbageCollectorService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmGarbageCollectorVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * java虚拟机GC信息
 * </p>
 *
 */
@Api(tags = "应用程序.java虚拟机GC信息")
@RestController
@RequestMapping("/monitor-jvm-garbage-collector")
public class MonitorJvmGarbageCollectorController {

    /**
     * java虚拟机GC信息服务类
     */
    @Autowired
    private IMonitorJvmGarbageCollectorService monitorJvmGarbageCollectorService;

    /**
     * <p>
     * 获取java虚拟机GC信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取java虚拟机GC信息")
    @ResponseBody
    @GetMapping("/get-jvm-gc-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "instanceId", value = "应用实例ID", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getJvmGcInfo(@RequestParam(name = "instanceId") String instanceId) {
        List<MonitorJvmGarbageCollectorVo> monitorJvmGarbageCollectorVos = this.monitorJvmGarbageCollectorService.getJvmGcInfo(instanceId);
        return LayUiAdminResultVo.ok(monitorJvmGarbageCollectorVos);
    }

}

