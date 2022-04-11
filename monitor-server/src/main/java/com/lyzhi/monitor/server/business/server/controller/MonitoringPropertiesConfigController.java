package com.lyzhi.monitor.server.business.server.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.constant.ResultMsgConstants;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.server.business.server.core.MonitoringConfigPropertiesLoader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 监控属性配置控制器
 * </p>
 *
 */
@Slf4j
@RestController
@RequestMapping("/monitoring-properties-config")
@Api(tags = "监控属性配置")
public class MonitoringPropertiesConfigController {

    /**
     * 监控配置属性加载器
     */
    @Autowired
    private MonitoringConfigPropertiesLoader monitoringConfigPropertiesLoader;

    /**
     * <p>
     * 刷新监控配置属性
     * </p>
     *
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "刷新监控配置属性", notes = "刷新监控配置属性")
    @PostMapping("/refresh")
    public BaseResponsePackage refresh() {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        this.monitoringConfigPropertiesLoader.wakeUpMonitoringConfigPropertiesLoader();
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(Result.builder().isSuccess(true).msg(ResultMsgConstants.SUCCESS).build());
        // 时间差（毫秒）
        String betweenDay = timer.intervalPretty();
        if (timer.intervalSecond() > 1) {
            log.warn("刷新监控配置属性耗时：{}", betweenDay);
        }
        return baseResponsePackage;
    }

}
