package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.WithdrawDetail;

/**
 * 用户提现明细Service接口
 *
 * @author gpthk
 * @date 2025-01-08
 */
public interface IWithdrawDetailService {
    /**
     * 查询用户提现明细
     *
     * @param id 用户提现明细主键
     * @return 用户提现明细
     */
    WithdrawDetail selectWithdrawDetailById(Long id);

    /**
     * 查询用户提现明细列表
     *
     * @param withdrawDetail 用户提现明细
     * @return 用户提现明细集合
     */
    List<WithdrawDetail> selectWithdrawDetailList(WithdrawDetail withdrawDetail);

    /**
     * 新增用户提现明细
     *
     * @param withdrawDetail 用户提现明细
     * @return 结果
     */
     int insertWithdrawDetail(WithdrawDetail withdrawDetail);

    /**
     * 修改用户提现明细
     *
     * @param withdrawDetail 用户提现明细
     * @return 结果
     */
     int updateWithdrawDetail(WithdrawDetail withdrawDetail);

    /**
     * 批量删除用户提现明细
     *
     * @param ids 需要删除的用户提现明细主键集合
     * @return 结果
     */
     int deleteWithdrawDetailByIds(Long[] ids);

    /**
     * 删除用户提现明细信息
     *
     * @param id 用户提现明细主键
     * @return 结果
     */
     int deleteWithdrawDetailById(Long id);

     List<WithdrawDetail> listWithChildren(WithdrawDetail entity);

     List<WithdrawDetail> listWithParents(WithdrawDetail entity);

    int addCopy(Long[] withdrawDetail);
}
