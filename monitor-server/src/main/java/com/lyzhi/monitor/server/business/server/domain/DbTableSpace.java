package com.lyzhi.monitor.server.business.server.domain;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据库表空间
 * </p>
 *
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DbTableSpace extends AbstractSuperBean {

    /**
     * 表空间
     */
    private String tablespaceName;

    /**
     * 总空间
     */
    private String total;

    /**
     * 使用空间
     */
    private String used;

    /**
     * 剩余空间
     */
    private String free;

    /**
     * 表空间使用率
     */
    private Double usedRate;

    /**
     * 表空间剩余率
     */
    private Double freeRate;

}
