package com.lyzhi.monitor.common.dto;

import com.alibaba.fastjson.JSONObject;
import com.lyzhi.monitor.common.abs.AbstractInstanceBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 基础请求包
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BaseRequestPackage extends AbstractInstanceBean {

    /**
     * ID
     */
    protected String id;

    /**
     * 时间
     */
    protected Date dateTime;

    /**
     * 附加信息
     */
    protected JSONObject extraMsg;

}
