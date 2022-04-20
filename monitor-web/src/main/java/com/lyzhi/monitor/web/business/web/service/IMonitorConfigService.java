package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.entity.MonitorConfig;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorConfigPageFormVo;
import org.hyperic.sigar.SigarException;

/**
 * <p>
 * 监控配置服务类
 * </p>
 *
 */
public interface IMonitorConfigService extends IService<MonitorConfig> {

    /**
     * <p>
     * 获取监控配置页面表单信息
     * </p>
     *
     * @return 监控配置页面表单对象
     *
     */
    MonitorConfigPageFormVo getMonitorConfigPageFormInfo();

    /**
     * <p>
     * 更新监控配置
     * </p>
     *
     * @param monitorConfigPageFormVo 监控配置页面表单对象
     * @return layUiAdmin响应对象：如果更新数据库成功，LayUiAdminResultVo.data="success"；<br>
     * 如果更新数据库成功，但是更新监控服务端配置失败，LayUiAdminResultVo.data="refreshFail"；<br>
     * 否则，LayUiAdminResultVo.data="fail"。
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    LayUiAdminResultVo update(MonitorConfigPageFormVo monitorConfigPageFormVo) throws NetException, SigarException;

}
