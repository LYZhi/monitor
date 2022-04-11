package com.lyzhi.monitor.common.dto;


import com.lyzhi.monitor.common.abs.AbstractInstanceBean;
import com.lyzhi.monitor.common.domain.Result;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 基础响应包
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BaseResponsePackage extends AbstractInstanceBean {

    /**
     * ID
     */
    protected String id;

    /**
     * 时间
     */
    protected Date dateTime;

    /**
     * 响应结果
     */
    protected Result result;

}
