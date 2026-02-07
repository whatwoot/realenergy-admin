package com.ruoyi.project.business.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.Login;
import com.ruoyi.project.business.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录账户Controller
 *
 * @author gpthk
 * @date 2025-03-15
 */
@RestController
@RequestMapping("/business/login")
public class LoginController extends BaseController {
    @Autowired
    private ILoginService loginService;

    /**
     * 查询登录账户列表
     */
    @PreAuthorize("@ss.hasPermi('business:login:list')")
    @GetMapping("/list")
    public TableDataInfo list(Login login) {
        startPage();
        List<Login> list = loginService.selectLoginList(login);
        return getDataTable(list);
    }

    /**
     * 导出登录账户列表
     */
    @PreAuthorize("@ss.hasPermi('business:login:export')")
    @Log(title = "登录账户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Login login) {
        List<Login> list = loginService.selectLoginList(login);
        ExcelUtil<Login> util = new ExcelUtil<Login>(Login.class);
        util.exportExcel(response, list, "登录账户数据");
    }

    /**
     * 获取登录账户详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:login:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(loginService.selectLoginById(id));
    }

    /**
     * 新增登录账户
     */
    @PreAuthorize("@ss.hasPermi('business:login:add')")
    @Log(title = "登录账户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Login login) {
        return toAjax(loginService.insertLogin(login));
    }

    /**
     * 修改登录账户
     */
    @PreAuthorize("@ss.hasPermi('business:login:edit')")
    @Log(title = "登录账户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Login login) {
        return toAjax(loginService.updateLogin(login));
    }

    /**
     * 删除登录账户
     */
    @PreAuthorize("@ss.hasPermi('business:login:remove')")
    @Log(title = "登录账户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loginService.deleteLoginByIds(ids));
    }
}
