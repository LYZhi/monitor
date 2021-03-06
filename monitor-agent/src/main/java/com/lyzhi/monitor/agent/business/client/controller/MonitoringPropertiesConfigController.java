package com.lyzhi.monitor.agent.business.client.controller;

import com.lyzhi.monitor.agent.business.client.service.IBaseRequestPackageService;
import com.lyzhi.monitor.agent.constant.UrlConstants;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 监控属性配置控制器
 * </p>
 *
 */
@Api(tags = "监控属性配置")
@RestController
@RequestMapping("/monitoring-properties-config")
public class MonitoringPropertiesConfigController {

    /**
     * 基础请求包服务接口
     */
    @Autowired
    private IBaseRequestPackageService baseRequestPackageService;

    /**
     * <p>
     * 刷新监控配置属性
     * </p>
     *
     * @param baseRequestPackage 基础请求包
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "刷新监控配置属性", notes = "刷新监控配置属性")
    @PostMapping("/refresh")
    public BaseResponsePackage refresh(@RequestBody BaseRequestPackage baseRequestPackage) {
        return this.baseRequestPackageService.dealBaseRequestPackage(baseRequestPackage, UrlConstants.MONITORING_PROPERTIES_CONFIG_REFRESH_URL);
    }

}
