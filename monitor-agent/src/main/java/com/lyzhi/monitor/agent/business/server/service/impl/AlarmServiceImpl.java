package com.lyzhi.monitor.agent.business.server.service.impl;

import com.lyzhi.monitor.agent.business.server.service.IAlarmService;
import com.lyzhi.monitor.agent.business.server.service.IHttpService;
import com.lyzhi.monitor.agent.constant.UrlConstants;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

/**
 * <p>
 * 跟服务端相关的告警服务实现类
 * </p>
 *
 */
@Service
public class AlarmServiceImpl implements IAlarmService {

    /**
     * 跟服务端相关的HTTP服务接口
     */
    @Autowired
    private IHttpService httpService;

    /**
     * <p>
     * 给服务端发告警包
     * </p>
     *
     * @param alarmPackage 告警包
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @Override
    public BaseResponsePackage sendAlarmPackage(AlarmPackage alarmPackage) throws Exception {
        // IP地址
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        // 请求包地址链中添加当前IP地址
        TreeSet<String> requestNetworkChain = alarmPackage.getNetworkChain();
        requestNetworkChain.add(ip);
        alarmPackage.setNetworkChain(requestNetworkChain);
        BaseResponsePackage baseResponsePackage = this.httpService.sendHttpPost(alarmPackage.toJsonString(), UrlConstants.ALARM_URL);
        // 响应包地址链中添加当前IP地址
        TreeSet<String> responseNetworkChain = baseResponsePackage.getNetworkChain();
        responseNetworkChain.add(ip);
        baseResponsePackage.setNetworkChain(responseNetworkChain);
        return baseResponsePackage;
    }

}
