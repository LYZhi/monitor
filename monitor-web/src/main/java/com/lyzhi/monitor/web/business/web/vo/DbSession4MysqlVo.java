package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * MySQL数据库会话表现层对象
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
@ApiModel(value = "MySQL数据库会话表现层对象")
public class DbSession4MysqlVo implements ISuperBean {

    @ApiModelProperty(value = "进程ID")
    private Long id;

    @ApiModelProperty(value = "用户")
    private String user;

    @ApiModelProperty(value = "主机")
    private String host;

    @ApiModelProperty(value = "数据库")
    private String db;

    @ApiModelProperty(value = "命令")
    private String command;

    @ApiModelProperty(value = "时间")
    private String time;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "活动查询")
    private String info;

}
