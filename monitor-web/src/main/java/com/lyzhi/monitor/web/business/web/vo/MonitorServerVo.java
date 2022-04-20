package com.lyzhi.monitor.web.business.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lyzhi.monitor.common.inf.ISuperBean;
import com.lyzhi.monitor.web.business.web.entity.MonitorServer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <p>
 * 服务器信息表现层对象
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
@ApiModel(value = "服务器信息表现层对象")
public class MonitorServerVo implements ISuperBean {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "服务器名")
    private String serverName;

    @ApiModelProperty(value = "服务器摘要")
    private String serverSummary;

    @ApiModelProperty(value = "服务器状态（0：离线，1：在线）")
    private String isOnline;

    @ApiModelProperty(value = "离线次数")
    private Integer offlineCount;

    @ApiModelProperty(value = "连接频率")
    private Integer connFrequency;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "操作系统名称")
    private String osName;

    @ApiModelProperty(value = "CPU使用率")
    private Double cpuUserPercent;

    @ApiModelProperty(value = "内存使用率")
    private Double menUsedPercent;

    @ApiModelProperty(value = "下行带宽")
    private String downloadBps;

    @ApiModelProperty(value = "上行带宽")
    private String uploadBps;

    @ApiModelProperty(value = "监控环境")
    private String monitorEnv;

    @ApiModelProperty(value = "监控分组")
    private String monitorGroup;

    /**
     * <p>
     * MonitorServerVo转MonitorServer
     * </p>
     *
     * @return {@link MonitorServer}
     *
     */
    public MonitorServer convertTo() {
        MonitorServer monitorServer = MonitorServer.builder().build();
        BeanUtils.copyProperties(this, monitorServer);
        return monitorServer;
    }

    /**
     * <p>
     * MonitorServer转MonitorServerVo
     * </p>
     *
     * @param monitorServer {@link MonitorServer}
     * @return {@link MonitorServerVo}
     *
     */
    public MonitorServerVo convertFor(MonitorServer monitorServer) {
        if (null != monitorServer) {
            BeanUtils.copyProperties(monitorServer, this);
        }
        return this;
    }

}
