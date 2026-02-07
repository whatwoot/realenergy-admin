package com.ruoyi.project.business.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.Login;
import com.ruoyi.project.business.domain.Member;
import com.ruoyi.project.business.dto.BatchAddrsRequest;
import com.ruoyi.project.business.dto.BatchRequest;
import com.ruoyi.project.business.dto.ChangeEmailRequest;
import com.ruoyi.project.business.service.ILoginService;
import com.ruoyi.project.business.service.IMemberService;
import com.ruoyi.project.business.vo.MemberRichVO;
import com.cs.sp.common.BeanCopior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户Controller
 *
 * @author gpthk
 * @date 2024-07-08
 */
@RestController
@RequestMapping("/business/member")
public class MemberController extends BaseController {
    @Autowired
    private IMemberService memberService;

    @Autowired
    private ILoginService loginService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:member:list')")
    @GetMapping("/listAll")
    public List<Member> listAll(Member member) {
        List<Member> list;
        if (StringUtils.hasText(member.getMainAccount())) {
            list = memberService.listWithChildren(member);
        } else {
            list = memberService.selectAll(member);
        }
        return list;
    }

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(Member member) {
        startPage();
        List<Member> list = null;
        if (member.getId() != null || StringUtils.hasText(member.getMainAccount())) {
            if (Constants.ONE_INT.equals(member.getRelate())) {
                list = memberService.listWithChildren(member);
            } else if (Constants.ZERO_INT.equals(member.getRelate())) {
                list = memberService.listWithParents(member);
            }
        }
        if (list == null) {
            list = memberService.selectList(member);
        }
        if (list.isEmpty()) {
            return getDataTable(list);
        }

        long total = new PageInfo<>(list).getTotal();
        Set<Long> collect = list.stream().mapToLong(Member::getId).boxed().collect(Collectors.toSet());
        List<Login> logins = loginService.selectByUids(collect);
        Map<Long, List<Login>> userLogins = logins.stream().collect(Collectors.groupingBy(
                Login::getUid,  // 转换为Long
                Collectors.toList()
        ));

        List<MemberRichVO> members = BeanCopior.mapList(list, MemberRichVO.class, dest -> {
            List<Login> accounts = userLogins.get(dest.getId());
            if (accounts != null) {
                dest.setAccounts(accounts);
            }
        });
        return getDataTable(members, total);
    }


    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:member:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Member member) {
        List<Member> list = null;
        if (member.getId() != null || StringUtils.hasText(member.getMainAccount())) {
            if (Constants.ONE_INT.equals(member.getRelate())) {
                list = memberService.listWithChildren(member);
            } else if (Constants.ZERO_INT.equals(member.getRelate())) {
                list = memberService.listWithParents(member);
            }
        }
        if (list == null) {
            list = memberService.selectList(member);
        }
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Member member = memberService.selectById(id);
        Login login = new Login();
        login.setUid(member.getId());
        List<Login> logins = loginService.selectLoginList(login);
        MemberRichVO memberRichVO = BeanCopior.map(member, MemberRichVO.class);
        memberRichVO.setAccounts(logins);
        return success(memberRichVO);
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('business:member:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Member member) {
        return toAjax(memberService.insertMember(member));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('business:member:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Member member) {
        return toAjax(memberService.updateMember(member));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('business:member:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(memberService.deleteByIds(ids));
    }

    /**
     * 禁提现用户
     */
    @PreAuthorize("@ss.hasPermi('business:member:ban_withdraw')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/banWithdraw")
    public AjaxResult banWithdraw(@RequestBody BatchRequest req) {
        Member update = new Member();
        update.setCanWithdraw(Constants.ZERO_INT);
        return toAjax(memberService.updateBatch(req.getIds(), update));
    }

    /**
     * 开提现用户
     */
    @PreAuthorize("@ss.hasPermi('business:member:allow_withdraw')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/allowWithdraw")
    public AjaxResult allowWithdraw(@RequestBody BatchRequest req) {
        Member update = new Member();
        update.setCanWithdraw(Constants.ONE_INT);
        return toAjax(memberService.updateBatch(req.getIds(), update));
    }

    /**
     * 禁支付
     */
    @PreAuthorize("@ss.hasPermi('business:member:ban_pay')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/banPay")
    public AjaxResult banPay(@RequestBody BatchRequest req) {
        Member update = new Member();
        update.setLevelId(Constants.ZERO_INT);
        return toAjax(memberService.updateBatch(req.getIds(), update));
    }

    /**
     * 开支付
     */
    @PreAuthorize("@ss.hasPermi('business:member:allow_pay')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/allowPay")
    public AjaxResult allowPay(@RequestBody BatchRequest req) {
        Member update = new Member();
        update.setLevelId(Constants.TWO_INT);
        return toAjax(memberService.updateBatch(req.getIds(), update));
    }

    /**
     * 开所有
     */
    @PreAuthorize("@ss.hasPermi('business:member:allow_pay_all')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/allowPayAll")
    public AjaxResult allowPayAll() {
        Member update = new Member();
        update.setCanPay(Constants.ONE_INT);
        return toAjax(memberService.updateAll(update));
    }

    /**
     * 关所有
     */
    @PreAuthorize("@ss.hasPermi('business:member:ban_pay_all')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/banPayAll")
    public AjaxResult banPayAll() {
        Member update = new Member();
        update.setCanPay(Constants.ZERO_INT);
        return toAjax(memberService.updateAll(update));
    }

    /**
     * 关节点
     */
    @PreAuthorize("@ss.hasPermi('business:member:allow_pay_batch')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/closeBatch")
    public AjaxResult openAll(@RequestBody BatchAddrsRequest req) {
        String mainAccounts = req.getAddrs();
        String[] split = mainAccounts.split("\n");
        Member member;
        List<Long> ids = new ArrayList<>();
        List<String> invalidAccounts = new ArrayList<>();
        for (String mainAccount : split) {
            if (StringUtils.hasText(mainAccount.trim())) {
                member = memberService.selectByMainAccout(mainAccount.trim());
                if (member != null) {
                    ids.add(member.getId());
                } else {
                    invalidAccounts.add(mainAccount);
                }
            }
        }
        if (ids.isEmpty()) {
            return success(invalidAccounts);
        }
        Member update = new Member();
        update.setLevelId(Constants.ZERO_INT);
        memberService.updateBatch(ids, update);
        return success(invalidAccounts);
    }

    /**
     * 开节点
     */
    @PreAuthorize("@ss.hasPermi('business:member:allow_pay_batch')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/openBatch")
    public AjaxResult closeAll(@RequestBody BatchAddrsRequest req) {
        String mainAccounts = req.getAddrs();
        String[] split = mainAccounts.split("\n");
        Member member;
        List<Long> ids = new ArrayList<>();
        List<String> invalidEmails = new ArrayList<>();
        for (String mainAccount : split) {
            if (StringUtils.hasText(mainAccount.trim())) {
                member = memberService.selectByMainAccout(mainAccount.trim());
                if (member != null) {
                    ids.add(member.getId());
                } else {
                    invalidEmails.add(mainAccount);
                }
            }
        }
        if (ids.isEmpty()) {
            return success(invalidEmails);
        }
        Member update = new Member();
        update.setLevelId(Constants.TWO_INT);
        memberService.updateBatch(ids, update);
        return success(invalidEmails);
    }

    /**
     * 换绑邮箱
     */
    @PreAuthorize("@ss.hasPermi('business:member:changeEmail')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping("/changeEmail")
    public AjaxResult changeEmail(@RequestBody ChangeEmailRequest req) {
        Member update = BeanCopior.map(req, Member.class);
        return toAjax(memberService.updateChangeMainAccount(update));
    }
}
