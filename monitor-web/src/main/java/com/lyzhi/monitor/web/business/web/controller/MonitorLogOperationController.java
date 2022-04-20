package com.lyzhi.monitor.web.business.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.service.IMonitorLogOperationService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorLogOperationVo;
import com.lyzhi.monitor.web.constant.OperateTypeConstants;
import com.lyzhi.monitor.web.constant.UiModuleConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 操作日志
 * </p>
 *
 */
@Api(tags = "日志.操作日志")
@RestController
@RequestMapping("/monitor-log-operation")
public class MonitorLogOperationController {

    /**
     * 操作日志服务类
     */
    @Autowired
    private IMonitorLogOperationService monitorLogOperationService;

    /**
     * <p>
     * 访问操作日志列表页面
     * </p>
     *
     * @return {@link ModelAndView} 操作日志列表页面
     *
     */
    @ApiOperation(value = "访问操作日志列表页面")
    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("log/log-operation");
    }

    /**
     * <p>
     * 获取操作日志列表
     * </p>
     *
     * @param current    当前页
     * @param size       每页显示条数
     * @param operModule 功能模块
     * @param operDesc   操作描述
     * @param operType   操作类型
     * @param insertTime 插入时间
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取操作日志列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "operModule", value = "功能模块", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "operDesc", value = "操作描述", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "operType", value = "操作类型", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "insertTime", value = "插入时间", paramType = "query", dataType = "string", dataTypeClass = String.class)
    })
    @GetMapping("/get-monitor-log-operation-list")
    @ResponseBody
    // @OperateLog(operModule = UiModuleConstants.LOG + "#操作日志", operType = OperateTypeConstants.QUERY, operDesc = "获取操作日志列表")
    public LayUiAdminResultVo getMonitorLogOperationList(Long current, Long size, String operModule, String operDesc, String operType, String insertTime) {
        Page<MonitorLogOperationVo> page = this.monitorLogOperationService.getMonitorLogOperationList(current, size, operModule, operDesc, operType, insertTime);
        return LayUiAdminResultVo.ok(page);
    }

    /**
     * <p>
     * 删除操作日志
     * </p>
     *
     * @param monitorLogOperationVos 操作日志信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "删除操作日志")
    @DeleteMapping("/delete-monitor-log-operation")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.LOG + "#操作日志", operType = OperateTypeConstants.DELETE, operDesc = "删除操作日志")
    public LayUiAdminResultVo deleteMonitorLogOperation(@RequestBody List<MonitorLogOperationVo> monitorLogOperationVos) {
        return this.monitorLogOperationService.deleteMonitorLogOperation(monitorLogOperationVos);
    }

    /**
     * <p>
     * 访问操作日志详情页面
     * </p>
     *
     * @param id 操作日志ID
     * @return {@link ModelAndView} 操作日志详情页面
     *
     */
    @ApiOperation(value = "访问操作日志详情页面")
    @GetMapping("/monitor-log-operation-detail")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "操作日志ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    public ModelAndView monitorLogOperationDetail(Long id) {
        ModelAndView mv = new ModelAndView("log/log-operation-detail");
        MonitorLogOperationVo monitorLogOperationInfo = this.monitorLogOperationService.getMonitorLogOperationInfo(id);
        mv.addObject("monitorLogOperationInfo", monitorLogOperationInfo);
        return mv;
    }

}

