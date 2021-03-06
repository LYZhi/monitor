package com.lyzhi.monitor.server.business.server.monitor;

import com.lyzhi.monitor.server.business.server.service.IJvmService;
import com.lyzhi.monitor.server.business.server.service.IServerService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 在项目启动后，定时清理数据库历史记录表数据。
 * </p>
 *
 */
@Slf4j
@Component
@Order(6)
public class ClearHistoryDataJob extends QuartzJobBean {

    /**
     * java虚拟机信息服务层接口
     */
    @Autowired
    private IJvmService jvmService;

    /**
     * 服务器信息服务层接口
     */
    @Autowired
    private IServerService serverService;

    /**
     * 扫描数据库所有历史记录表，清理一星期以前的历史记录。
     *
     * @param jobExecutionContext 作业执行上下文
     *
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        try {
            // 清理一星期以前的数据
            Date historyTime = new DateTime().plusWeeks(-1).toDate();
            int clearJvmHistoryDataNum = this.jvmService.clearHistoryData(historyTime);
            log.info("清理JVM历史数据：{} 条！", clearJvmHistoryDataNum);
            int clearServerHistoryDataNum = this.serverService.clearHistoryData(historyTime);
            log.info("清理服务器历史数据：{} 条！", clearServerHistoryDataNum);
        } catch (Exception e) {
            log.error("清理历史数据出错！", e);
        }
    }

}
