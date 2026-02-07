package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.QueueFlowMapper;
import com.ruoyi.project.business.domain.QueueFlow;
import com.ruoyi.project.business.service.IQueueFlowService;

/**
 * 排位出局明细Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Service
public class QueueFlowServiceImpl implements IQueueFlowService {
    @Autowired
    private QueueFlowMapper queueFlowMapper;

    /**
     * 查询排位出局明细
     *
     * @param id 排位出局明细主键
     * @return 排位出局明细
     */
    @Override
    public QueueFlow selectQueueFlowById(Long id)
    {
        return queueFlowMapper.selectQueueFlowById(id);
    }

    /**
     * 查询排位出局明细列表
     *
     * @param queueFlow 排位出局明细
     * @return 排位出局明细
     */
    @Override
    public List<QueueFlow> selectQueueFlowList(QueueFlow queueFlow)
    {
        return queueFlowMapper.selectQueueFlowList(queueFlow);
    }

    /**
     * 新增排位出局明细
     *
     * @param queueFlow 排位出局明细
     * @return 结果
     */
    @Override
    public int insertQueueFlow(QueueFlow queueFlow) {
        queueFlow.setCreateTime(null);
        return queueFlowMapper.insertQueueFlow(queueFlow);
    }

    /**
     * 修改排位出局明细
     *
     * @param queueFlow 排位出局明细
     * @return 结果
     */
    @Override
    public int updateQueueFlow(QueueFlow queueFlow)
    {
        return queueFlowMapper.updateQueueFlow(queueFlow);
    }

    /**
     * 批量删除排位出局明细
     *
     * @param ids 需要删除的排位出局明细主键
     * @return 结果
     */
    @Override
    public int deleteQueueFlowByIds(Long[] ids)
    {
        return queueFlowMapper.deleteQueueFlowByIds(ids);
    }

    /**
     * 删除排位出局明细信息
     *
     * @param id 排位出局明细主键
     * @return 结果
     */
    @Override
    public int deleteQueueFlowById(Long id)
    {
        return queueFlowMapper.deleteQueueFlowById(id);
    }

    @Override
    public List<QueueFlow> listWithChildren(QueueFlow entity) {
        return queueFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<QueueFlow> listWithParents(QueueFlow  entity) {
        return queueFlowMapper.listWithParents(entity);
    }
}
