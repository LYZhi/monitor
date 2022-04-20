package com.lyzhi.monitor.web.business.web.controller;

import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.constant.OperateTypeConstants;
import com.lyzhi.monitor.web.constant.UiModuleConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 登录
 * </p>
 *
 */
@Controller
@Api(tags = "登录")
public class LoginController {

    /**
     * <p>
     * 访问登录页面
     * </p>
     *
     * @return {@link ModelAndView} 登录页面
     *
     */
    @ApiOperation(value = "访问登录页面")
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    /**
     * <p>
     * 登录成功重定向到首页
     * </p>
     *
     * @return 重定向首页URL
     *
     */
    @ApiOperation(value = "登录成功重定向到首页")
    @GetMapping("/login-success")
    @OperateLog(operModule = UiModuleConstants.LOGIN, operType = OperateTypeConstants.LOGIN, operDesc = "用户成功登录")
    public String loginSuccess() {
        return "redirect:index";
    }

    /**
     * <p>
     * 退出登录成功重定向到首页
     * </p>
     *
     * @return 重定向首页URL
     *
     */
    @ApiOperation(value = "退出登录成功重定向到首页")
    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "redirect:index";
    }

}
