package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.JackpotWinnerMapper;
import com.ruoyi.project.business.domain.JackpotWinner;
import com.ruoyi.project.business.service.IJackpotWinnerService;

/**
 * JackPot抽奖Service业务层处理
 *
 * @author gpthk
 * @date 2025-12-31
 */
@Service
public class JackpotWinnerServiceImpl implements IJackpotWinnerService {
    @Autowired
    private JackpotWinnerMapper jackpotWinnerMapper;

    /**
     * 查询JackPot抽奖
     *
     * @param id JackPot抽奖主键
     * @return JackPot抽奖
     */
    @Override
    public JackpotWinner selectJackpotWinnerById(Long id)
    {
        return jackpotWinnerMapper.selectJackpotWinnerById(id);
    }

    /**
     * 查询JackPot抽奖列表
     *
     * @param jackpotWinner JackPot抽奖
     * @return JackPot抽奖
     */
    @Override
    public List<JackpotWinner> selectJackpotWinnerList(JackpotWinner jackpotWinner)
    {
        return jackpotWinnerMapper.selectJackpotWinnerList(jackpotWinner);
    }

    /**
     * 新增JackPot抽奖
     *
     * @param jackpotWinner JackPot抽奖
     * @return 结果
     */
    @Override
    public int insertJackpotWinner(JackpotWinner jackpotWinner) {
        jackpotWinner.setCreateTime(null);
        return jackpotWinnerMapper.insertJackpotWinner(jackpotWinner);
    }

    /**
     * 修改JackPot抽奖
     *
     * @param jackpotWinner JackPot抽奖
     * @return 结果
     */
    @Override
    public int updateJackpotWinner(JackpotWinner jackpotWinner) {
        jackpotWinner.setUpdateTime(null);
        return jackpotWinnerMapper.updateJackpotWinner(jackpotWinner);
    }

    /**
     * 批量删除JackPot抽奖
     *
     * @param ids 需要删除的JackPot抽奖主键
     * @return 结果
     */
    @Override
    public int deleteJackpotWinnerByIds(Long[] ids)
    {
        return jackpotWinnerMapper.deleteJackpotWinnerByIds(ids);
    }

    /**
     * 删除JackPot抽奖信息
     *
     * @param id JackPot抽奖主键
     * @return 结果
     */
    @Override
    public int deleteJackpotWinnerById(Long id)
    {
        return jackpotWinnerMapper.deleteJackpotWinnerById(id);
    }
}
