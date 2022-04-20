package com.lyzhi.monitor.web.business.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * TCP连接耗时图表信息表现层对象
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
@ApiModel(value = "TCP连接耗时图表信息表现层对象")
public class TcpAvgTimeChartVo implements ISuperBean {

    @ApiModelProperty(value = "所有列表")
    private List<All> allList;

    @ApiModelProperty(value = "离线列表")
    private List<OffLine> offLineList;

    /**
     * <p>
     * 所有
     * </p>
     *
     *
     */
    @ApiModel(value = "所有")
    @Data
    public static class All {

        @ApiModelProperty(value = "平均响应时间（毫秒）")
        private Long avgTime;

        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        @ApiModelProperty(value = "新增时间")
        private Date insertTime;
    }

    /**
     * <p>
     * 离线
     * </p>
     *
     *
     */
    @ApiModel(value = "离线")
    @Data
    public static class OffLine {

        @ApiModelProperty(value = "平均响应时间（毫秒）")
        private Long avgTime;

        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
        @ApiModelProperty(value = "新增时间")
        private Date insertTime;
    }

}
