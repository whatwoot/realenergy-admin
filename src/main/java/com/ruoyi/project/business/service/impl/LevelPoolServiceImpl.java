package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.LevelPoolMapper;
import com.ruoyi.project.business.domain.LevelPool;
import com.ruoyi.project.business.service.ILevelPoolService;

/**
 * 爆破池Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-07
 */
@Service
public class LevelPoolServiceImpl implements ILevelPoolService {
    @Autowired
    private LevelPoolMapper levelPoolMapper;

    /**
     * 查询爆破池
     *
     * @param id 爆破池主键
     * @return 爆破池
     */
    @Override
    public LevelPool selectLevelPoolById(Long id)
    {
        return levelPoolMapper.selectLevelPoolById(id);
    }

    /**
     * 查询爆破池列表
     *
     * @param levelPool 爆破池
     * @return 爆破池
     */
    @Override
    public List<LevelPool> selectLevelPoolList(LevelPool levelPool)
    {
        return levelPoolMapper.selectLevelPoolList(levelPool);
    }

    /**
     * 新增爆破池
     *
     * @param levelPool 爆破池
     * @return 结果
     */
    @Override
    public int insertLevelPool(LevelPool levelPool) {
        levelPool.setCreateTime(null);
        return levelPoolMapper.insertLevelPool(levelPool);
    }

    /**
     * 修改爆破池
     *
     * @param levelPool 爆破池
     * @return 结果
     */
    @Override
    public int updateLevelPool(LevelPool levelPool) {
        levelPool.setUpdateTime(null);
        return levelPoolMapper.updateLevelPool(levelPool);
    }

    /**
     * 批量删除爆破池
     *
     * @param ids 需要删除的爆破池主键
     * @return 结果
     */
    @Override
    public int deleteLevelPoolByIds(Long[] ids)
    {
        return levelPoolMapper.deleteLevelPoolByIds(ids);
    }

    /**
     * 删除爆破池信息
     *
     * @param id 爆破池主键
     * @return 结果
     */
    @Override
    public int deleteLevelPoolById(Long id)
    {
        return levelPoolMapper.deleteLevelPoolById(id);
    }
}
