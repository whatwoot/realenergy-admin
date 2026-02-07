package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.DailyReport;

/**
 * 每日报表Mapper接口
 *
 * @author gpthk
 * @date 2025-11-16
 */
public interface DailyReportMapper {
    /**
     * 查询每日报表
     *
     * @param id 每日报表主键
     * @return 每日报表
     */
    DailyReport selectDailyReportById(Long id);

    /**
     * 查询每日报表列表
     *
     * @param dailyReport 每日报表
     * @return 每日报表集合
     */
    List<DailyReport> selectDailyReportList(DailyReport dailyReport);

    /**
     * 新增每日报表
     *
     * @param dailyReport 每日报表
     * @return 结果
     */
    int insertDailyReport(DailyReport dailyReport);

    /**
     * 修改每日报表
     *
     * @param dailyReport 每日报表
     * @return 结果
     */
    int updateDailyReport(DailyReport dailyReport);

    /**
     * 删除每日报表
     *
     * @param id 每日报表主键
     * @return 结果
     */
    int deleteDailyReportById(Long id);

    /**
     * 批量删除每日报表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteDailyReportByIds(Long[] ids);
}
