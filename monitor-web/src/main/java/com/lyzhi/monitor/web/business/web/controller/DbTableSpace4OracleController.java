package com.lyzhi.monitor.web.business.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.annotation.OperateLog;
import com.lyzhi.monitor.web.business.web.service.IDbTableSpace4OracleService;
import com.lyzhi.monitor.web.business.web.vo.DbTableSpaceAll4OracleVo;
import com.lyzhi.monitor.web.business.web.vo.DbTableSpaceFile4OracleVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.constant.OperateTypeConstants;
import com.lyzhi.monitor.web.constant.UiModuleConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * <p>
 * Oracle数据库表空间
 * </p>
 *
 */
@Controller
@Api(tags = "数据库表空间.Oracle")
@RequestMapping("/db-tablespace4oracle")
public class DbTableSpace4OracleController {

    /**
     * Oracle数据库表空间服务类
     */
    @Autowired
    private IDbTableSpace4OracleService dbTableSpace4OracleService;

    /**
     * <p>
     * 获取表空间列表(按文件)
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param id      数据库ID
     * @return layUiAdmin响应对象
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     * @throws IOException    IO异常
     *
     */
    @ApiOperation(value = "获取表空间列表(按文件)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "id", value = "数据库ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/get-tablespace-list-file")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.DATABASE + "#表空间", operType = OperateTypeConstants.QUERY, operDesc = "获取表空间列表(按文件)")
    public LayUiAdminResultVo getTableSpaceListFile(Long current, Long size, Long id) throws NetException, IOException, SigarException {
        Page<DbTableSpaceFile4OracleVo> page = this.dbTableSpace4OracleService.getTableSpaceListFile(current, size, id);
        return LayUiAdminResultVo.ok(page);
    }

    /**
     * <p>
     * 获取表空间列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param id      数据库ID
     * @return layUiAdmin响应对象
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     * @throws IOException    IO异常
     *
     */
    @ApiOperation(value = "获取表空间列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "id", value = "数据库ID", required = true, paramType = "query", dataType = "long", dataTypeClass = Long.class)})
    @GetMapping("/get-tablespace-list-all")
    @ResponseBody
    @OperateLog(operModule = UiModuleConstants.DATABASE + "#表空间", operType = OperateTypeConstants.QUERY, operDesc = "获取表空间列表")
    public LayUiAdminResultVo getTableSpaceListAll(Long current, Long size, Long id) throws NetException, IOException, SigarException {
        Page<DbTableSpaceAll4OracleVo> page = this.dbTableSpace4OracleService.getTableSpaceListAll(current, size, id);
        return LayUiAdminResultVo.ok(page);
    }

}
