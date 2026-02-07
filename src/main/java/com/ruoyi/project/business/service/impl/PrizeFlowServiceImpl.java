package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.PrizeFlowMapper;
import com.ruoyi.project.business.domain.PrizeFlow;
import com.ruoyi.project.business.service.IPrizeFlowService;

/**
 * 用户贡献明细Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Service
public class PrizeFlowServiceImpl implements IPrizeFlowService {
    @Autowired
    private PrizeFlowMapper prizeFlowMapper;

    /**
     * 查询用户贡献明细
     *
     * @param id 用户贡献明细主键
     * @return 用户贡献明细
     */
    @Override
    public PrizeFlow selectPrizeFlowById(Long id)
    {
        return prizeFlowMapper.selectPrizeFlowById(id);
    }

    /**
     * 查询用户贡献明细列表
     *
     * @param prizeFlow 用户贡献明细
     * @return 用户贡献明细
     */
    @Override
    public List<PrizeFlow> selectPrizeFlowList(PrizeFlow prizeFlow)
    {
        return prizeFlowMapper.selectPrizeFlowList(prizeFlow);
    }

    /**
     * 新增用户贡献明细
     *
     * @param prizeFlow 用户贡献明细
     * @return 结果
     */
    @Override
    public int insertPrizeFlow(PrizeFlow prizeFlow) {
        prizeFlow.setCreateTime(null);
        return prizeFlowMapper.insertPrizeFlow(prizeFlow);
    }

    /**
     * 修改用户贡献明细
     *
     * @param prizeFlow 用户贡献明细
     * @return 结果
     */
    @Override
    public int updatePrizeFlow(PrizeFlow prizeFlow)
    {
        return prizeFlowMapper.updatePrizeFlow(prizeFlow);
    }

    /**
     * 批量删除用户贡献明细
     *
     * @param ids 需要删除的用户贡献明细主键
     * @return 结果
     */
    @Override
    public int deletePrizeFlowByIds(Long[] ids)
    {
        return prizeFlowMapper.deletePrizeFlowByIds(ids);
    }

    /**
     * 删除用户贡献明细信息
     *
     * @param id 用户贡献明细主键
     * @return 结果
     */
    @Override
    public int deletePrizeFlowById(Long id)
    {
        return prizeFlowMapper.deletePrizeFlowById(id);
    }

    @Override
    public List<PrizeFlow> listWithChildren(PrizeFlow entity) {
        return prizeFlowMapper.listWithChildren(entity);
    }

    @Override
    public List<PrizeFlow> listWithParents(PrizeFlow  entity) {
        return prizeFlowMapper.listWithParents(entity);
    }
}
