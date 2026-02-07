package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.InviteLevelMapper;
import com.ruoyi.project.business.domain.InviteLevel;
import com.ruoyi.project.business.service.IInviteLevelService;

/**
 * 邀请级别Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-10
 */
@Service
public class InviteLevelServiceImpl implements IInviteLevelService {
    @Autowired
    private InviteLevelMapper inviteLevelMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询邀请级别
     *
     * @param id 邀请级别主键
     * @return 邀请级别
     */
    @Override
    public InviteLevel selectInviteLevelById(Long id)
    {
        return inviteLevelMapper.selectInviteLevelById(id);
    }

    /**
     * 查询邀请级别列表
     *
     * @param inviteLevel 邀请级别
     * @return 邀请级别
     */
    @Override
    public List<InviteLevel> selectInviteLevelList(InviteLevel inviteLevel)
    {
        return inviteLevelMapper.selectInviteLevelList(inviteLevel);
    }

    /**
     * 新增邀请级别
     *
     * @param inviteLevel 邀请级别
     * @return 结果
     */
    @Override
    public int insertInviteLevel(InviteLevel inviteLevel) {
        inviteLevel.setCreateTime(null);
        return inviteLevelMapper.insertInviteLevel(inviteLevel);
    }

    /**
     * 修改邀请级别
     *
     * @param inviteLevel 邀请级别
     * @return 结果
     */
    @Override
    public int updateInviteLevel(InviteLevel inviteLevel) {
        inviteLevel.setUpdateTime(null);
        int row = inviteLevelMapper.updateInviteLevel(inviteLevel);
        redisTemplate.delete("g10n1:level:team");
        return row;
    }

    /**
     * 批量删除邀请级别
     *
     * @param ids 需要删除的邀请级别主键
     * @return 结果
     */
    @Override
    public int deleteInviteLevelByIds(Long[] ids)
    {
        return inviteLevelMapper.deleteInviteLevelByIds(ids);
    }

    /**
     * 删除邀请级别信息
     *
     * @param id 邀请级别主键
     * @return 结果
     */
    @Override
    public int deleteInviteLevelById(Long id)
    {
        return inviteLevelMapper.deleteInviteLevelById(id);
    }
}
