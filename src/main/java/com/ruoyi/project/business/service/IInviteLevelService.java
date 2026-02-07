package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.InviteLevel;

/**
 * 邀请级别Service接口
 *
 * @author gpthk
 * @date 2025-01-10
 */
public interface IInviteLevelService {
    /**
     * 查询邀请级别
     *
     * @param id 邀请级别主键
     * @return 邀请级别
     */
    InviteLevel selectInviteLevelById(Long id);

    /**
     * 查询邀请级别列表
     *
     * @param inviteLevel 邀请级别
     * @return 邀请级别集合
     */
    List<InviteLevel> selectInviteLevelList(InviteLevel inviteLevel);

    /**
     * 新增邀请级别
     *
     * @param inviteLevel 邀请级别
     * @return 结果
     */
     int insertInviteLevel(InviteLevel inviteLevel);

    /**
     * 修改邀请级别
     *
     * @param inviteLevel 邀请级别
     * @return 结果
     */
     int updateInviteLevel(InviteLevel inviteLevel);

    /**
     * 批量删除邀请级别
     *
     * @param ids 需要删除的邀请级别主键集合
     * @return 结果
     */
     int deleteInviteLevelByIds(Long[] ids);

    /**
     * 删除邀请级别信息
     *
     * @param id 邀请级别主键
     * @return 结果
     */
     int deleteInviteLevelById(Long id);
}
