package com.lyzhi.monitor.server.business.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lyzhi.monitor.common.constant.ResultMsgConstants;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;
import com.lyzhi.monitor.server.business.server.dao.IMonitorInstanceDao;
import com.lyzhi.monitor.server.business.server.entity.MonitorInstance;
import com.lyzhi.monitor.server.business.server.service.IHeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 心跳服务实现。
 * </p>
 * 把应用实例添加或者更新到数据库。
 *
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class HeartbeatServiceImpl implements IHeartbeatService {

    /**
     * 应用实例数据访问对象
     */
    @Autowired
    private IMonitorInstanceDao monitorInstanceDao;

    /**
     * <p>
     * 处理心跳包
     * </p>
     *
     * @param heartbeatPackage 心跳包
     * @return {@link Result}
     *
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public Result dealHeartbeatPackage(HeartbeatPackage heartbeatPackage) {
        // 把应用实例添加或者更新到数据库
        this.operateMonitorInstance(heartbeatPackage);
        // 返回结果
        return Result.builder().isSuccess(true).msg(ResultMsgConstants.SUCCESS).build();
    }

    /**
     * <p>
     * 把应用实例添加或者更新到数据库
     * </p>
     *
     * @param heartbeatPackage 心跳包
     *
     */
    private void operateMonitorInstance(HeartbeatPackage heartbeatPackage) {
        String instanceId = heartbeatPackage.getInstanceId();
        // 查询数据库中有没有当前应用实例
        LambdaQueryWrapper<MonitorInstance> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorInstance::getInstanceId, instanceId);
        Integer selectCountDb = this.monitorInstanceDao.selectCount(lambdaQueryWrapper);
        // 封装对象
        MonitorInstance entity = new MonitorInstance();
        entity.setInstanceId(instanceId);
        entity.setInstanceName(heartbeatPackage.getInstanceName());
        entity.setInstanceDesc(heartbeatPackage.getInstanceDesc());
        entity.setEndpoint(heartbeatPackage.getInstanceEndpoint());
        entity.setIp(heartbeatPackage.getIp());
        entity.setConnFrequency((int) heartbeatPackage.getRate());
        entity.setLanguage(heartbeatPackage.getInstanceLanguage());
        entity.setAppServerType(heartbeatPackage.getAppServerType().getName());
        // 插入记录
        if (selectCountDb == null || selectCountDb == 0) {
            entity.setInsertTime(new Date());
            entity.setOfflineCount(0);
            this.monitorInstanceDao.insert(entity);
        }
        // 更新记录
        else {
            entity.setUpdateTime(new Date());
            LambdaUpdateWrapper<MonitorInstance> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(MonitorInstance::getInstanceId, instanceId);
            this.monitorInstanceDao.update(entity, lambdaUpdateWrapper);
        }
    }

}
