package com.lyzhi.monitor.server.business.server.core;

import cn.hutool.core.util.IdUtil;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.util.InstanceUtils;
import com.lyzhi.monitor.common.abs.AbstractPackageConstructor;
import com.lyzhi.monitor.common.constant.EndpointTypeEnums;
import com.lyzhi.monitor.common.constant.LanguageTypeConstants;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.util.AppServerDetectorUtils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.common.util.server.OsUtils;
import lombok.SneakyThrows;
import org.hyperic.sigar.SigarException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
     * 构建告警包
     * </p>
     *
     * @param alarm 告警
     * @return {@link AlarmPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    @Override
    public AlarmPackage structureAlarmPackage(Alarm alarm) throws NetException, SigarException {
        AlarmPackage alarmPackage = new AlarmPackage();
        alarmPackage.setId(IdUtil.randomUUID());
        alarmPackage.setDateTime(new Date());
        alarmPackage.setInstanceEndpoint(EndpointTypeEnums.SERVER.getNameEn());
        alarmPackage.setInstanceId(InstanceUtils.getInstanceId());
        alarmPackage.setInstanceName(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceName());
        alarmPackage.setInstanceDesc(ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceDesc());
        alarmPackage.setInstanceLanguage(LanguageTypeConstants.JAVA);
        alarmPackage.setAppServerType(AppServerDetectorUtils.getAppServerTypeEnum());
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        alarmPackage.setIp(ip);
        TreeSet<String> networkChain = new TreeSet<>();
        networkChain.add(ip);
        alarmPackage.setNetworkChain(networkChain);
        alarmPackage.setComputerName(OsUtils.getComputerName());
        // 判断字符集
        Charset charset = alarm.getCharset();
        // 设置了字符集
        if (null != charset) {
            alarm.setTitle(new String(alarm.getTitle().getBytes(charset), StandardCharsets.UTF_8));
            alarm.setMsg(new String(alarm.getMsg().getBytes(charset), StandardCharsets.UTF_8));
            alarm.setCharset(StandardCharsets.UTF_8);
        }
        alarmPackage.setAlarm(alarm);
        return alarmPackage;
    }

    /**
     * <p>
     * 构建请求基础响应包
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
        baseResponsePackage.setInstanceEndpoint(EndpointTypeEnums.SERVER.getNameEn());
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
        baseResponsePackage.setId(IdUtil.randomUUID());
        baseResponsePackage.setDateTime(new Date());
        baseResponsePackage.setResult(result);
        return baseResponsePackage;
    }

}
