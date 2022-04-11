package com.lyzhi.monitor.common.domain;


import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 返回结果
 * </p>
 *
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public final class Result extends AbstractSuperBean {

    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 结果信息
     */
    private String msg;

}
