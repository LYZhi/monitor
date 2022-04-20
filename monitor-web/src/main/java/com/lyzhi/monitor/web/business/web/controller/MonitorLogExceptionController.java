package com.lyzhi.monitor.web.business.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.service.IMonitorLogExceptionService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorLogExceptionVo;
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
 * 异常日志
 * </p>
 *
 */
@Api(tags = "日志.异常日志")
@RestController
@RequestMapping("/monitor-log-exception")
public class MonitorLogExceptionController {

    @Autowired
    private IMonitorLogExceptionService monitorLogExceptionService;

    /**
     * <p>
     * 访问异常日志列表页面
     * </p>
     *
     * @return {@link ModelAndView} 异常日志列表页面
     *
     */
    @ApiOperation(value = "访问异常日志列表页面")
    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("log/log-exception");
    }

    /**
     * <p>
     * 获取异常日志列表
     * </p>
     *
     * @param current    当前页
     * @param size       每页显示条数
     * @param excName    异常名称
     * @param excMessage 异常信息
     * @param insertTime 插入时间
     * @return layUiAdmin响应对象
     *
     */
    @ApiOperation(value = "获取异常日志列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "excName", value = "异常名称", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "excMessage", value = "异常信息", paramType = "query", dataType = "string", dataTypeClass = String.class),
            @ApiImplicitParam(name = "insertTime", value = "插入时间", paramType = "query", dataType = "string", dataTypeClass = String.class)
    })
    @GetMapping("/get-monitor-log-exception-list")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.LOG + "#异常日志", operType = OperateTypeConstants.QUERY, operDesc = "获取异常日志列表")
    public LayUiAdminResultVo getMonitorLogExceptionList(Long current, Long size, String excName, String excMessage, String insertTime) {
        Page<MonitorLogExceptionVo> page = this.monitorLogExceptionService.getMonitorLogExceptionList(current, size, excName, excMessage, insertTime);
        return LayUiAdminResultVo.ok(page);
    }

    /**
     * <p>
     * 删除异常日志
     * </p>
     *
     * @param monitorLogExceptionVos 异常日志信息
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @ApiOperation(value = "删除异常日志")
    @DeleteMapping("/delete-monitor-log-exception")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.LOG + "#异常日志", operType = OperateTypeConstants.DELETE, operDesc = "删除异常日志")
    public LayUiAdminResultVo deleteMonitorLogException(@RequestBody List<MonitorLogExceptionVo> monitorLogExceptionVos) {
        return this.monitorLogExceptionService.deleteMonitorLogException(monitorLogExceptionVos);
    }

    /**
     * <p>
     * 访问异常日志详情页面
     * </p>
     *
     * @param id 异常日志ID
     * @return {@link ModelAndView} 异常日志详情页面
     *
     */
    @ApiOperation(value = "访问异常日志详情页面")
    @GetMapping("/monitor-log-exception-detail")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "异常日志ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    public ModelAndView monitorLogExceptionDetail(Long id) {
        ModelAndView mv = new ModelAndView("log/log-exception-detail");
        MonitorLogExceptionVo monitorLogExceptionInfo = this.monitorLogExceptionService.getMonitorLogExceptionInfo(id);
        mv.addObject("monitorLogExceptionInfo", monitorLogExceptionInfo);
        return mv;
    }

}

