package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.InviteRank;

/**
 * 销售排行榜Service接口
 *
 * @author gpthk
 * @date 2025-11-06
 */
public interface IInviteRankService {
    /**
     * 查询销售排行榜
     *
     * @param id 销售排行榜主键
     * @return 销售排行榜
     */
    InviteRank selectInviteRankById(Long id);

    /**
     * 查询销售排行榜列表
     *
     * @param inviteRank 销售排行榜
     * @return 销售排行榜集合
     */
    List<InviteRank> selectInviteRankList(InviteRank inviteRank);

    /**
     * 新增销售排行榜
     *
     * @param inviteRank 销售排行榜
     * @return 结果
     */
     int insertInviteRank(InviteRank inviteRank);

    /**
     * 修改销售排行榜
     *
     * @param inviteRank 销售排行榜
     * @return 结果
     */
     int updateInviteRank(InviteRank inviteRank);

    /**
     * 批量删除销售排行榜
     *
     * @param ids 需要删除的销售排行榜主键集合
     * @return 结果
     */
     int deleteInviteRankByIds(Long[] ids);

    /**
     * 删除销售排行榜信息
     *
     * @param id 销售排行榜主键
     * @return 结果
     */
     int deleteInviteRankById(Long id);
}
