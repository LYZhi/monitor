package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * home页的数据库信息表现层对象
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
@ApiModel(value = "home页的数据库信息表现层对象")
public class HomeDbVo implements ISuperBean {

    @ApiModelProperty(value = "数据库数量")
    private Integer dbSum;

    @ApiModelProperty(value = "数据库正常数量")
    private Integer dbConnectSum;

    @ApiModelProperty(value = "数据库断开数量")
    private Integer dbDisconnectSum;

    @ApiModelProperty(value = "数据库未知数量")
    private Integer dbUnsentSum;

    @ApiModelProperty(value = "数据库正常率")
    private String dbConnectRate;

}
