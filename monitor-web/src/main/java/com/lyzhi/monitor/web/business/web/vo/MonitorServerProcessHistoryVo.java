package com.lyzhi.monitor.web.business.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lyzhi.monitor.common.inf.ISuperBean;
import com.lyzhi.monitor.web.business.web.entity.MonitorServerProcessHistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <p>
 * 服务器进程历史记录表现层对象
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
@ApiModel(value = "服务器进程历史记录表现层对象")
public class MonitorServerProcessHistoryVo implements ISuperBean {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "正在运行的进程数")
    private Integer processNum;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * <p>
     * MonitorServerProcessHistoryVo转MonitorServerProcessHistory
     * </p>
     *
     * @return {@link MonitorServerProcessHistory}
     *
     */
    public MonitorServerProcessHistory convertTo() {
        MonitorServerProcessHistory monitorServerProcessHistory = MonitorServerProcessHistory.builder().build();
        BeanUtils.copyProperties(this, monitorServerProcessHistory);
        return monitorServerProcessHistory;
    }

    /**
     * <p>
     * MonitorServerProcessHistory转MonitorServerProcessHistoryVo
     * </p>
     *
     * @param monitorServerProcessHistory {@link MonitorServerProcessHistory}
     * @return {@link MonitorServerProcessHistoryVo}
     *
     */
    public MonitorServerProcessHistoryVo convertFor(MonitorServerProcessHistory monitorServerProcessHistory) {
        if (null != monitorServerProcessHistory) {
            BeanUtils.copyProperties(monitorServerProcessHistory, this);
        }
        return this;
    }
}
