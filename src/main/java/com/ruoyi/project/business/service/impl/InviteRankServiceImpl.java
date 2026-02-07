package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.InviteRankMapper;
import com.ruoyi.project.business.domain.InviteRank;
import com.ruoyi.project.business.service.IInviteRankService;

/**
 * 销售排行榜Service业务层处理
 *
 * @author gpthk
 * @date 2025-11-06
 */
@Service
public class InviteRankServiceImpl implements IInviteRankService {
    @Autowired
    private InviteRankMapper inviteRankMapper;

    /**
     * 查询销售排行榜
     *
     * @param id 销售排行榜主键
     * @return 销售排行榜
     */
    @Override
    public InviteRank selectInviteRankById(Long id)
    {
        return inviteRankMapper.selectInviteRankById(id);
    }

    /**
     * 查询销售排行榜列表
     *
     * @param inviteRank 销售排行榜
     * @return 销售排行榜
     */
    @Override
    public List<InviteRank> selectInviteRankList(InviteRank inviteRank)
    {
        return inviteRankMapper.selectInviteRankList(inviteRank);
    }

    /**
     * 新增销售排行榜
     *
     * @param inviteRank 销售排行榜
     * @return 结果
     */
    @Override
    public int insertInviteRank(InviteRank inviteRank) {
        inviteRank.setCreateTime(null);
        return inviteRankMapper.insertInviteRank(inviteRank);
    }

    /**
     * 修改销售排行榜
     *
     * @param inviteRank 销售排行榜
     * @return 结果
     */
    @Override
    public int updateInviteRank(InviteRank inviteRank) {
        inviteRank.setUpdateTime(null);
        return inviteRankMapper.updateInviteRank(inviteRank);
    }

    /**
     * 批量删除销售排行榜
     *
     * @param ids 需要删除的销售排行榜主键
     * @return 结果
     */
    @Override
    public int deleteInviteRankByIds(Long[] ids)
    {
        return inviteRankMapper.deleteInviteRankByIds(ids);
    }

    /**
     * 删除销售排行榜信息
     *
     * @param id 销售排行榜主键
     * @return 结果
     */
    @Override
    public int deleteInviteRankById(Long id)
    {
        return inviteRankMapper.deleteInviteRankById(id);
    }
}
