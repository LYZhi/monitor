package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * home页的TCP信息表现层对象
 * </p>
 *
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "home页的TCP信息表现层对象")
public class HomeTcpVo implements ISuperBean {

    @ApiModelProperty(value = "TCP数量")
    private Integer tcpSum;

    @ApiModelProperty(value = "TCP正常数量")
    private Integer tcpConnectSum;

    @ApiModelProperty(value = "TCP断开数量")
    private Integer tcpDisconnectSum;

    @ApiModelProperty(value = "TCP未知数量")
    private Integer tcpUnsentSum;

    @ApiModelProperty(value = "TCP正常率")
    private String tcpConnectRate;

}