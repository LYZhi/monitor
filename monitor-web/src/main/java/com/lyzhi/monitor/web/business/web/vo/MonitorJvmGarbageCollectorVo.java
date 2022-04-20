package com.lyzhi.monitor.web.business.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lyzhi.monitor.common.inf.ISuperBean;
import com.lyzhi.monitor.web.business.web.entity.MonitorJvmGarbageCollector;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <p>
 * java虚拟机GC信息表现层对象
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
@ApiModel(value = "java虚拟机GC信息表现层对象")
public class MonitorJvmGarbageCollectorVo implements ISuperBean {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "应用实例ID")
    private String instanceId;

    @ApiModelProperty(value = "内存管理器序号")
    private Integer garbageCollectorNo;

    @ApiModelProperty(value = "内存管理器名称")
    private String garbageCollectorName;

    @ApiModelProperty(value = "GC总次数")
    private String collectionCount;

    @ApiModelProperty(value = "GC总时间（毫秒）")
    private String collectionTime;

    @ApiModelProperty(value = "新增时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insertTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * <p>
     * MonitorJvmGarbageCollectorVo转MonitorJvmGarbageCollector
     * </p>
     *
     * @return {@link MonitorJvmGarbageCollector}
     *
     */
    public MonitorJvmGarbageCollector convertTo() {
        MonitorJvmGarbageCollector monitorJvmGarbageCollector = MonitorJvmGarbageCollector.builder().build();
        BeanUtils.copyProperties(this, monitorJvmGarbageCollector);
        return monitorJvmGarbageCollector;
    }

    /**
     * <p>
     * MonitorJvmGarbageCollector转MonitorJvmGarbageCollectorVo
     * </p>
     *
     * @param monitorJvmGarbageCollector {@link MonitorJvmGarbageCollector}
     * @return {@link MonitorJvmGarbageCollectorVo}
     *
     */
    public MonitorJvmGarbageCollectorVo convertFor(MonitorJvmGarbageCollector monitorJvmGarbageCollector) {
        if (null != monitorJvmGarbageCollector) {
            BeanUtils.copyProperties(monitorJvmGarbageCollector, this);
        }
        return this;
    }

}
