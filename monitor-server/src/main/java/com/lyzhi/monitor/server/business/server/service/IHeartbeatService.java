package com.lyzhi.monitor.server.business.server.service;

import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;
import com.lyzhi.monitor.common.exception.NetException;

/**
 * <p>
 * 心跳服务接口
 * </p>
 *
 */
public interface IHeartbeatService {

    /**
     * <p>
     * 处理心跳包
     * </p>
     *
     * @param heartbeatPackage 心跳包
     * @return {@link Result}
     * @throws NetException 获取网络信息异常
     * @author 皮锋
     * @custom.date 2020/3/12 10:18
     */
    Result dealHeartbeatPackage(HeartbeatPackage heartbeatPackage) throws NetException;
}
