package com.ruoyi.project.business.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.project.business.domain.Login;
import com.ruoyi.project.business.domain.Member;
import com.ruoyi.project.business.enums.LoginTypeEnum;
import com.ruoyi.project.business.mapper.LoginMapper;
import com.ruoyi.project.business.mapper.MemberMapper;
import com.ruoyi.project.business.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.cs.sp.common.WebAssert.expect;
import static com.cs.sp.common.WebAssert.expectNotNull;

/**
 * 用户Service业务层处理
 * @author gpthk
 * @date 2024-07-08
 */
@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public Member selectById(Long id) {
        return memberMapper.selectById(id);
    }

    /**
     * 查询用户列表
     *
     * @param member 用户
     * @return 用户
     */
    @Override
    public List<Member> selectList(Member member) {
        return memberMapper.selectList(member);
    }

    /**
     * 新增用户
     *
     * @param member 用户
     * @return 结果
     */
    @Override
    public int insertMember(Member member) {
        member.setCreateTime(null);
        int rows = 0;
        try {
            rows = memberMapper.insertMember(member);
        } catch (DuplicateKeyException e) {
            log.warn("位置已占用", e);
            throw new ServiceException("位置已占用");
        }
        return rows;
    }

    /**
     * 修改用户
     *
     * @param member 用户
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMember(Member member) {
        member.setUpdateTime(null);
        int rows = 0;
        try {
            List<String> cols = new ArrayList<>();
            if (member.getPid() == null) {
                cols.add("pid");
            }
            rows = memberMapper.updateMemberWithForce(member, cols.toArray(new String[0]));
            // 处理用户邀请，不造成循环
            int flag = memberMapper.countLoop(member);
            if (flag > 0) {
                throw new ServiceException("邀请关系不可形成循环");
            }
        } catch (DuplicateKeyException e) {
            log.warn("位置已占用", e);
            throw new ServiceException("记录已存在");
        }
        return rows;
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteByIds(Long[] ids) {
        return memberMapper.deleteByIdsLogic(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteById(Long id) {
        return memberMapper.deleteByIdLogic(id);
    }

    @Override
    public List<Member> listWithChildren(Member entity) {
        return memberMapper.listWithChildren(entity);
    }

    @Override
    public List<Member> listWithParents(Member entity) {
        return memberMapper.listWithParents(entity);
    }

    @Override
    public List<Member> selectAll(Member member) {
        return memberMapper.listAll(member);
    }

    @Override
    public int updateBatch(List<Long> ids, Member update) {
        return memberMapper.updateMemberBatch(update, ids);
    }

    @Override
    public int updateAll(Member update) {
        return memberMapper.updateAll(update);
    }

    @Override
    public void checkMember() {
        List<Member> members = memberMapper.listAll(null);
        Long pid;
        for (Member member : members) {
            pid = member.getPid();
            if (pid != null) {
                List<Member> parents = memberMapper.listParents(pid);
                Member parent;
                for (int i = 0; i < parents.size(); i++) {
                    parent = parents.get(i);
                    if (parent.getId().equals(member.getId())) {
                        log.warn("MemberCycleCheck {}=>{}, {} {}", member.getId(), member.getPid(),
                                i, parent.getId());
                    }
                }
            }
        }
    }

    @Override
    public Member selectByMail(String email) {
        return memberMapper.selectByEmail(email);
    }

    @Override
    public Member selectByMainAccout(String addr) {
        return memberMapper.selectByMainAccount(addr);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateChangeMainAccount(Member update) {
        // 1、确认新邮箱未被占用
        Login login = new Login();
        login.setAccount(update.getMainAccount().toLowerCase());
        login.setType(LoginTypeEnum.BSC.getCode());
        List<Login> logins = loginMapper.selectLoginList(login);
        expect(logins.isEmpty(), "钱包已使用");
        // 2、查找原来的账号
        Login exists = new Login();
        exists.setUid(update.getId());
        exists.setType(LoginTypeEnum.BSC.getCode());
        List<Login> oldList = loginMapper.selectLoginList(exists);
        expect(!oldList.isEmpty(), "账户未找到");
        // 修改用户表（这个表当时为了省事冗余加了email字段）
        Member member = memberMapper.selectById(update.getId());
        expectNotNull(member, "用户不存在");
        // 钱包地址取全小写
        update.setMainAccount(update.getMainAccount().toLowerCase());
        memberMapper.updateMember(update);
        // 修改账户表
        Login updateLogin = new Login();
        updateLogin.setId(oldList.get(0).getId());
        updateLogin.setAccount(update.getMainAccount().toLowerCase());
        int i = loginMapper.updateLogin(updateLogin);
        expect(i == 1, "修改失败");
        return 1;
    }
}
