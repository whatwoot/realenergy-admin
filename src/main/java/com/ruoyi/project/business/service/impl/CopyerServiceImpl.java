package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.CopyerMapper;
import com.ruoyi.project.business.domain.Copyer;
import com.ruoyi.project.business.service.ICopyerService;

/**
 * 用户跟单Service业务层处理
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Service
public class CopyerServiceImpl implements ICopyerService {
    @Autowired
    private CopyerMapper copyerMapper;

    /**
     * 查询用户跟单
     *
     * @param id 用户跟单主键
     * @return 用户跟单
     */
    @Override
    public Copyer selectCopyerById(Long id)
    {
        return copyerMapper.selectCopyerById(id);
    }

    /**
     * 查询用户跟单列表
     *
     * @param copyer 用户跟单
     * @return 用户跟单
     */
    @Override
    public List<Copyer> selectCopyerList(Copyer copyer)
    {
        return copyerMapper.selectCopyerList(copyer);
    }

    /**
     * 新增用户跟单
     *
     * @param copyer 用户跟单
     * @return 结果
     */
    @Override
    public int insertCopyer(Copyer copyer) {
        copyer.setCreateTime(null);
        return copyerMapper.insertCopyer(copyer);
    }

    /**
     * 修改用户跟单
     *
     * @param copyer 用户跟单
     * @return 结果
     */
    @Override
    public int updateCopyer(Copyer copyer) {
        copyer.setUpdateTime(null);
        return copyerMapper.updateCopyer(copyer);
    }

    /**
     * 批量删除用户跟单
     *
     * @param ids 需要删除的用户跟单主键
     * @return 结果
     */
    @Override
    public int deleteCopyerByIds(Long[] ids)
    {
        return copyerMapper.deleteCopyerByIds(ids);
    }

    /**
     * 删除用户跟单信息
     *
     * @param id 用户跟单主键
     * @return 结果
     */
    @Override
    public int deleteCopyerById(Long id)
    {
        return copyerMapper.deleteCopyerById(id);
    }
}
