package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.ChainWorkMapper;
import com.ruoyi.project.business.domain.ChainWork;
import com.ruoyi.project.business.service.IChainWorkService;

/**
 * 转账任务Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-22
 */
@Service
public class ChainWorkServiceImpl implements IChainWorkService {
    @Autowired
    private ChainWorkMapper chainWorkMapper;

    /**
     * 查询转账任务
     *
     * @param id 转账任务主键
     * @return 转账任务
     */
    @Override
    public ChainWork selectChainWorkById(Long id)
    {
        return chainWorkMapper.selectChainWorkById(id);
    }

    /**
     * 查询转账任务列表
     *
     * @param chainWork 转账任务
     * @return 转账任务
     */
    @Override
    public List<ChainWork> selectChainWorkList(ChainWork chainWork)
    {
        return chainWorkMapper.selectChainWorkList(chainWork);
    }

    /**
     * 新增转账任务
     *
     * @param chainWork 转账任务
     * @return 结果
     */
    @Override
    public int insertChainWork(ChainWork chainWork) {
        chainWork.setCreateTime(null);
        return chainWorkMapper.insertChainWork(chainWork);
    }

    /**
     * 修改转账任务
     *
     * @param chainWork 转账任务
     * @return 结果
     */
    @Override
    public int updateChainWork(ChainWork chainWork) {
        chainWork.setUpdateTime(null);
        return chainWorkMapper.updateChainWork(chainWork);
    }

    /**
     * 批量删除转账任务
     *
     * @param ids 需要删除的转账任务主键
     * @return 结果
     */
    @Override
    public int deleteChainWorkByIds(Long[] ids)
    {
        return chainWorkMapper.deleteChainWorkByIds(ids);
    }

    /**
     * 删除转账任务信息
     *
     * @param id 转账任务主键
     * @return 结果
     */
    @Override
    public int deleteChainWorkById(Long id)
    {
        return chainWorkMapper.deleteChainWorkById(id);
    }
}
