package com.lyzhi.monitor.server.business.server.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.server.business.server.service.IDbInfo4MongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * Mongo数据库信息
 * </p>
 *
 */
@Slf4j
@RestController
@Api(tags = "数据库信息.Mongo")
@RequestMapping("/db-info4mongo")
public class DbInfo4MongoServiceController {

    /**
     * Mongo数据库信息服务类
     */
    @Autowired
    private IDbInfo4MongoService dbInfo4MongoService;

    /**
     * <p>
     * 获取Mongo信息列表
     * </p>
     *
     * @param baseRequestPackage 基础请求包
     * @return {@link BaseResponsePackage}
     *
     */
    @ApiOperation(value = "获取Mongo信息列表")
    @PostMapping("/get-mongo-info-list")
    public BaseResponsePackage getMongoInfoList(@RequestBody BaseRequestPackage baseRequestPackage) {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        JSONObject extraMsg = baseRequestPackage.getExtraMsg();
        String url = extraMsg.getString("url");
        List<JSONObject> entities = this.dbInfo4MongoService.getMongoInfoList(url);
        String jsonString = JSON.toJSONString(entities);
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(Result.builder().isSuccess(true).msg(jsonString).build());
        // 时间差（毫秒）
        String betweenDay = timer.intervalPretty();
        if (timer.intervalSecond() > 1) {
            log.warn("获取Mongo信息列表耗时：{}", betweenDay);
        }
        return baseResponsePackage;
    }

}
