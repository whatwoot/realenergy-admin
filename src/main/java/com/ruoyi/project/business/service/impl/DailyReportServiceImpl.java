package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.DailyReportMapper;
import com.ruoyi.project.business.domain.DailyReport;
import com.ruoyi.project.business.service.IDailyReportService;

/**
 * 每日报表Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-16
 */
@Service
public class DailyReportServiceImpl implements IDailyReportService {
    @Autowired
    private DailyReportMapper dailyReportMapper;

    /**
     * 查询每日报表
     *
     * @param id 每日报表主键
     * @return 每日报表
     */
    @Override
    public DailyReport selectDailyReportById(Long id)
    {
        return dailyReportMapper.selectDailyReportById(id);
    }

    /**
     * 查询每日报表列表
     *
     * @param dailyReport 每日报表
     * @return 每日报表
     */
    @Override
    public List<DailyReport> selectDailyReportList(DailyReport dailyReport)
    {
        return dailyReportMapper.selectDailyReportList(dailyReport);
    }

    /**
     * 新增每日报表
     *
     * @param dailyReport 每日报表
     * @return 结果
     */
    @Override
    public int insertDailyReport(DailyReport dailyReport) {
        dailyReport.setCreateTime(null);
        return dailyReportMapper.insertDailyReport(dailyReport);
    }

    /**
     * 修改每日报表
     *
     * @param dailyReport 每日报表
     * @return 结果
     */
    @Override
    public int updateDailyReport(DailyReport dailyReport) {
        return dailyReportMapper.updateDailyReport(dailyReport);
    }

    /**
     * 批量删除每日报表
     *
     * @param ids 需要删除的每日报表主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportByIds(Long[] ids)
    {
        return dailyReportMapper.deleteDailyReportByIds(ids);
    }

    /**
     * 删除每日报表信息
     *
     * @param id 每日报表主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportById(Long id)
    {
        return dailyReportMapper.deleteDailyReportById(id);
    }
}
