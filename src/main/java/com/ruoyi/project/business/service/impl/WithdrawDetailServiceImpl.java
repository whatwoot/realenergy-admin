package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.business.domain.WithdrawFlow;
import com.ruoyi.project.business.mapper.WithdrawFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.WithdrawDetailMapper;
import com.ruoyi.project.business.domain.WithdrawDetail;
import com.ruoyi.project.business.service.IWithdrawDetailService;

/**
 * 用户提现明细Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-08
 */
@Service
public class WithdrawDetailServiceImpl implements IWithdrawDetailService {
    @Autowired
    private WithdrawDetailMapper withdrawDetailMapper;

    @Autowired
    private WithdrawFlowMapper withdrawFlowMapper;

    /**
     * 查询用户提现明细
     *
     * @param id 用户提现明细主键
     * @return 用户提现明细
     */
    @Override
    public WithdrawDetail selectWithdrawDetailById(Long id)
    {
        return withdrawDetailMapper.selectWithdrawDetailById(id);
    }

    /**
     * 查询用户提现明细列表
     *
     * @param withdrawDetail 用户提现明细
     * @return 用户提现明细
     */
    @Override
    public List<WithdrawDetail> selectWithdrawDetailList(WithdrawDetail withdrawDetail)
    {
        return withdrawDetailMapper.selectWithdrawDetailList(withdrawDetail);
    }

    /**
     * 新增用户提现明细
     *
     * @param withdrawDetail 用户提现明细
     * @return 结果
     */
    @Override
    public int insertWithdrawDetail(WithdrawDetail withdrawDetail) {
        withdrawDetail.setCreateTime(null);
        return withdrawDetailMapper.insertWithdrawDetail(withdrawDetail);
    }

    /**
     * 修改用户提现明细
     *
     * @param withdrawDetail 用户提现明细
     * @return 结果
     */
    @Override
    public int updateWithdrawDetail(WithdrawDetail withdrawDetail)
    {
        withdrawDetail.setUpdateTime(null);
        return withdrawDetailMapper.updateWithdrawDetail(withdrawDetail);
    }

    /**
     * 批量删除用户提现明细
     *
     * @param ids 需要删除的用户提现明细主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawDetailByIds(Long[] ids)
    {
        return withdrawDetailMapper.deleteWithdrawDetailByIds(ids);
    }

    /**
     * 删除用户提现明细信息
     *
     * @param id 用户提现明细主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawDetailById(Long id)
    {
        return withdrawDetailMapper.deleteWithdrawDetailById(id);
    }

    @Override
    public List<WithdrawDetail> listWithChildren(WithdrawDetail entity) {
        return withdrawDetailMapper.listWithChildren(entity);
    }

    @Override
    public List<WithdrawDetail> listWithParents(WithdrawDetail  entity) {
        return withdrawDetailMapper.listWithParents(entity);
    }

    @Override
    public int addCopy(Long[] ids) {
        List<WithdrawDetail> details = withdrawDetailMapper.listAll(ids);
        WithdrawDetail update;
        Integer num =0;
        for (WithdrawDetail detail : details) {
            update = new WithdrawDetail();
            update.setId(detail.getId());
            update.setDeleted(detail.getId());
            num += withdrawDetailMapper.updateWithdrawDetail(update);
        }
        if(!details.isEmpty()){
            WithdrawFlow withdrawFlow = withdrawFlowMapper.selectWithdrawFlowById(details.get(0).getFlowId());
            if(withdrawFlow != null){
                WithdrawFlow updateFlow = new WithdrawFlow();
                updateFlow.setId(withdrawFlow.getId());
                // 0待提现
                updateFlow.setStatus(0);
                withdrawFlowMapper.updateWithdrawFlow(updateFlow);
            }
        }
        return num;
    }
}
