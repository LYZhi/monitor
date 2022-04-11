package com.lyzhi.monitor.agent.core;

import cn.hutool.core.util.IdUtil;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.util.InstanceUtils;
import com.lyzhi.monitor.common.abs.AbstractPackageConstructor;
import com.lyzhi.monitor.common.constant.EndpointTypeEnums;
import com.lyzhi.monitor.common.constant.LanguageTypeConstants;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.util.AppServerDetectorUtils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.common.util.server.OsUtils;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.TreeSet;

/**
 * <p>
 * 包构造器
 * </p>
 *
 */
public class PackageConstructor extends AbstractPackageConstructor {

    /**
     * <p>
     * 构建请求失败的基础响应包
     * </p>
     *
     * @param result 返回结果
     * @return {@link BaseResponsePackage}
     *
     */
    @SneakyThrows
    @Override
    public BaseResponsePackage structureBaseResponsePackage(Result result) {
        BaseResponsePackage baseResponsePackage = new BaseResponsePackage();
        baseResponsePackage.setInstanceEndpoint(EndpointTypeEnums.AGENT.getNameEn());
        baseResponsePackage.setInstanceId(InstanceUtils.getInstanceId());
        baseResponsePackage.setInstanceName(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceName());
        baseResponsePackage.setInstanceDesc(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceDesc());
        baseResponsePackage.setInstanceLanguage(LanguageTypeConstants.JAVA);
        baseResponsePackage.setAppServerType(AppServerDetectorUtils.getAppServerTypeEnum());
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        baseResponsePackage.setIp(ip);
        TreeSet<String> networkChain = new TreeSet<>();
        networkChain.add(ip);
        baseResponsePackage.setNetworkChain(networkChain);
        baseResponsePackage.setComputerName(OsUtils.getComputerName());
        baseResponsePackage.setDateTime(new Date());
        baseResponsePackage.setId(IdUtil.randomUUID());
        baseResponsePackage.setResult(result);
        return baseResponsePackage;
    }

}