package com.lyzhi.monitor.web.business.web.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorServerPowerSourcesDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerPowerSources;
import com.lyzhi.monitor.web.business.web.service.IMonitorServerPowerSourcesService;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerPowerSourcesVo;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务器电池服务实现类
 * </p>
 *
 */
@Service
public class MonitorServerPowerSourcesServiceImpl extends ServiceImpl<IMonitorServerPowerSourcesDao, MonitorServerPowerSources> implements IMonitorServerPowerSourcesService {

    /**
     * 服务器电池数据访问对象
     */
    @Autowired
    private IMonitorServerPowerSourcesDao monitorServerPowerSourcesDao;

    /**
     * <p>
     * 获取服务器详情页面服务器电池信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器电池信息表现层对象
     *
     */
    @Override
    public List<MonitorServerPowerSourcesVo> getServerDetailPageServerPowerSourcesInfo(String ip) {
        LambdaQueryWrapper<MonitorServerPowerSources> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorServerPowerSources::getIp, ip);
        List<MonitorServerPowerSources> monitorServerPowerSourcesList = this.monitorServerPowerSourcesDao.selectList(lambdaQueryWrapper);
        // 返回值
        List<MonitorServerPowerSourcesVo> result = Lists.newLinkedList();
        for (MonitorServerPowerSources powerSources : monitorServerPowerSourcesList) {
            MonitorServerPowerSourcesVo powerSourcesVo = MonitorServerPowerSourcesVo.builder().build().convertFor(powerSources);
            result.add(powerSourcesVo);
        }
        return result;
    }

    /**
     * <p>
     * 获取电池平均剩余容量百分比
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 电池平均剩余容量百分比
     *
     */
    @Override
    public Double getRemainingCapacityPercentAvg(String ip) {
        LambdaQueryWrapper<MonitorServerPowerSources> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 查询字段
        lambdaQueryWrapper.select(MonitorServerPowerSources::getRemainingCapacityPercent);
        // 查询条件
        lambdaQueryWrapper.eq(MonitorServerPowerSources::getIp, ip);
        List<Object> remainingCapacityPercents = this.monitorServerPowerSourcesDao.selectObjs(lambdaQueryWrapper);
        if (CollectionUtils.isNotEmpty(remainingCapacityPercents)) {
            // 求和
            double sum = 0D;
            for (Object obj : remainingCapacityPercents) {
                if (obj != null) {
                    double remainingCapacityPercent = Double.parseDouble(obj.toString()) * 100D;
                    sum += remainingCapacityPercent;
                }
            }
            return NumberUtil.round(sum / remainingCapacityPercents.size(), 4).doubleValue();
        }
        return Double.NaN;
    }

}
