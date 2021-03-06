package com.lyzhi.monitor.web.business.web.controller;


import com.lyzhi.monitor.web.business.web.service.IMonitorJvmThreadService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorJvmThreadVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * java虚拟机线程信息
 * </p>
 *
 */
@Api(tags = "应用程序.java虚拟机线程信息")
@RestController
@RequestMapping("/monitor-jvm-thread")
public class MonitorJvmThreadController {

    /**
     * java虚拟机线程信息服务类
     */
    @Autowired
    private IMonitorJvmThreadService monitorJvmThreadService;

    /**
     * <p>
     * 获取java虚拟机线程信息
     * </p>
     *
     * @param instanceId 应用实例ID
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取java虚拟机线程信息")
    @ResponseBody
    @GetMapping("/get-jvm-thread-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "instanceId", value = "应用实例ID", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getJvmThreadInfo(@RequestParam(name = "instanceId") String instanceId) {
        MonitorJvmThreadVo monitorJvmThreadVo = this.monitorJvmThreadService.getJvmThreadInfo(instanceId);
        return LayUiAdminResultVo.ok(monitorJvmThreadVo);
    }

}

