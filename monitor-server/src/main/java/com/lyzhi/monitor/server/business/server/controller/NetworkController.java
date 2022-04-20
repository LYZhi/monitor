package com.lyzhi.monitor.server.business.server.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.server.business.server.core.PackageConstructor;
import com.lyzhi.monitor.server.business.server.service.INetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 网络信息控制器
 * </p>
 *
 */
@Slf4j
@RestController
@RequestMapping("/network")
@Api(tags = "网络信息")
public class NetworkController {

    /**
     * 网络信息服务接口
     */
    @Autowired
    private INetService netService;

    /**
     * <p>
     * 获取被监控网络源IP地址
     * </p>
     *
     * @return {@link BaseResponsePackage}
     * @throws NetException 自定义获取网络信息异常
     *
     */
    @ApiOperation(value = "获取被监控网络源IP地址", notes = "获取被监控网络源IP地址")
    @PostMapping("/get-source-ip")
    public BaseResponsePackage getSourceIp() throws NetException {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        String ipSource = this.netService.getSourceIp();
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(Result.builder().isSuccess(true).msg(ipSource).build());
        // 时间差（毫秒）
        String betweenDay = timer.intervalPretty();
        if (timer.intervalSecond() > 1) {
            log.warn("获取被监控网络源IP地址耗时：{}", betweenDay);
        }
        return baseResponsePackage;
    }

}
