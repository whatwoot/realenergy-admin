package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.JackpotWinner;

/**
 * JackPot抽奖Mapper接口
 *
 * @author gpthk
 * @date 2025-12-31
 */
public interface JackpotWinnerMapper {
    /**
     * 查询JackPot抽奖
     *
     * @param id JackPot抽奖主键
     * @return JackPot抽奖
     */
    JackpotWinner selectJackpotWinnerById(Long id);

    /**
     * 查询JackPot抽奖列表
     *
     * @param jackpotWinner JackPot抽奖
     * @return JackPot抽奖集合
     */
    List<JackpotWinner> selectJackpotWinnerList(JackpotWinner jackpotWinner);

    /**
     * 新增JackPot抽奖
     *
     * @param jackpotWinner JackPot抽奖
     * @return 结果
     */
    int insertJackpotWinner(JackpotWinner jackpotWinner);

    /**
     * 修改JackPot抽奖
     *
     * @param jackpotWinner JackPot抽奖
     * @return 结果
     */
    int updateJackpotWinner(JackpotWinner jackpotWinner);

    /**
     * 删除JackPot抽奖
     *
     * @param id JackPot抽奖主键
     * @return 结果
     */
    int deleteJackpotWinnerById(Long id);

    /**
     * 批量删除JackPot抽奖
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteJackpotWinnerByIds(Long[] ids);
}
