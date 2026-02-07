package com.ruoyi.project.business.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.ChainAddress;
import com.ruoyi.project.business.service.IChainAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 钱包列表Controller
 *
 * @author gpthk
 * @date 2025-01-11
 */
@RestController
@RequestMapping("/business/chain_address")
public class ChainAddressController extends BaseController {
    @Autowired
    private IChainAddressService chainAddressService;

    /**
     * 查询钱包列表列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChainAddress chainAddress) {
        startPage();
        List<ChainAddress> list = chainAddressService.selectChainAddressList(chainAddress);
        return getDataTable(list);
    }

    /**
     * 导出钱包列表列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:export')")
    @Log(title = "钱包列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChainAddress chainAddress) {
        List<ChainAddress> list = chainAddressService.selectChainAddressList(chainAddress);
        ExcelUtil<ChainAddress> util = new ExcelUtil<ChainAddress>(ChainAddress.class);
        util.exportExcel(response, list, "钱包列表数据");
    }

    /**
     * 获取钱包列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chainAddressService.selectChainAddressById(id));
    }

    /**
     * 新增钱包列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:add')")
    @Log(title = "钱包列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChainAddress chainAddress) {
        return toAjax(chainAddressService.insertChainAddress(chainAddress));
    }

    /**
     * 修改钱包列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:edit')")
    @Log(title = "钱包列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChainAddress chainAddress) {
        return toAjax(chainAddressService.updateChainAddress(chainAddress));
    }

    /**
     * 删除钱包列表
     */
    @PreAuthorize("@ss.hasPermi('business:chain_address:remove')")
    @Log(title = "钱包列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chainAddressService.deleteChainAddressByIds(ids));
    }
}
