package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.ChainWork;

/**
 * 转账任务Mapper接口
 *
 * @author gpthk
 * @date 2025-03-22
 */
public interface ChainWorkMapper {
    /**
     * 查询转账任务
     *
     * @param id 转账任务主键
     * @return 转账任务
     */
    ChainWork selectChainWorkById(Long id);

    /**
     * 查询转账任务列表
     *
     * @param chainWork 转账任务
     * @return 转账任务集合
     */
    List<ChainWork> selectChainWorkList(ChainWork chainWork);

    /**
     * 新增转账任务
     *
     * @param chainWork 转账任务
     * @return 结果
     */
    int insertChainWork(ChainWork chainWork);

    /**
     * 修改转账任务
     *
     * @param chainWork 转账任务
     * @return 结果
     */
    int updateChainWork(ChainWork chainWork);

    /**
     * 删除转账任务
     *
     * @param id 转账任务主键
     * @return 结果
     */
    int deleteChainWorkById(Long id);

    /**
     * 批量删除转账任务
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteChainWorkByIds(Long[] ids);
}
