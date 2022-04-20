package com.lyzhi.monitor.web.core;

import cn.hutool.core.util.IdUtil;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.util.InstanceUtils;
import com.lyzhi.monitor.common.abs.AbstractPackageConstructor;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.util.AppServerDetectorUtils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.common.util.server.OsUtils;
import org.hyperic.sigar.SigarException;

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
     * 构建基础请求包
     * </p>
     *
     * @return {@link BaseRequestPackage}
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    @Override
    public BaseRequestPackage structureBaseRequestPackage() throws NetException, SigarException {
        BaseRequestPackage baseRequestPackage = new BaseRequestPackage();
        baseRequestPackage.setId(IdUtil.randomUUID());
        baseRequestPackage.setDateTime(new Date());
        baseRequestPackage.setInstanceEndpoint(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceEndpoint());
        baseRequestPackage.setInstanceId(InstanceUtils.getInstanceId());
        baseRequestPackage.setInstanceName(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceName());
        baseRequestPackage.setInstanceDesc(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceDesc());
        baseRequestPackage.setInstanceLanguage(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceLanguage());
        baseRequestPackage.setAppServerType(AppServerDetectorUtils.getAppServerTypeEnum());
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        baseRequestPackage.setIp(ip);
        TreeSet<String> networkChain = new TreeSet<>();
        networkChain.add(ip);
        baseRequestPackage.setNetworkChain(networkChain);
        baseRequestPackage.setComputerName(OsUtils.getComputerName());
        return baseRequestPackage;
    }

}
