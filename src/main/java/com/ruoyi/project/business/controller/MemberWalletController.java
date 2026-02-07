package com.ruoyi.project.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.domain.MemberWallet;
import com.ruoyi.project.business.service.IMemberWalletService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户钱包Controller
 *
 * @author gpthk
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/business/member_wallet")
public class MemberWalletController extends BaseController
{
    @Autowired
    private IMemberWalletService memberWalletService;

    /**
     * 查询用户钱包列表
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:list')")
    @GetMapping("/list")
    public TableDataInfo list(MemberWallet memberWallet){
        startPage();
        List<MemberWallet> list = null;
        if (memberWallet.getUid() != null || StringUtils.hasText(memberWallet.getAccount())) {
            if (Constants.ONE_INT.equals(memberWallet.getRelate())) {
                list = memberWalletService.listWithChildren(memberWallet);
            } else if (Constants.ZERO_INT.equals(memberWallet.getRelate())) {
                list = memberWalletService.listWithParents(memberWallet);
            }
        }
        if (list == null) {
            list = memberWalletService.selectMemberWalletList(memberWallet);
        }
        return getDataTable(list);
    }


    /**
     * 导出用户钱包列表
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:export')")
    @Log(title = "用户钱包", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberWallet memberWallet){
        List<MemberWallet> list = null;
        if (memberWallet.getUid() != null || StringUtils.hasText(memberWallet.getAccount())) {
            if (Constants.ONE_INT.equals(memberWallet.getRelate())) {
                list = memberWalletService.listWithChildren(memberWallet);
            } else if (Constants.ZERO_INT.equals(memberWallet.getRelate())) {
                list = memberWalletService.listWithParents(memberWallet);
            }
        }
        if (list == null) {
            list = memberWalletService.selectMemberWalletList(memberWallet);
        }
        ExcelUtil<MemberWallet> util = new ExcelUtil<MemberWallet>(MemberWallet.class);
        util.exportExcel(response, list, "用户钱包数据");
    }

    /**
     * 获取用户钱包详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberWalletService.selectMemberWalletById(id));
    }

    /**
     * 新增用户钱包
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:add')")
    @Log(title = "用户钱包", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberWallet memberWallet)
    {
        return toAjax(memberWalletService.insertMemberWallet(memberWallet));
    }

    /**
     * 修改用户钱包
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:edit')")
    @Log(title = "用户钱包", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberWallet memberWallet)
    {
        return toAjax(memberWalletService.updateMemberWallet(memberWallet));
    }

    /**
     * 删除用户钱包
     */
    @PreAuthorize("@ss.hasPermi('business:member_wallet:remove')")
    @Log(title = "用户钱包", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberWalletService.deleteMemberWalletByIds(ids));
    }
}
