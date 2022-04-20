package com.lyzhi.monitor.web.business.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lyzhi.monitor.common.inf.ISuperBean;
import com.lyzhi.monitor.web.business.web.entity.MonitorRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <p>
 * 监控用户角色表现层对象
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
@ApiModel(value = "监控用户角色表现层对象")
public class MonitorRoleVo implements ISuperBean {

    @ApiModelProperty(value = "角色ID")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * <p>
     * MonitorRoleVo转MonitorRole
     * </p>
     *
     * @return {@link MonitorRole}
     *
     */
    public MonitorRole convertTo() {
        MonitorRole monitorRole = MonitorRole.builder().build();
        BeanUtils.copyProperties(this, monitorRole);
        return monitorRole;
    }

    /**
     * <p>
     * MonitorRole转MonitorRoleVo
     * </p>
     *
     * @param monitorRole {@link MonitorRole}
     * @return {@link MonitorRoleVo}
     *
     */
    public MonitorRoleVo convertFor(MonitorRole monitorRole) {
        if (null != monitorRole) {
            BeanUtils.copyProperties(monitorRole, this);
        }
        return this;
    }

}
