package com.ruoyi.project.business.service.impl;

import com.ruoyi.project.business.domain.Login;
import com.ruoyi.project.business.mapper.LoginMapper;
import com.ruoyi.project.business.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 登录账户Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-15
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 查询登录账户
     *
     * @param id 登录账户主键
     * @return 登录账户
     */
    @Override
    public Login selectLoginById(Long id) {
        return loginMapper.selectLoginById(id);
    }

    @Override
    public List<Login> selectByUids(Collection<Long> ids) {
        return loginMapper.selectByUids(ids);
    }

    /**
     * 查询登录账户列表
     *
     * @param login 登录账户
     * @return 登录账户
     */
    @Override
    public List<Login> selectLoginList(Login login) {
        return loginMapper.selectLoginList(login);
    }

    /**
     * 新增登录账户
     *
     * @param login 登录账户
     * @return 结果
     */
    @Override
    public int insertLogin(Login login) {
        login.setCreateTime(null);
        return loginMapper.insertLogin(login);
    }

    /**
     * 修改登录账户
     *
     * @param login 登录账户
     * @return 结果
     */
    @Override
    public int updateLogin(Login login) {
        login.setUpdateTime(null);
        return loginMapper.updateLogin(login);
    }

    /**
     * 批量删除登录账户
     *
     * @param ids 需要删除的登录账户主键
     * @return 结果
     */
    @Override
    public int deleteLoginByIds(Long[] ids) {
        return loginMapper.deleteLoginByIds(ids);
    }

    /**
     * 删除登录账户信息
     *
     * @param id 登录账户主键
     * @return 结果
     */
    @Override
    public int deleteLoginById(Long id) {
        return loginMapper.deleteLoginById(id);
    }
}
