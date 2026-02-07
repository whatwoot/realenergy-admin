package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.Queue;

/**
 * 当前排位Mapper接口
 *
 * @author gpthk
 * @date 2025-03-17
 */
public interface QueueMapper {
    /**
     * 查询当前排位
     *
     * @param id 当前排位主键
     * @return 当前排位
     */
    Queue selectQueueById(Long id);

    /**
     * 查询当前排位列表
     *
     * @param queue 当前排位
     * @return 当前排位集合
     */
    List<Queue> selectQueueList(Queue queue);

    /**
     * 新增当前排位
     *
     * @param queue 当前排位
     * @return 结果
     */
    int insertQueue(Queue queue);

    /**
     * 修改当前排位
     *
     * @param queue 当前排位
     * @return 结果
     */
    int updateQueue(Queue queue);

    /**
     * 删除当前排位
     *
     * @param id 当前排位主键
     * @return 结果
     */
    int deleteQueueById(Long id);

    /**
     * 批量删除当前排位
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteQueueByIds(Long[] ids);

    List<Queue> listWithChildren(Queue entity);

    List<Queue> listWithParents(Queue entity);
}
