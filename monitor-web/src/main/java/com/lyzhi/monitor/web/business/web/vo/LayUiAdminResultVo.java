package com.lyzhi.monitor.web.business.web.vo;

import com.lyzhi.monitor.common.inf.ISuperBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * LayUiAdmin响应对象
 * </p>
 *
 */
@Data
@AllArgsConstructor
@ApiModel(value = "LayUiAdmin响应对象")
public class LayUiAdminResultVo implements ISuperBean {

    /**
     * 接口状态码
     */
    @ApiModelProperty(value = "接口状态码")
    private int code;

    /**
     * 接口提示信息
     */
    @ApiModelProperty(value = "接口提示信息")
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private Object data;

    /**
     * <p>
     * 创建LayUiAdmin成功响应对象
     * </p>
     *
     * @param data 数据
     * @return LayUiAdmin响应对象
     *
     */
    public static LayUiAdminResultVo ok(Object data) {
        return new LayUiAdminResultVo(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    /**
     * <p>
     * 创建LayUiAdmin失败响应对象
     * </p>
     *
     * @param exp 异常信息
     * @return LayUiAdmin响应对象
     *
     */
    public static LayUiAdminResultVo fail(Object exp) {
        return LayUiAdminResultVo.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exp);
    }

    /**
     * <p>
     * 创建LayUiAdmin失败响应对象
     * </p>
     *
     * @param code 接口状态
     * @param msg  接口提示信息
     * @param exp  异常信息
     * @return LayUiAdmin响应对象
     *
     */
    public static LayUiAdminResultVo fail(int code, String msg, Object exp) {
        return new LayUiAdminResultVo(code, msg, exp);
    }

}
