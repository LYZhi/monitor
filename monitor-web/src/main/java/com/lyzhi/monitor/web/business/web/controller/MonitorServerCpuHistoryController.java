package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.service.IMonitorServerCpuHistoryService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.ServerDetailPageServerCpuChartVo;
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

import java.util.List;

/**
 * <p>
 * 服务器CPU历史记录
 * </p>
 *
 */
@Api(tags = "服务器.服务器CPU历史记录")
@Controller
@RequestMapping("/monitor-server-cpu-history")
public class MonitorServerCpuHistoryController {

    /**
     * 服务器CPU历史记录服务类
     */
    @Autowired
    private IMonitorServerCpuHistoryService monitorServerCpuHistoryService;

    /**
     * <p>
     * 获取服务器详情页面服务器CPU图表信息
     * </p>
     *
     * @param ip   服务器IP地址
     * @param time 时间
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取服务器详情页面服务器CPU图表信息")
    @ResponseBody
    @GetMapping("/get-server-detail-page-server-cpu-chart-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ip", value = "服务器IP地址", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "time", value = "时间", paramType = "query", dataType = "string", dataTypeClass = String.class)})
    public LayUiAdminResultVo getServerDetailPageServerCpuChartInfo(@RequestParam(name = "ip") String ip,
                                                                    @RequestParam(name = "time", required = false) String time) {
        List<ServerDetailPageServerCpuChartVo> monitorServerCpuChartVos = this.monitorServerCpuHistoryService.getServerDetailPageServerCpuChartInfo(ip, time);
        return LayUiAdminResultVo.ok(monitorServerCpuChartVos);
    }

}

