package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.QueueMapper;
import com.ruoyi.project.business.domain.Queue;
import com.ruoyi.project.business.service.IQueueService;

/**
 * 当前排位Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Service
public class QueueServiceImpl implements IQueueService {
    @Autowired
    private QueueMapper queueMapper;

    /**
     * 查询当前排位
     *
     * @param id 当前排位主键
     * @return 当前排位
     */
    @Override
    public Queue selectQueueById(Long id)
    {
        return queueMapper.selectQueueById(id);
    }

    /**
     * 查询当前排位列表
     *
     * @param queue 当前排位
     * @return 当前排位
     */
    @Override
    public List<Queue> selectQueueList(Queue queue)
    {
        return queueMapper.selectQueueList(queue);
    }

    /**
     * 新增当前排位
     *
     * @param queue 当前排位
     * @return 结果
     */
    @Override
    public int insertQueue(Queue queue) {
        queue.setCreateTime(null);
        return queueMapper.insertQueue(queue);
    }

    /**
     * 修改当前排位
     *
     * @param queue 当前排位
     * @return 结果
     */
    @Override
    public int updateQueue(Queue queue)
    {
        queue.setUpdateTime(null);
        return queueMapper.updateQueue(queue);
    }

    /**
     * 批量删除当前排位
     *
     * @param ids 需要删除的当前排位主键
     * @return 结果
     */
    @Override
    public int deleteQueueByIds(Long[] ids)
    {
        return queueMapper.deleteQueueByIds(ids);
    }

    /**
     * 删除当前排位信息
     *
     * @param id 当前排位主键
     * @return 结果
     */
    @Override
    public int deleteQueueById(Long id)
    {
        return queueMapper.deleteQueueById(id);
    }

    @Override
    public List<Queue> listWithChildren(Queue entity) {
        return queueMapper.listWithChildren(entity);
    }

    @Override
    public List<Queue> listWithParents(Queue  entity) {
        return queueMapper.listWithParents(entity);
    }
}
