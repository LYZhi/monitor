package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.web.business.web.vo.DbSession4MysqlVo;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import org.hyperic.sigar.SigarException;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * MySQL数据库会话服务类
 * </p>
 *
 */
public interface IDbSession4MysqlService {

    /**
     * <p>
     * 获取会话列表
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param id      数据库ID
     * @return 简单分页模型
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     * @throws IOException    IO异常
     *
     */
    Page<DbSession4MysqlVo> getSessionList(Long current, Long size, Long id) throws NetException, SigarException, IOException;

    /**
     * <p>
     * 结束会话
     * </p>
     *
     * @param dbSession4MysqlVos MySQL数据库会话
     * @param id                 数据库ID
     * @return LayUiAdmin响应对象
     * @throws NetException   自定义获取网络信息异常
     * @throws SigarException Sigar异常
     * @throws IOException    IO异常
     *
     */
    LayUiAdminResultVo destroySession(List<DbSession4MysqlVo> dbSession4MysqlVos, Long id) throws NetException, SigarException, IOException;

}
