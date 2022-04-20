package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.service.IMonitorTcpHistoryService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.TcpAvgTimeChartVo;
import com.lyzhi.monitor.web.constant.OperateTypeConstants;
import com.lyzhi.monitor.web.constant.UiModuleConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * TCP信息历史记录 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/monitor-tcp-history")
@Api(tags = "TCP.TCP历史记录")
public class MonitorTcpHistoryController {

    /**
     * TCP信息历史记录服务类
     */
    @Autowired
    private IMonitorTcpHistoryService monitorTcpHistoryService;

    /**
     * <p>
     * 获取Telnet耗时图表信息
     * </p>
     *
     * @param id             TCP ID
     * @param hostnameSource 主机名（来源）
     * @param hostnameTarget 主机名（目的地）
     * @param portTarget     端口号
     * @param dateValue      时间
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取Telnet耗时图表信息")
    @ResponseBody
    @GetMapping("/get-avg-time-chart-info")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "TCP ID", paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "hostnameSource", value = "主机名（来源）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "hostnameTarget", value = "主机名（目的地）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "portTarget", value = "端口号", paramType = "query", dataType = "int", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "dateValue", value = "时间", paramType = "query", dataType = "string", dataTypeClass = String.class)})
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.QUERY, operDesc = "获取Telnet耗时图表信息")
    public LayUiAdminResultVo getAvgTimeChartInfo(@RequestParam(name = "id") Long id,
                                                  @RequestParam(name = "hostnameSource") String hostnameSource,
                                                  @RequestParam(name = "hostnameTarget") String hostnameTarget,
                                                  @RequestParam(name = "portTarget") Integer portTarget,
                                                  @RequestParam(name = "dateValue") String dateValue) {
        TcpAvgTimeChartVo tcpAvgTimeChartVo = this.monitorTcpHistoryService
                .getAvgTimeChartInfo(id, hostnameSource, hostnameTarget, portTarget, dateValue);
        return LayUiAdminResultVo.ok(tcpAvgTimeChartVo);
    }

    /**
     * <p>
     * 清理TCP监控历史数据
     * </p>
     *
     * @param id   TCP ID
     * @param time 时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "清理TCP监控历史数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "TCP ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "time", value = "时间", required = true, paramType = "query", dataType = "string", dataTypeClass = String.class)})
    @DeleteMapping("/clear-monitor-tcp-history")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.DELETE, operDesc = "清理TCP监控历史数据")
    public LayUiAdminResultVo clearMonitorTcpHistory(String id, String time) {
        return this.monitorTcpHistoryService.clearMonitorTcpHistory(id, time);
    }

}

