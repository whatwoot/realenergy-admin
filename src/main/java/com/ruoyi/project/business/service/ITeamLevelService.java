package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.TeamLevel;

/**
 * 社区级别Service接口
 *
 * @author gpthk
 * @date 2025-01-10
 */
public interface ITeamLevelService {
    /**
     * 查询社区级别
     *
     * @param id 社区级别主键
     * @return 社区级别
     */
    TeamLevel selectTeamLevelById(Long id);

    /**
     * 查询社区级别列表
     *
     * @param teamLevel 社区级别
     * @return 社区级别集合
     */
    List<TeamLevel> selectTeamLevelList(TeamLevel teamLevel);

    /**
     * 新增社区级别
     *
     * @param teamLevel 社区级别
     * @return 结果
     */
     int insertTeamLevel(TeamLevel teamLevel);

    /**
     * 修改社区级别
     *
     * @param teamLevel 社区级别
     * @return 结果
     */
     int updateTeamLevel(TeamLevel teamLevel);

    /**
     * 批量删除社区级别
     *
     * @param ids 需要删除的社区级别主键集合
     * @return 结果
     */
     int deleteTeamLevelByIds(Long[] ids);

    /**
     * 删除社区级别信息
     *
     * @param id 社区级别主键
     * @return 结果
     */
     int deleteTeamLevelById(Long id);
}
