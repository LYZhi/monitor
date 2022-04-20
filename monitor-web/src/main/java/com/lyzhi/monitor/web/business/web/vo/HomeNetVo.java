package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * home页的网络信息表现层对象
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
@ApiModel(value = "home页的网络信息表现层对象")
public class HomeNetVo implements ISuperBean {

    @ApiModelProperty(value = "网络数量")
    private Integer netSum;

    @ApiModelProperty(value = "网络正常数量")
    private Integer netConnectSum;

    @ApiModelProperty(value = "网络断开数量")
    private Integer netDisconnectSum;

    @ApiModelProperty(value = "网络未知数量")
    private Integer netUnsentSum;

    @ApiModelProperty(value = "网络正常率")
    private String netConnectRate;

}
