package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.MemberWalletMapper;
import com.ruoyi.project.business.domain.MemberWallet;
import com.ruoyi.project.business.service.IMemberWalletService;

/**
 * 用户钱包Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-17
 */
@Service
public class MemberWalletServiceImpl implements IMemberWalletService {
    @Autowired
    private MemberWalletMapper memberWalletMapper;

    /**
     * 查询用户钱包
     *
     * @param id 用户钱包主键
     * @return 用户钱包
     */
    @Override
    public MemberWallet selectMemberWalletById(Long id)
    {
        return memberWalletMapper.selectMemberWalletById(id);
    }

    /**
     * 查询用户钱包列表
     *
     * @param memberWallet 用户钱包
     * @return 用户钱包
     */
    @Override
    public List<MemberWallet> selectMemberWalletList(MemberWallet memberWallet)
    {
        return memberWalletMapper.selectMemberWalletList(memberWallet);
    }

    /**
     * 新增用户钱包
     *
     * @param memberWallet 用户钱包
     * @return 结果
     */
    @Override
    public int insertMemberWallet(MemberWallet memberWallet) {
        memberWallet.setCreateTime(null);
        return memberWalletMapper.insertMemberWallet(memberWallet);
    }

    /**
     * 修改用户钱包
     *
     * @param memberWallet 用户钱包
     * @return 结果
     */
    @Override
    public int updateMemberWallet(MemberWallet memberWallet)
    {
        memberWallet.setUpdateTime(null);
        return memberWalletMapper.updateMemberWallet(memberWallet);
    }

    /**
     * 批量删除用户钱包
     *
     * @param ids 需要删除的用户钱包主键
     * @return 结果
     */
    @Override
    public int deleteMemberWalletByIds(Long[] ids)
    {
        return memberWalletMapper.deleteMemberWalletByIds(ids);
    }

    /**
     * 删除用户钱包信息
     *
     * @param id 用户钱包主键
     * @return 结果
     */
    @Override
    public int deleteMemberWalletById(Long id)
    {
        return memberWalletMapper.deleteMemberWalletById(id);
    }

    @Override
    public List<MemberWallet> listWithChildren(MemberWallet entity) {
        return memberWalletMapper.listWithChildren(entity);
    }

    @Override
    public List<MemberWallet> listWithParents(MemberWallet  entity) {
        return memberWalletMapper.listWithParents(entity);
    }
}
