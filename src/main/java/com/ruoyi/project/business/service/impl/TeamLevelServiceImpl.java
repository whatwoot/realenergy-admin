package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.TeamLevelMapper;
import com.ruoyi.project.business.domain.TeamLevel;
import com.ruoyi.project.business.service.ITeamLevelService;

/**
 * 社区级别Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Service
public class TeamLevelServiceImpl implements ITeamLevelService {
    @Autowired
    private TeamLevelMapper teamLevelMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询社区级别
     *
     * @param id 社区级别主键
     * @return 社区级别
     */
    @Override
    public TeamLevel selectTeamLevelById(Long id)
    {
        return teamLevelMapper.selectTeamLevelById(id);
    }

    /**
     * 查询社区级别列表
     *
     * @param teamLevel 社区级别
     * @return 社区级别
     */
    @Override
    public List<TeamLevel> selectTeamLevelList(TeamLevel teamLevel)
    {
        return teamLevelMapper.selectTeamLevelList(teamLevel);
    }

    /**
     * 新增社区级别
     *
     * @param teamLevel 社区级别
     * @return 结果
     */
    @Override
    public int insertTeamLevel(TeamLevel teamLevel) {
        teamLevel.setCreateTime(null);
        return teamLevelMapper.insertTeamLevel(teamLevel);
    }

    /**
     * 修改社区级别
     *
     * @param teamLevel 社区级别
     * @return 结果
     */
    @Override
    public int updateTeamLevel(TeamLevel teamLevel) {
        teamLevel.setUpdateTime(null);
        int row = teamLevelMapper.updateTeamLevel(teamLevel);
        redisTemplate.delete("g10n1:level:team");
        return row;
    }

    /**
     * 批量删除社区级别
     *
     * @param ids 需要删除的社区级别主键
     * @return 结果
     */
    @Override
    public int deleteTeamLevelByIds(Long[] ids)
    {
        return teamLevelMapper.deleteTeamLevelByIds(ids);
    }

    /**
     * 删除社区级别信息
     *
     * @param id 社区级别主键
     * @return 结果
     */
    @Override
    public int deleteTeamLevelById(Long id)
    {
        return teamLevelMapper.deleteTeamLevelById(id);
    }
}
