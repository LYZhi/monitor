package com.lyzhi.monitor.web.business.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.entity.MonitorNet;
import com.lyzhi.monitor.web.business.web.service.IMonitorNetService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorNetVo;
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
 * 网络
 * </p>
 *
 */
@Controller
@RequestMapping("/monitor-network")
@Api(tags = "网络")
public class MonitorNetworkController {

    /**
     * 网络信息服务类
     */
    @Autowired
    private IMonitorNetService monitorNetService;

    /**
     * <p>
     * 访问网络列表页面
     * </p>
     *
     * @return {@link ModelAndView} 网络列表页面
     *
     */
    @ApiOperation(value = "访问网络列表页面")
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("network/network");
        // 源IP
        mv.addObject("ipSource", this.monitorNetService.getSourceIp());
        return mv;
    }

    /**
     * <p>
     * 获取网络列表
     * </p>
     *
     * @param current  当前页
     * @param size     每页显示条数
     * @param ipSource IP地址（来源）
     * @param ipTarget IP地址（目的地）
     * @param status   状态（0：网络不通，1：网络正常）
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取网络列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "ipSource", value = "IP地址（来源）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "ipTarget", value = "IP地址（目的地）", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "status", value = "状态（0：网络不通，1：网络正常）", paramType = "query", dataType = "string", dataTypeClass = String.class)})
    @GetMapping("/get-monitor-network-list")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.NET, operType = OperateTypeConstants.QUERY, operDesc = "获取网络列表")
    public LayUiAdminResultVo getMonitorNetList(Long current, Long size, String ipSource, String ipTarget, String status) {
        Page<MonitorNetVo> page = this.monitorNetService.getMonitorNetList(current, size, ipSource, ipTarget, status);
        return LayUiAdminResultVo.ok(page);
    }

    /**
     * <p>
     * 删除网络
     * </p>
     *
     * @param monitorNetVos 网络信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "删除网络")
    @DeleteMapping("/delete-monitor-network")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.NET, operType = OperateTypeConstants.DELETE, operDesc = "删除网络")
    public LayUiAdminResultVo deleteMonitorNet(@RequestBody List<MonitorNetVo> monitorNetVos) {
        return this.monitorNetService.deleteMonitorNet(monitorNetVos);
    }

    /**
     * <p>
     * 访问编辑网络信息表单页面
     * </p>
     *
     * @param id 网络ID
     * @return {@link ModelAndView} 编辑网络信息表单页面
     *
     */
    @ApiOperation(value = "访问编辑网络信息表单页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "网络ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/edit-monitor-network-form")
    public ModelAndView editMonitorNetworkForm(@RequestParam(name = "id") Long id) {
        MonitorNet monitorNet = this.monitorNetService.getById(id);
        MonitorNetVo monitorNetVo = MonitorNetVo.builder().build().convertFor(monitorNet);
        ModelAndView mv = new ModelAndView("network/edit-network");
        mv.addObject(monitorNetVo);
        return mv;
    }

    /**
     * <p>
     * 访问新增网络信息表单页面
     * </p>
     *
     * @return {@link ModelAndView} 新增网络信息表单页面
     *
     */
    @ApiOperation(value = "访问新增网络信息表单页面")
    @GetMapping("/add-monitor-network-form")
    public ModelAndView addMonitorNetworkForm() {
        return new ModelAndView("network/add-network");
    }

    /**
     * <p>
     * 编辑网络信息
     * </p>
     *
     * @param monitorNetVo 网络信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "编辑网络信息")
    @PutMapping("/edit-monitor-network")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.NET, operType = OperateTypeConstants.UPDATE, operDesc = "编辑网络信息")
    public LayUiAdminResultVo editMonitorNetwork(MonitorNetVo monitorNetVo) {
        return this.monitorNetService.editMonitorNetwork(monitorNetVo);
    }

    /**
     * <p>
     * 添加网络信息
     * </p>
     *
     * @param monitorNetVo 网络信息
     * @return layUiAdmin响应对象：如果数据库中已经存在，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     * @throws NetException 自定义获取网络信息异常
     *
     */
    @ApiOperation(value = "添加网络信息")
    @PostMapping("/add-monitor-network")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.NET, operType = OperateTypeConstants.ADD, operDesc = "添加网络信息")
    public LayUiAdminResultVo addMonitorNetwork(MonitorNetVo monitorNetVo) throws NetException {
        return this.monitorNetService.addMonitorNetwork(monitorNetVo);
    }

    /**
     * <p>
     * 访问平均时间页面
     * </p>
     *
     * @param id 网络ID
     * @return {@link ModelAndView} 平均时间页面
     *
     */
    @ApiOperation(value = "访问平均时间页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "网络ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/avg-time")
    public ModelAndView avgTime(Long id) {
        MonitorNet monitorNet = this.monitorNetService.getById(id);
        MonitorNetVo monitorNetVo = MonitorNetVo.builder().build().convertFor(monitorNet);
        ModelAndView mv = new ModelAndView("network/avg-time");
        mv.addObject(monitorNetVo);
        return mv;
    }

    /**
     * <p>
     * 访问清理网络监控历史数据表单页面
     * </p>
     *
     * @param id 网络ID
     * @return {@link ModelAndView} 清理网络监控历史数据表单页面
     *
     */
    @ApiOperation(value = "访问清理网络监控历史数据表单页面")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "网络ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/network-clear")
    public ModelAndView networkClear(String id) {
        ModelAndView mv = new ModelAndView("network/network-clear-form");
        mv.addObject("id", id);
        return mv;
    }

}
