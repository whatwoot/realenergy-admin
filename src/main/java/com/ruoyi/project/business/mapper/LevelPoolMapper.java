package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.LevelPool;

/**
 * 爆破池Mapper接口
 *
 * @author gpthk
 * @date 2025-11-07
 */
public interface LevelPoolMapper {
    /**
     * 查询爆破池
     *
     * @param id 爆破池主键
     * @return 爆破池
     */
    LevelPool selectLevelPoolById(Long id);

    /**
     * 查询爆破池列表
     *
     * @param levelPool 爆破池
     * @return 爆破池集合
     */
    List<LevelPool> selectLevelPoolList(LevelPool levelPool);

    /**
     * 新增爆破池
     *
     * @param levelPool 爆破池
     * @return 结果
     */
    int insertLevelPool(LevelPool levelPool);

    /**
     * 修改爆破池
     *
     * @param levelPool 爆破池
     * @return 结果
     */
    int updateLevelPool(LevelPool levelPool);

    /**
     * 删除爆破池
     *
     * @param id 爆破池主键
     * @return 结果
     */
    int deleteLevelPoolById(Long id);

    /**
     * 批量删除爆破池
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteLevelPoolByIds(Long[] ids);
}
