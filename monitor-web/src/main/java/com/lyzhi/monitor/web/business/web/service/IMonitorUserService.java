package com.lyzhi.monitor.web.business.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.exception.NotFoundUserException;
import com.lyzhi.monitor.web.business.web.entity.MonitorUser;
import com.lyzhi.monitor.web.business.web.realm.MonitorUserRealm;
import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import com.lyzhi.monitor.web.business.web.vo.MonitorUserVo;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * <p>
 * 监控用户服务类
 * </p>
 *
 */
public interface IMonitorUserService extends IService<MonitorUser>, AuthenticationUserDetailsService<CasAssertionAuthenticationToken>, UserDetailsService {

    /**
     * <p>
     * 获取用户权限信息
     * </p>
     *
     * @param monitorUser 监控用户
     * @return 用户权限信息
     *
     */
    List<GrantedAuthority> getGrantedAuthorities(MonitorUser monitorUser);

    /**
     * <p>
     * 根据条件获取监控用户域
     * </p>
     *
     * @param ids 用户主键ID
     * @return {@link MonitorUserRealm}
     * @throws NotFoundUserException 找不到用户异常
     *
     */
    List<MonitorUserRealm> getMonitorUserRealms(List<Long> ids) throws NotFoundUserException;

    /**
     * <p>
     * 修改密码
     * </p>
     *
     * @param oldPassword 原始密码
     * @param password    新密码
     * @return LayUiAdmin响应对象：如果原始密码校验失败，LayUiAdminResultVo.data="verifyFail"；
     * 如果修改密码成功，LayUiAdminResultVo.data="success"；
     * 否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo updatePassword(String oldPassword, String password);

    /**
     * <p>
     * 修改当前用户信息
     * </p>
     *
     * @param monitorUserVo 用户信息
     * @return LayUiAdmin响应对象：如果修改用户信息成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo updateUser(MonitorUserVo monitorUserVo);

    /**
     * <p>
     * 获取监控用户列表
     * </p>
     *
     * @param current  当前页
     * @param size     每页显示条数
     * @param account  账号
     * @param username 用户名
     * @param email    电子邮箱
     * @return 分页Page对象
     *
     */
    Page<MonitorUserVo> getMonitorUserList(Long current, Long size, String account, String username, String email);

    /**
     * <p>
     * 添加用户
     * </p>
     *
     * @param monitorUserVo 用户信息
     * @return layUiAdmin响应对象：如果数据库中已经有此账号，LayUiAdminResultVo.data="exist"；
     * 如果添加用户成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo saveUser(MonitorUserVo monitorUserVo);

    /**
     * <p>
     * 编辑用户
     * </p>
     *
     * @param monitorUserVo 用户信息
     * @return layUiAdmin响应对象：如果编辑用户成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     *
     */
    LayUiAdminResultVo editUser(MonitorUserVo monitorUserVo);

    /**
     * <p>
     * 删除用户
     * </p>
     *
     * @param monitorUserVos 用户信息
     * @return layUiAdmin响应对象：如果删除用户成功，LayUiAdminResultVo.data="success"，否则LayUiAdminResultVo.data="fail"。
     * @throws NotFoundUserException 找不到用户异常
     *
     */
    LayUiAdminResultVo deleteUser(List<MonitorUserVo> monitorUserVos) throws NotFoundUserException;
}
