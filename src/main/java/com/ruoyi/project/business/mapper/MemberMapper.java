package com.ruoyi.project.business.mapper;

import com.ruoyi.project.business.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * @author gpthk
 * @date 2024-07-08
 */
public interface MemberMapper {
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

    int updateMemberWithForce(@Param("e") Member member, @Param("cols") String[] cols);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByIds(Long[] ids);

    List<Member> listWithChildren(Member entity);

    List<Member> listWithParents(Member entity);

    int deleteByIdsLogic(Long[] ids);

    int deleteByIdLogic(Long id);

    List<Member> listAll(Member member);

    int updateMemberBatch(@Param("e") Member update, @Param("ids") List<Long> ids);

    List<Member> listParents(Long id);

    int updateNoLoop(Member member);

    int countLoop(Member member);

    int updateAll(@Param("e") Member update);

    Member selectByEmail(String email);

    Member selectByMainAccount(String addr);
}
