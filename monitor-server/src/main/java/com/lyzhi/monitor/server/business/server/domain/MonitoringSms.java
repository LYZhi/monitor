package com.lyzhi.monitor.server.business.server.domain;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;

/**
 * <p>
 * monitoring短信实体对象
 * </p>
 *
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringSms extends AbstractSuperBean {

    /**
     * 手机号码，多个手机号码用英文分号隔开
     */
    private String phone;

    /**
     * 短信类型
     */
    private String type;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 身份
     */
    private String identity;

}
