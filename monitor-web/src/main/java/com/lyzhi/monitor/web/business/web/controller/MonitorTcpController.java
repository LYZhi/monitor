package com.lyzhi.monitor.web.business.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.entity.MonitorTcp;
import com.lyzhi.monitor.web.business.web.service.IMonitorNetService;
import com.lyzhi.monitor.web.business.web.service.IMonitorTcpService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorTcpVo;
import com.lyzhi.monitor.web.constant.OperateTypeConstants;
import com.lyzhi.monitor.web.constant.UiModuleConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * TCP信息
 * </p>
 *
 */
@Controller
@RequestMapping("/monitor-tcp")
@Api(tags = "TCP")
public class MonitorTcpController {

    /**
     * 网络信息服务类
     */
    @Autowired
    private IMonitorNetService monitorNetService;

    /**
     * TCP信息服务类
     */
    @Autowired
    private IMonitorTcpService monitorTcpService;

    /**
     * <p>
     * 访问TCP列表页面
     * </p>
     *
     * @return {@link ModelAndView} TCP列表页面
     *
     */
    @ApiOperation(value = "访问TCP列表页面")
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("tcp/tcp");
        // 源IP
        mv.addObject("ipSource", this.monitorNetService.getSourceIp());
        return mv;
    }

    /**
     * <p>
     * 获取TCP列表
     * </p>
     *
     * @param current        当前页
     * @param size           每页显示条数
     * @param hostnameSource 主机名（来源）
     * @param hostnameTarget 主机名（目的地）
     * @param portTarget     目标端口
     * @param status         状态（0：不通，1：正常）
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取TCP列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "hostnameSource", value = "主机名（来源）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "hostnameTarget", value = "主机名（目的地）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "portTarget", value = "目标端口", paramType = "query", dataType = "int", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "status", value = "状态（0：不通，1：正常）", paramType = "query", dataType = "string", dataTypeClass = String.class)})
    @GetMapping("/get-monitor-tcp-list")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.QUERY, operDesc = "获取TCP列表")
    public LayUiAdminResultVo getMonitorTcpList(Long current, Long size, String hostnameSource, String hostnameTarget, Integer portTarget, String status) {
        Page<MonitorTcpVo> page = this.monitorTcpService.getMonitorTcpList(current, size, hostnameSource, hostnameTarget, portTarget, status);
        return LayUiAdminResultVo.ok(page);
    }

    /**
     * <p>
     * 删除TCP
     * </p>
     *
     * @param monitorTcpVos TCP信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "删除TCP")
    @DeleteMapping("/delete-monitor-tcp")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.DELETE, operDesc = "删除TCP")
    public LayUiAdminResultVo deleteMonitorTcp(@RequestBody List<MonitorTcpVo> monitorTcpVos) {
        return this.monitorTcpService.deleteMonitorTcp(monitorTcpVos);
    }

    /**
     * <p>
     * 访问新增TCP信息表单页面
     * </p>
     *
     * @return {@link ModelAndView} 新增TCP信息表单页面
     *
     */
    @ApiOperation(value = "访问新增TCP信息表单页面")
    @GetMapping("/add-monitor-tcp-form")
    public ModelAndView addMonitorTcpForm() {
        return new ModelAndView("tcp/add-tcp");
    }

    /**
     * <p>
     * 添加TCP信息
     * </p>
     *
     * @param monitorTcpVo TCP信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "添加TCP信息")
    @PostMapping("/add-monitor-tcp")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.ADD, operDesc = "添加TCP信息")
    public LayUiAdminResultVo addMonitorTcp(MonitorTcpVo monitorTcpVo) throws NetException {
        // 获取被监控TCP源IP地址，获取失败则返回null
        String sourceIp = this.monitorNetService.getSourceIp();
        monitorTcpVo.setHostnameSource(sourceIp);
        return this.monitorTcpService.addMonitorTcp(monitorTcpVo);
    }

    /**
     * <p>
     * 访问编辑TCP信息表单页面
     * </p>
     *
     * @param id TCP ID
     * @return {@link ModelAndView} 编辑TCP信息表单页面
     *
     */
    @ApiOperation(value = "访问编辑TCP信息表单页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "TCP ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/edit-monitor-tcp-form")
    public ModelAndView editMonitorTcpForm(@RequestParam(name = "id") Long id) {
        MonitorTcp monitorTcp = this.monitorTcpService.getById(id);
        MonitorTcpVo monitorTcpVo = MonitorTcpVo.builder().build().convertFor(monitorTcp);
        ModelAndView mv = new ModelAndView("tcp/edit-tcp");
        mv.addObject(monitorTcpVo);
        return mv;
    }

    /**
     * <p>
     * 编辑TCP信息
     * </p>
     *
     * @param monitorTcpVo TCP信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "编辑TCP信息")
    @PutMapping("/edit-monitor-tcp")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.TCP4SERVICE, operType = OperateTypeConstants.UPDATE, operDesc = "编辑TCP信息")
    public LayUiAdminResultVo editMonitorTcp(MonitorTcpVo monitorTcpVo) {
        // 获取被监控TCP源IP地址，获取失败则返回null
        String sourceIp = this.monitorNetService.getSourceIp();
        monitorTcpVo.setHostnameSource(sourceIp);
        return this.monitorTcpService.editMonitorTcp(monitorTcpVo);
    }

    /**
     * <p>
     * 访问平均时间页面
     * </p>
     *
     * @param id TCP ID
     * @return {@link ModelAndView} 平均时间页面
     *
     */
    @ApiOperation(value = "访问平均时间页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "TCP ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/avg-time")
    public ModelAndView avgTime(Long id) {
        MonitorTcp monitorTcp = this.monitorTcpService.getById(id);
        MonitorTcpVo monitorTcpVo = MonitorTcpVo.builder().build().convertFor(monitorTcp);
        ModelAndView mv = new ModelAndView("tcp/avg-time");
        mv.addObject(monitorTcpVo);
        return mv;
    }

    /**
     * <p>
     * 访问清理TCP服务监控历史数据表单页面
     * </p>
     *
     * @param id 网络ID
     * @return {@link ModelAndView} 清理TCP服务监控历史数据表单页面
     *
     */
    @ApiOperation(value = "访问清理TCP服务监控历史数据表单页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "网络ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/tcp-clear")
    public ModelAndView tcpClear(String id) {
        ModelAndView mv = new ModelAndView("tcp/tcp-clear-form");
        mv.addObject("id", id);
        return mv;
    }

}