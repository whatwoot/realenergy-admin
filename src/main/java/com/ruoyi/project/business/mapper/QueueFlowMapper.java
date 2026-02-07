package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.QueueFlow;

/**
 * 排位出局明细Mapper接口
 *
 * @author gpthk
 * @date 2025-03-17
 */
public interface QueueFlowMapper {
    /**
     * 查询排位出局明细
     *
     * @param id 排位出局明细主键
     * @return 排位出局明细
     */
    QueueFlow selectQueueFlowById(Long id);

    /**
     * 查询排位出局明细列表
     *
     * @param queueFlow 排位出局明细
     * @return 排位出局明细集合
     */
    List<QueueFlow> selectQueueFlowList(QueueFlow queueFlow);

    /**
     * 新增排位出局明细
     *
     * @param queueFlow 排位出局明细
     * @return 结果
     */
    int insertQueueFlow(QueueFlow queueFlow);

    /**
     * 修改排位出局明细
     *
     * @param queueFlow 排位出局明细
     * @return 结果
     */
    int updateQueueFlow(QueueFlow queueFlow);

    /**
     * 删除排位出局明细
     *
     * @param id 排位出局明细主键
     * @return 结果
     */
    int deleteQueueFlowById(Long id);

    /**
     * 批量删除排位出局明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteQueueFlowByIds(Long[] ids);

    List<QueueFlow> listWithChildren(QueueFlow entity);

    List<QueueFlow> listWithParents(QueueFlow entity);
}
