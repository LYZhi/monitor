package com.lyzhi.monitor.web.business.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 首页
 * </p>
 *
 */
@Controller
@Api(tags = "首页")
public class IndexController {

    /**
     * <p>
     * 访问首页
     * </p>
     *
     * @return {@link ModelAndView} 首页
     *
     */
    @ApiOperation(value = "访问首页")
    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
