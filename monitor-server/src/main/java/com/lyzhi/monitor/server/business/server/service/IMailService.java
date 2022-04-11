package com.lyzhi.monitor.server.business.server.service;

import com.lyzhi.monitor.server.business.server.domain.Mail;

/**
 * <p>
 * 邮箱服务接口
 * </p>
 *
 */
public interface IMailService {

    /**
     * <p>
     * 发送HTML告警模板邮件
     * </p>
     *
     * @param mail 邮件实体对象
     * @return boolean
     *
     */
    boolean sendAlarmTemplateMail(Mail mail);

}
