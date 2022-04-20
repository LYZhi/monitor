package com.lyzhi.monitor.web.business.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.common.constant.DateTimeStylesEnums;
import com.lyzhi.monitor.common.constant.ZeroOrOneConstants;
import com.lyzhi.monitor.common.util.DateTimeUtils;
import com.lyzhi.monitor.web.business.web.dao.IMonitorNetHistoryDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorNetHistory;
import com.lyzhi.monitor.web.business.web.service.IMonitorNetHistoryService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.NetworkAvgTimeChartVo;
import com.lyzhi.monitor.web.constant.TimeSelectConstants;
import com.lyzhi.monitor.web.constant.WebResponseConstants;
import com.lyzhi.monitor.web.core.CalculateDateTime;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 网络信息历史记录服务实现类
 * </p>
 *
 */
@Service
public class MonitorNetHistoryServiceImpl extends ServiceImpl<IMonitorNetHistoryDao, MonitorNetHistory> implements IMonitorNetHistoryService {

    /**
     * <p>
     * 获取PING耗时图表信息
     * </p>
     *
     * @param id        网络ID
     * @param ipSource  IP地址（来源）
     * @param ipTarget  IP地址（目的地）
     * @param dateValue 时间
     * @return layUiAdmin响应对象
     *
     */
    @Override
    public NetworkAvgTimeChartVo getAvgTimeChartInfo(Long id, String ipSource, String ipTarget, String dateValue) {
        LambdaQueryWrapper<MonitorNetHistory> monitorNetHistoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        monitorNetHistoryLambdaQueryWrapper.eq(MonitorNetHistory::getNetId, id);
        monitorNetHistoryLambdaQueryWrapper.eq(MonitorNetHistory::getIpSource, ipSource);
        monitorNetHistoryLambdaQueryWrapper.eq(MonitorNetHistory::getIpTarget, ipTarget);
        monitorNetHistoryLambdaQueryWrapper.between(MonitorNetHistory::getInsertTime,
                DateTimeUtils.string2Date(dateValue, DateTimeStylesEnums.YYYY_MM_DD),
                DateUtil.offsetDay(DateTimeUtils.string2Date(dateValue, DateTimeStylesEnums.YYYY_MM_DD), 1));
        List<MonitorNetHistory> monitorNetHistories = this.baseMapper.selectList(monitorNetHistoryLambdaQueryWrapper);
        // 返回值
        NetworkAvgTimeChartVo networkAvgTimeChartVo = new NetworkAvgTimeChartVo();
        List<NetworkAvgTimeChartVo.All> allList = Lists.newArrayList();
        List<NetworkAvgTimeChartVo.OffLine> offLineList = Lists.newArrayList();
        for (MonitorNetHistory monitorNetHistory : monitorNetHistories) {
            // 所有
            NetworkAvgTimeChartVo.All all = new NetworkAvgTimeChartVo.All();
            all.setAvgTime(monitorNetHistory.getAvgTime());
            all.setInsertTime(monitorNetHistory.getInsertTime());
            allList.add(all);
            // 离线
            if (ZeroOrOneConstants.ZERO.equals(monitorNetHistory.getStatus())) {
                NetworkAvgTimeChartVo.OffLine offLine = new NetworkAvgTimeChartVo.OffLine();
                offLine.setAvgTime(monitorNetHistory.getAvgTime());
                offLine.setInsertTime(monitorNetHistory.getInsertTime());
                offLineList.add(offLine);
            }
        }
        networkAvgTimeChartVo.setAllList(allList);
        networkAvgTimeChartVo.setOffLineList(offLineList);
        return networkAvgTimeChartVo;
    }

    /**
     * <p>
     * 清理网络监控历史数据
     * </p>
     *
     * @param id   网络ID
     * @param time 时间
     * @return layUiAdmin响应对象：如果清理成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @Override
    public LayUiAdminResultVo clearMonitorNetworkHistory(String id, String time) {
        // 时间为空
        if (StringUtils.isBlank(time)) {
            return LayUiAdminResultVo.ok(WebResponseConstants.REQUIRED_IS_NULL);
        }
        CalculateDateTime calculateDateTime = new CalculateDateTime(time).invoke();
        // 清理时间
        Date clearTime = calculateDateTime.getStartTime();
        // 清理所有时间点的数据，相当于清理当前时间前的数据
        if (StringUtils.equalsIgnoreCase(time, TimeSelectConstants.ALL)) {
            clearTime = new Date();
        }
        LambdaUpdateWrapper<MonitorNetHistory> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(MonitorNetHistory::getNetId, id);
        lambdaUpdateWrapper.lt(MonitorNetHistory::getInsertTime, clearTime);
        this.baseMapper.delete(lambdaUpdateWrapper);
        return LayUiAdminResultVo.ok(WebResponseConstants.SUCCESS);
    }

}
