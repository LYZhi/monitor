package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.constant.EnterpriseEnums;
import com.lyzhi.monitor.common.constant.ProtocolTypeEnums;
import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 告警短信配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringAlarmSmsProperties implements ISuperBean {

    /**
     * 手机号码
     */
    private String[] phoneNumbers;

    /**
     * 接口地址
     */
    private String address;

    /**
     * 接口协议
     */
    private ProtocolTypeEnums protocolTypeEnum;

    /**
     * 接口所属企业
     */
    private EnterpriseEnums enterpriseEnum;

}
