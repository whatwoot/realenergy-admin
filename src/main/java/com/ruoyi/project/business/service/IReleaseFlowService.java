package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.ReleaseFlow;

/**
 * 等待释放Service接口
 *
 * @author gpthk
 * @date 2025-12-31
 */
public interface IReleaseFlowService {
    /**
     * 查询等待释放
     *
     * @param id 等待释放主键
     * @return 等待释放
     */
    ReleaseFlow selectReleaseFlowById(Long id);

    /**
     * 查询等待释放列表
     *
     * @param releaseFlow 等待释放
     * @return 等待释放集合
     */
    List<ReleaseFlow> selectReleaseFlowList(ReleaseFlow releaseFlow);

    /**
     * 新增等待释放
     *
     * @param releaseFlow 等待释放
     * @return 结果
     */
     int insertReleaseFlow(ReleaseFlow releaseFlow);

    /**
     * 修改等待释放
     *
     * @param releaseFlow 等待释放
     * @return 结果
     */
     int updateReleaseFlow(ReleaseFlow releaseFlow);

    /**
     * 批量删除等待释放
     *
     * @param ids 需要删除的等待释放主键集合
     * @return 结果
     */
     int deleteReleaseFlowByIds(Long[] ids);

    /**
     * 删除等待释放信息
     *
     * @param id 等待释放主键
     * @return 结果
     */
     int deleteReleaseFlowById(Long id);
}
