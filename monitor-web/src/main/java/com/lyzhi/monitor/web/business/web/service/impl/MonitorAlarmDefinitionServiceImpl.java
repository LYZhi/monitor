package com.lyzhi.monitor.web.business.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyzhi.monitor.web.business.web.dao.IMonitorAlarmDefinitionDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorAlarmDefinition;
import com.lyzhi.monitor.web.business.web.service.IMonitorAlarmDefinitionService;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorAlarmDefinitionVo;
import com.lyzhi.monitor.web.constant.WebResponseConstants;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 告警定义服务实现类
 * </p>
 *
 */
@Service
public class MonitorAlarmDefinitionServiceImpl extends ServiceImpl<IMonitorAlarmDefinitionDao, MonitorAlarmDefinition> implements IMonitorAlarmDefinitionService {

    /**
     * 告警定义数据访问对象
     */
    @Autowired
    private IMonitorAlarmDefinitionDao monitorAlarmDefinitionDao;

    /**
     * <p>
     * 获取告警定义列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param type    告警类型
     * @param grade   告警级别
     * @param title   告警标题
     * @param content 告警内容
     * @return 分页Page对象
     *
     */
    @Override
    public Page<MonitorAlarmDefinitionVo> getMonitorAlarmDefinitionList(Long current, Long size, String type, String grade, String title, String content) {
        // 查询数据库
        IPage<MonitorAlarmDefinition> iPage = new Page<>(current, size);
        LambdaQueryWrapper<MonitorAlarmDefinition> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(type)) {
            lambdaQueryWrapper.eq(MonitorAlarmDefinition::getType, type);
        }
        if (StringUtils.isNotBlank(grade)) {
            lambdaQueryWrapper.eq(MonitorAlarmDefinition::getGrade, grade);
        }
        if (StringUtils.isNotBlank(title)) {
            lambdaQueryWrapper.like(MonitorAlarmDefinition::getTitle, title);
        }
        if (StringUtils.isNotBlank(content)) {
            lambdaQueryWrapper.like(MonitorAlarmDefinition::getContent, content);
        }
        IPage<MonitorAlarmDefinition> monitorAlarmDefinitionPage = this.monitorAlarmDefinitionDao.selectPage(iPage, lambdaQueryWrapper);
        List<MonitorAlarmDefinition> monitorAlarmDefinitions = monitorAlarmDefinitionPage.getRecords();
        // 转换成监控告警表现层对象
        List<MonitorAlarmDefinitionVo> monitorAlarmDefinitionVos = Lists.newLinkedList();
        for (MonitorAlarmDefinition monitorAlarmDefinition : monitorAlarmDefinitions) {
            MonitorAlarmDefinitionVo monitorAlarmDefinitionVo = MonitorAlarmDefinitionVo.builder().build().convertFor(monitorAlarmDefinition);
            monitorAlarmDefinitionVos.add(monitorAlarmDefinitionVo);
        }
        Page<MonitorAlarmDefinitionVo> monitorAlarmDefinitionVoPage = new Page<>();
        monitorAlarmDefinitionVoPage.setRecords(monitorAlarmDefinitionVos);
        monitorAlarmDefinitionVoPage.setTotal(monitorAlarmDefinitionPage.getTotal());
        return monitorAlarmDefinitionVoPage;
    }

    /**
     * <p>
     * 添加告警定义
     * </p>
     *
     * @param monitorAlarmDefinitionVo 告警定义
     * @return layUiAdmin响应对象：如果数据库中已经有此告警定义，LayUiAdminResultVo.data="exist"；
     * 如果添加成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @Override
    public LayUiAdminResultVo saveMonitorAlarmDefinition(MonitorAlarmDefinitionVo monitorAlarmDefinitionVo) {
        // 根据告警code查询数据库，判断数据库中是否已经有此code的告警定义
        LambdaQueryWrapper<MonitorAlarmDefinition> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MonitorAlarmDefinition::getCode, monitorAlarmDefinitionVo.getCode());
        MonitorAlarmDefinition dbMonitorAlarmDefinition = this.monitorAlarmDefinitionDao.selectOne(lambdaQueryWrapper);
        if (dbMonitorAlarmDefinition != null) {
            return LayUiAdminResultVo.ok(WebResponseConstants.EXIST);
        }
        // 添加告警定义
        MonitorAlarmDefinition monitorAlarmDefinition = monitorAlarmDefinitionVo.convertTo();
        monitorAlarmDefinition.setInsertTime(new Date());
        int result = this.monitorAlarmDefinitionDao.insert(monitorAlarmDefinition);
        if (result == 1) {
            return LayUiAdminResultVo.ok(WebResponseConstants.SUCCESS);
        }
        return LayUiAdminResultVo.ok(WebResponseConstants.FAIL);
    }

    /**
     * <p>
     * 编辑告警定义
     * </p>
     *
     * @param monitorAlarmDefinitionVo 告警定义
     * @return layUiAdmin响应对象：如果编辑成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @Override
    public LayUiAdminResultVo editMonitorAlarmDefinition(MonitorAlarmDefinitionVo monitorAlarmDefinitionVo) {
        MonitorAlarmDefinition monitorAlarmDefinition = monitorAlarmDefinitionVo.convertTo();
        monitorAlarmDefinition.setUpdateTime(new Date());
        int result = this.monitorAlarmDefinitionDao.updateById(monitorAlarmDefinition);
        if (result == 1) {
            return LayUiAdminResultVo.ok(WebResponseConstants.SUCCESS);
        }
        return LayUiAdminResultVo.ok(WebResponseConstants.FAIL);
    }

    /**
     * <p>
     * 删除告警定义
     * </p>
     *
     * @param monitorAlarmDefinitionVos 告警定义
     * @return layUiAdmin响应对象：如果删除成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    @Override
    public LayUiAdminResultVo deleteMonitorAlarmDefinition(List<MonitorAlarmDefinitionVo> monitorAlarmDefinitionVos) {
        int size = monitorAlarmDefinitionVos.size();
        List<Long> ids = Lists.newLinkedList();
        for (MonitorAlarmDefinitionVo monitorAlarmDefinitionVo : monitorAlarmDefinitionVos) {
            ids.add(monitorAlarmDefinitionVo.getId());
        }
        int result = this.monitorAlarmDefinitionDao.deleteBatchIds(ids);
        if (result == size) {
            return LayUiAdminResultVo.ok(WebResponseConstants.SUCCESS);
        }
        return LayUiAdminResultVo.ok(WebResponseConstants.FAIL);
    }

}
