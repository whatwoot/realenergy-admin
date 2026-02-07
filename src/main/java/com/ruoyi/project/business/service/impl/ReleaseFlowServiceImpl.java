package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.ReleaseFlowMapper;
import com.ruoyi.project.business.domain.ReleaseFlow;
import com.ruoyi.project.business.service.IReleaseFlowService;

/**
 * 等待释放Service业务层处理
 *
 * @author gpthk
 * @date 2025-12-31
 */
@Service
public class ReleaseFlowServiceImpl implements IReleaseFlowService {
    @Autowired
    private ReleaseFlowMapper releaseFlowMapper;

    /**
     * 查询等待释放
     *
     * @param id 等待释放主键
     * @return 等待释放
     */
    @Override
    public ReleaseFlow selectReleaseFlowById(Long id)
    {
        return releaseFlowMapper.selectReleaseFlowById(id);
    }

    /**
     * 查询等待释放列表
     *
     * @param releaseFlow 等待释放
     * @return 等待释放
     */
    @Override
    public List<ReleaseFlow> selectReleaseFlowList(ReleaseFlow releaseFlow)
    {
        return releaseFlowMapper.selectReleaseFlowList(releaseFlow);
    }

    /**
     * 新增等待释放
     *
     * @param releaseFlow 等待释放
     * @return 结果
     */
    @Override
    public int insertReleaseFlow(ReleaseFlow releaseFlow) {
        releaseFlow.setCreateTime(null);
        return releaseFlowMapper.insertReleaseFlow(releaseFlow);
    }

    /**
     * 修改等待释放
     *
     * @param releaseFlow 等待释放
     * @return 结果
     */
    @Override
    public int updateReleaseFlow(ReleaseFlow releaseFlow) {
        releaseFlow.setUpdateTime(null);
        return releaseFlowMapper.updateReleaseFlow(releaseFlow);
    }

    /**
     * 批量删除等待释放
     *
     * @param ids 需要删除的等待释放主键
     * @return 结果
     */
    @Override
    public int deleteReleaseFlowByIds(Long[] ids)
    {
        return releaseFlowMapper.deleteReleaseFlowByIds(ids);
    }

    /**
     * 删除等待释放信息
     *
     * @param id 等待释放主键
     * @return 结果
     */
    @Override
    public int deleteReleaseFlowById(Long id)
    {
        return releaseFlowMapper.deleteReleaseFlowById(id);
    }
}
