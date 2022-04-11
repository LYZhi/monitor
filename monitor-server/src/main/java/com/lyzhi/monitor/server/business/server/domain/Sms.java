package com.lyzhi.monitor.server.business.server.domain;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;

/**
 * <p>
 * 短信实体对象
 * </p>
 *
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Sms extends AbstractSuperBean {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 接收人手机号码
     */
    private String[] phones;

    /**
     * 告警级别
     */
    private String level;

}
