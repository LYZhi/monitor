package com.lyzhi.monitor.common.abs;

import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.*;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.inf.IPackageConstructor;
import org.hyperic.sigar.SigarException;

/**
 * <p>
 * 包构造器抽象类，提供对包构造器接口方法的默认实现。
 * </p>
 *
 */
public class AbstractPackageConstructor implements IPackageConstructor {
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
    @Override
    public AlarmPackage structureAlarmPackage(Alarm alarm) throws NetException, SigarException {
        return null;
    }

    /**
     * <p>
     * 构建心跳数据包
     * </p>
     *
     * @return {@link HeartbeatPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常

     */
    @Override
    public HeartbeatPackage structureHeartbeatPackage() throws NetException, SigarException {
        return null;
    }

    /**
     * <p>
     * 构建服务器数据包
     * </p>
     *
     * @return {@link ServerPackage}
     * @throws SigarException Sigar异常
     * @throws NetException   获取网络信息异常

     */
    @Override
    public ServerPackage structureServerPackage() throws SigarException, NetException {
        return null;
    }

    /**
     * <p>
     * 构建Java虚拟机信息包
     * </p>
     *
     * @return {@link JvmPackage}
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常

     */
    @Override
    public JvmPackage structureJvmPackage() throws NetException, SigarException {
        return null;
    }

    /**
     * <p>
     * 构建请求基础响应包
     * </p>
     *
     * @param result 返回结果
     * @return {@link BaseResponsePackage}

     */
    @Override
    public BaseResponsePackage structureBaseResponsePackage(Result result) {
        return null;
    }

    /**
     * <p>
     * 构建基础请求包
     * </p>
     *
     * @return {@link BaseRequestPackage}
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常

     */
    @Override
    public BaseRequestPackage structureBaseRequestPackage() throws NetException, SigarException {
        return null;
    }

}
