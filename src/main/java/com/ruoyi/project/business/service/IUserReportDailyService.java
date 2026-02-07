package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.UserReportDaily;

/**
 * 业绩报表Service接口
 *
 * @author gpthk
 * @date 2025-05-04
 */
public interface IUserReportDailyService {
    /**
     * 查询业绩报表
     *
     * @param id 业绩报表主键
     * @return 业绩报表
     */
    UserReportDaily selectUserReportDailyById(Long id);

    /**
     * 查询业绩报表列表
     *
     * @param userReportDaily 业绩报表
     * @return 业绩报表集合
     */
    List<UserReportDaily> selectUserReportDailyList(UserReportDaily userReportDaily);

    /**
     * 新增业绩报表
     *
     * @param userReportDaily 业绩报表
     * @return 结果
     */
     int insertUserReportDaily(UserReportDaily userReportDaily);

    /**
     * 修改业绩报表
     *
     * @param userReportDaily 业绩报表
     * @return 结果
     */
     int updateUserReportDaily(UserReportDaily userReportDaily);

    /**
     * 批量删除业绩报表
     *
     * @param ids 需要删除的业绩报表主键集合
     * @return 结果
     */
     int deleteUserReportDailyByIds(Long[] ids);

    /**
     * 删除业绩报表信息
     *
     * @param id 业绩报表主键
     * @return 结果
     */
     int deleteUserReportDailyById(Long id);

     List<UserReportDaily> listWithChildren(UserReportDaily entity);

     List<UserReportDaily> listWithParents(UserReportDaily entity);
}
