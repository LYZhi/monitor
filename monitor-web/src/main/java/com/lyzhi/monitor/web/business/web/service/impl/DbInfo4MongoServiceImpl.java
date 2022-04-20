package com.lyzhi.monitor.web.business.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.client.core.core.Sender;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.util.DataSizeUtil;
import com.lyzhi.monitor.web.business.web.dao.IMonitorDbDao;
import com.lyzhi.monitor.web.business.web.entity.MonitorDb;
import com.lyzhi.monitor.web.business.web.service.IDbInfo4MongoService;
import com.lyzhi.monitor.web.business.web.vo.DbInfo4MongoVo;
import com.lyzhi.monitor.web.constant.UrlConstants;
import com.lyzhi.monitor.web.core.PackageConstructor;
import com.google.common.collect.Lists;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * Mongo数据库信息服务实现类
 * </p>
 *
 */
@Service
public class DbInfo4MongoServiceImpl implements IDbInfo4MongoService {

    /**
     * 数据库表数据访问对象
     */
    @Autowired
    private IMonitorDbDao monitorDbDao;

    /**
     * <p>
     * 获取Mongo信息列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param id      数据库ID
     * @return 简单分页模型
     * @throws IOException    IO异常
     * @throws SigarException Sigar异常
     *
     */
    @Override
    public Page<DbInfo4MongoVo> getMongoInfoList(Long current, Long size, Long id) throws IOException, SigarException {
        // 根据ID查询到此数据库信息
        MonitorDb monitorDb = this.monitorDbDao.selectById(id);
        // url
        String url = monitorDb.getUrl();
        // 封装请求数据
        JSONObject extraMsg = new JSONObject();
        extraMsg.put("url", url);
        BaseRequestPackage baseRequestPackage = new PackageConstructor().structureBaseRequestPackage();
        baseRequestPackage.setExtraMsg(extraMsg);
        // 从服务端获取数据
        String resultStr = Sender.send(UrlConstants.MONGO_GET_MONGO_INFO_LIST, baseRequestPackage.toJsonString());
        BaseResponsePackage baseResponsePackage = JSON.parseObject(resultStr, BaseResponsePackage.class);
        Result result = baseResponsePackage.getResult();
        String msg = result.getMsg();
        List<JSONObject> jsonObjects = JSON.parseArray(msg, JSONObject.class);
        // 解析数据
        List<DbInfo4MongoVo> dbInfo4MongoVos = Lists.newArrayList();
        for (JSONObject object : jsonObjects) {
            BigDecimal avgObjSizeBigDecimal = object.getBigDecimal("avgObjSize");
            String avgObjSize = avgObjSizeBigDecimal == null ? null : DataSizeUtil.format(avgObjSizeBigDecimal.doubleValue());
            Integer collections = object.getInteger("collections");
            BigDecimal dataSizeBigDecimal = object.getBigDecimal("dataSize");
            String dataSize = dataSizeBigDecimal == null ? null : DataSizeUtil.format(dataSizeBigDecimal.doubleValue());
            String db = object.getString("db");
            BigDecimal fsTotalSizeBigDecimal = object.getBigDecimal("fsTotalSize");
            String fsTotalSize = fsTotalSizeBigDecimal == null ? null : DataSizeUtil.format(fsTotalSizeBigDecimal.doubleValue());
            BigDecimal fsUsedSizeBigDecimal = object.getBigDecimal("fsUsedSize");
            String fsUsedSize = fsUsedSizeBigDecimal == null ? null : DataSizeUtil.format(fsUsedSizeBigDecimal.doubleValue());
            BigDecimal indexSizeBigDecimal = object.getBigDecimal("indexSize");
            String indexSize = indexSizeBigDecimal == null ? null : DataSizeUtil.format(indexSizeBigDecimal.doubleValue());
            Integer indexes = object.getInteger("indexes");
            Integer objects = object.getInteger("objects");
            BigDecimal ok = object.getBigDecimal("ok");
            BigDecimal scaleFactor = object.getBigDecimal("scaleFactor");
            BigDecimal storageSizeBigDecimal = object.getBigDecimal("storageSize");
            String storageSize = storageSizeBigDecimal == null ? null : DataSizeUtil.format(storageSizeBigDecimal.doubleValue());
            BigDecimal totalSizeBigDecimal = object.getBigDecimal("totalSize");
            String totalSize = totalSizeBigDecimal == null ? null : DataSizeUtil.format(totalSizeBigDecimal.doubleValue());
            Integer views = object.getInteger("views");
            DbInfo4MongoVo dbInfo4MongoVo = DbInfo4MongoVo.builder().build();
            dbInfo4MongoVo.setAvgObjSize(avgObjSize);
            dbInfo4MongoVo.setCollections(collections);
            dbInfo4MongoVo.setDataSize(dataSize);
            dbInfo4MongoVo.setDb(db);
            dbInfo4MongoVo.setFsTotalSize(fsTotalSize);
            dbInfo4MongoVo.setFsUsedSize(fsUsedSize);
            dbInfo4MongoVo.setIndexSize(indexSize);
            dbInfo4MongoVo.setIndexes(indexes);
            dbInfo4MongoVo.setObjects(objects);
            dbInfo4MongoVo.setOk(ok);
            dbInfo4MongoVo.setScaleFactor(scaleFactor);
            dbInfo4MongoVo.setStorageSize(storageSize);
            dbInfo4MongoVo.setTotalSize(totalSize);
            dbInfo4MongoVo.setViews(views);
            dbInfo4MongoVos.add(dbInfo4MongoVo);
        }
        // 设置返回对象
        Page<DbInfo4MongoVo> dbInfo4MongoVoPage = new Page<>();
        dbInfo4MongoVoPage.setRecords(dbInfo4MongoVos);
        dbInfo4MongoVoPage.setTotal(dbInfo4MongoVos.size());
        dbInfo4MongoVoPage.setCurrent(current);
        dbInfo4MongoVoPage.setSize(size);
        return dbInfo4MongoVoPage;
    }

}
