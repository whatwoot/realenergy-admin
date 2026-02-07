package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.UserReportDailyMapper;
import com.ruoyi.project.business.domain.UserReportDaily;
import com.ruoyi.project.business.service.IUserReportDailyService;

/**
 * 业绩报表Service业务层处理
 *
 * @author gpthk
 * @date 2025-05-04
 */
@Service
public class UserReportDailyServiceImpl implements IUserReportDailyService {
    @Autowired
    private UserReportDailyMapper userReportDailyMapper;

    /**
     * 查询业绩报表
     *
     * @param id 业绩报表主键
     * @return 业绩报表
     */
    @Override
    public UserReportDaily selectUserReportDailyById(Long id)
    {
        return userReportDailyMapper.selectUserReportDailyById(id);
    }

    /**
     * 查询业绩报表列表
     *
     * @param userReportDaily 业绩报表
     * @return 业绩报表
     */
    @Override
    public List<UserReportDaily> selectUserReportDailyList(UserReportDaily userReportDaily)
    {
        return userReportDailyMapper.selectUserReportDailyList(userReportDaily);
    }

    /**
     * 新增业绩报表
     *
     * @param userReportDaily 业绩报表
     * @return 结果
     */
    @Override
    public int insertUserReportDaily(UserReportDaily userReportDaily) {
        userReportDaily.setCreateTime(null);
        return userReportDailyMapper.insertUserReportDaily(userReportDaily);
    }

    /**
     * 修改业绩报表
     *
     * @param userReportDaily 业绩报表
     * @return 结果
     */
    @Override
    public int updateUserReportDaily(UserReportDaily userReportDaily)
    {
        return userReportDailyMapper.updateUserReportDaily(userReportDaily);
    }

    /**
     * 批量删除业绩报表
     *
     * @param ids 需要删除的业绩报表主键
     * @return 结果
     */
    @Override
    public int deleteUserReportDailyByIds(Long[] ids)
    {
        return userReportDailyMapper.deleteUserReportDailyByIds(ids);
    }

    /**
     * 删除业绩报表信息
     *
     * @param id 业绩报表主键
     * @return 结果
     */
    @Override
    public int deleteUserReportDailyById(Long id)
    {
        return userReportDailyMapper.deleteUserReportDailyById(id);
    }

    @Override
    public List<UserReportDaily> listWithChildren(UserReportDaily entity) {
        return userReportDailyMapper.listWithChildren(entity);
    }

    @Override
    public List<UserReportDaily> listWithParents(UserReportDaily  entity) {
        return userReportDailyMapper.listWithParents(entity);
    }
}
