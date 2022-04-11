package com.lyzhi.monitor.common.inf;

import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.*;
import com.lyzhi.monitor.common.exception.NetException;
import org.hyperic.sigar.SigarException;

/**
 * 包构造器接口
 */
public interface IPackageConstructor {

    /**
     * <p>
     * 构造告警数据包
     * </p>
     *
     * @param alarm 告警信息
     * @return {@link AlarmPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     */
    AlarmPackage structureAlarmPackage(Alarm alarm) throws NetException, SigarException;

    /**
     * <p>
     * 构建心跳数据包
     * </p>
     *
     * @return {@link HeartbeatPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     */
    HeartbeatPackage structureHeartbeatPackage() throws NetException, SigarException;

    /**
     * <p>
     * 构建服务器数据包
     * </p>
     *
     * @return {@link ServerPackage}
     * @throws SigarException Sigar异常
     * @throws NetException   获取网络信息异常
     */
    ServerPackage structureServerPackage() throws SigarException, NetException;

    /**
     * <p>
     * 构建Java虚拟机信息包
     * </p>
     *
     * @return {@link JvmPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     */
    JvmPackage structureJvmPackage() throws NetException, SigarException;

    /**
     * <p>
     * 构建请求基础响应包
     * </p>
     *
     * @param result 返回结果
     * @return {@link BaseResponsePackage}
     */
    BaseResponsePackage structureBaseResponsePackage(Result result);

    /**
     * <p>
     * 构建基础请求包
     * </p>
     *
     * @return {@link BaseRequestPackage}
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     */
    BaseRequestPackage structureBaseRequestPackage() throws NetException, SigarException;

}
