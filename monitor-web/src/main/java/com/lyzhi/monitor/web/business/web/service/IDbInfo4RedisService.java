package com.lyzhi.monitor.web.business.web.service;

import org.hyperic.sigar.SigarException;

import java.io.IOException;

/**
 * <p>
 * Redis数据库信息服务类
 * </p>
 *
 */
public interface IDbInfo4RedisService {

    /**
     * <p>
     * 获取Redis信息
     * </p>
     *
     * @param id 数据库ID
     * @return Redis信息
     * @throws IOException    IO异常
     * @throws SigarException Sigar异常
     *
     */
    String getRedisInfo(Long id) throws SigarException, IOException;
}
