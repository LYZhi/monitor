package com.lyzhi.monitor.server.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.ServerPackage;
import com.lyzhi.monitor.server.business.server.entity.MonitorServer;

import java.util.Date;

/**
 * <p>
 * 服务器信息服务层接口
 * </p>
 *
 */
public interface IServerService extends IService<MonitorServer> {

    /**
     * <p>
     * 处理服务器信息包
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link Result}
     *
     */
    Result dealServerPackage(ServerPackage serverPackage);

    /**
     * <p>
     * 清理服务器历史记录
     * </p>
     *
     * @param historyTime 时间点，清理这个时间点以前的数据
     * @return 清理记录数
     *
     */
    int clearHistoryData(Date historyTime);
}
