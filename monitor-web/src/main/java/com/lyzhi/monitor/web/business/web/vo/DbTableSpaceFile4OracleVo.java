package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * Oracle数据库表空间表现层对象(按文件)
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
@ApiModel(value = "Oracle数据库表空间表现层对象(按文件)")
public class DbTableSpaceFile4OracleVo implements ISuperBean {

    @ApiModelProperty(value = "文件ID")
    private Long fileId;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "表空间")
    private String tablespaceName;

    @ApiModelProperty(value = "表空间大小")
    private String total;

    @ApiModelProperty(value = "表空间使用大小")
    private String used;

    @ApiModelProperty(value = "表空间剩余大小")
    private String free;

    @ApiModelProperty(value = "使用百分比")
    private Double usedPer;

    @ApiModelProperty(value = "剩余百分比")
    private Double freePer;

}
