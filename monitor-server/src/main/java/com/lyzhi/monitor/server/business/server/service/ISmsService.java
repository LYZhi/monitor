package com.lyzhi.monitor.server.business.server.service;

import com.lyzhi.monitor.server.business.server.domain.Sms;

/**
 * <p>
 * 短信服务接口
 * </p>
 *
 */
public interface ISmsService {

    /**
     * <p>
     * 发送告警模板短信
     * </p>
     *
     * @param sms 短信实体对象
     * @return boolean
     *
     */
    boolean sendAlarmTemplateSms(Sms sms);

}
