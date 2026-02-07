package com.ruoyi.project.business.service;

import com.ruoyi.project.business.domain.Member;

import java.util.List;

/**
 * 用户Service接口
 *
 * @author gpthk
 * @date 2024-07-08
 */
public interface IMemberService {
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    Member selectById(Long id);

    /**
     * 查询用户列表
     *
     * @param member 用户
     * @return 用户集合
     */
    List<Member> selectList(Member member);

    /**
     * 新增用户
     *
     * @param member 用户
     * @return 结果
     */
     int insertMember(Member member);

    /**
     * 修改用户
     *
     * @param member 用户
     * @return 结果
     */
     int updateMember(Member member);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
     int deleteByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
     int deleteById(Long id);

     List<Member> listWithChildren(Member entity);

     List<Member> listWithParents(Member entity);

    List<Member> selectAll(Member member);

    int updateBatch(List<Long> ids, Member update);
    int updateAll(Member update);

    void checkMember();

    Member selectByMail(String email);
    Member selectByMainAccout(String addr);

    int updateChangeMainAccount(Member update);
}
