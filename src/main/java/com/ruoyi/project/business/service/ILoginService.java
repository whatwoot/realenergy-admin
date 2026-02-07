package com.ruoyi.project.business.service;

import java.util.Collection;
import java.util.List;
import com.ruoyi.project.business.domain.Login;

/**
 * 登录账户Service接口
 *
 * @author gpthk
 * @date 2025-03-15
 */
public interface ILoginService {
    /**
     * 查询登录账户
     *
     * @param id 登录账户主键
     * @return 登录账户
     */
    Login selectLoginById(Long id);
    List<Login> selectByUids(Collection<Long> ids);

    /**
     * 查询登录账户列表
     *
     * @param login 登录账户
     * @return 登录账户集合
     */
    List<Login> selectLoginList(Login login);

    /**
     * 新增登录账户
     *
     * @param login 登录账户
     * @return 结果
     */
     int insertLogin(Login login);

    /**
     * 修改登录账户
     *
     * @param login 登录账户
     * @return 结果
     */
     int updateLogin(Login login);

    /**
     * 批量删除登录账户
     *
     * @param ids 需要删除的登录账户主键集合
     * @return 结果
     */
     int deleteLoginByIds(Long[] ids);

    /**
     * 删除登录账户信息
     *
     * @param id 登录账户主键
     * @return 结果
     */
     int deleteLoginById(Long id);
}
