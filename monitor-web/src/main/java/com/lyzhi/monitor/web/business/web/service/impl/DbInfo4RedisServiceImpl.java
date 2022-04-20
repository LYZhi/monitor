package com.lyzhi.monitor.web.business.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.client.core.core.Sender;
import com.lyzhi.monitor.web.business.web.dao.IMonitorDbDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorDb;
import com.lyzhi.monitor.web.business.web.service.IDbInfo4RedisService;
import com.lyzhi.monitor.web.constant.UrlConstants;
import com.lyzhi.monitor.web.core.PackageConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>
 * Redis数据库信息服务类
 * </p>
 *
 */
@Service
public class DbInfo4RedisServiceImpl implements IDbInfo4RedisService {

    /**
     * 数据库表数据访问对象
     */
    @Autowired
    private IMonitorDbDao monitorDbDao;

    /**
     * <p>
     * 获取Redis信息
     * </p>
     *
     * @param id 数据库ID
     * @return Redis信息
     * @throws IOException    IO异常
     * @throws SigarException Sigar异常
     *
     */
    @Override
    public String getRedisInfo(Long id) throws SigarException, IOException {
        // 根据ID查询到此数据库信息
        MonitorDb monitorDb = this.monitorDbDao.selectById(id);
        // url
        String url = monitorDb.getUrl();
        String[] address = StringUtils.split(url, ":");
        // 主机
        String host = address[0];
        // 端口
        int port = Integer.parseInt(address[1]);
        // 密码
        String password = monitorDb.getPassword();
        // 封装请求数据
        JSONObject extraMsg = new JSONObject();
        extraMsg.put("host", host);
        extraMsg.put("port", port);
        extraMsg.put("password", password);
        BaseRequestPackage baseRequestPackage = new PackageConstructor().structureBaseRequestPackage();
        baseRequestPackage.setExtraMsg(extraMsg);
        // 从服务端获取数据
        String resultStr = Sender.send(UrlConstants.REDIS_GET_REDIS_INFO, baseRequestPackage.toJsonString());
        BaseResponsePackage baseResponsePackage = JSON.parseObject(resultStr, BaseResponsePackage.class);
        Result result = baseResponsePackage.getResult();
        return result.getMsg();
    }
}
