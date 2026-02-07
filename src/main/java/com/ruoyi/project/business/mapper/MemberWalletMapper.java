package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.MemberWallet;

/**
 * 用户钱包Mapper接口
 *
 * @author gpthk
 * @date 2025-03-17
 */
public interface MemberWalletMapper {
    /**
     * 查询用户钱包
     *
     * @param id 用户钱包主键
     * @return 用户钱包
     */
    MemberWallet selectMemberWalletById(Long id);

    /**
     * 查询用户钱包列表
     *
     * @param memberWallet 用户钱包
     * @return 用户钱包集合
     */
    List<MemberWallet> selectMemberWalletList(MemberWallet memberWallet);

    /**
     * 新增用户钱包
     *
     * @param memberWallet 用户钱包
     * @return 结果
     */
    int insertMemberWallet(MemberWallet memberWallet);

    /**
     * 修改用户钱包
     *
     * @param memberWallet 用户钱包
     * @return 结果
     */
    int updateMemberWallet(MemberWallet memberWallet);

    /**
     * 删除用户钱包
     *
     * @param id 用户钱包主键
     * @return 结果
     */
    int deleteMemberWalletById(Long id);

    /**
     * 批量删除用户钱包
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMemberWalletByIds(Long[] ids);

    List<MemberWallet> listWithChildren(MemberWallet entity);

    List<MemberWallet> listWithParents(MemberWallet entity);
}
