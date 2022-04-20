package com.lyzhi.monitor.web.business.web.service.impl;

import cn.hutool.core.io.unit.DataSizeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorServerProcessDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerProcess;
import com.lyzhi.monitor.web.business.web.service.IMonitorServerProcessService;
import com.lyzhi.monitor.web.business.web.vo.MonitorServerProcessVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务器进程服务实现类
 * </p>
 *
 */
@Service
public class MonitorServerProcessServiceImpl extends ServiceImpl<IMonitorServerProcessDao, MonitorServerProcess> implements IMonitorServerProcessService {

    /**
     * 服务器进程信息数据访问对象
     */
    @Autowired
    private IMonitorServerProcessDao monitorServerProcessDao;

    /**
     * <p>
     * 获取服务器详情页面服务器进程信息
     * </p>
     *
     * @param ip 服务器IP地址
     * @return 服务器进程表现层对象
     *
     */
    @Override
    public List<MonitorServerProcessVo> getServerDetailPageServerProcessInfo(String ip) {
        LambdaQueryWrapper<MonitorServerProcess> monitorServerProcessLambdaQueryWrapper = new LambdaQueryWrapper<>();
        monitorServerProcessLambdaQueryWrapper.eq(MonitorServerProcess::getIp, ip);
        List<MonitorServerProcess> monitorServerProcesses = this.monitorServerProcessDao.selectList(monitorServerProcessLambdaQueryWrapper);
        // 设置返回值
        List<MonitorServerProcessVo> monitorServerProcessVos = Lists.newArrayList();
        for (MonitorServerProcess monitorServerProcess : monitorServerProcesses) {
            MonitorServerProcessVo monitorServerProcessVo = MonitorServerProcessVo.builder().build().convertFor(monitorServerProcess);
            // 占用内存大小（智能转换单位后的大小）
            monitorServerProcessVo.setMemorySizeStr(DataSizeUtil.format(monitorServerProcessVo.getMemorySize()));
            monitorServerProcessVos.add(monitorServerProcessVo);
        }
        return monitorServerProcessVos;
    }

}
