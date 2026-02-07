package com.ruoyi.project.business.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.business.domain.Merchant;
import com.ruoyi.project.business.dto.BatchRequest;
import com.ruoyi.project.business.service.IMerchantService;
import com.cs.sp.enums.YesNoByteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.cs.sp.common.WebAssert.expectNotEmpty;
import static com.cs.sp.common.WebAssert.isNotNull;

/**
 * 商家列表Controller
 *
 * @author gpthk
 * @date 2025-03-25
 */
@RestController
@RequestMapping("/business/merchant")
public class MerchantController extends BaseController {
    @Autowired
    private IMerchantService merchantService;

    /**
     * 查询商家列表列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:list')")
    @GetMapping("/list")
    public TableDataInfo list(Merchant merchant) {
        startPage();
        List<Merchant> list = null;
        if (merchant.getUid() != null || StringUtils.hasText(merchant.getAccount())) {
            if (Constants.ONE_INT.equals(merchant.getRelate())) {
                list = merchantService.listWithChildren(merchant);
            } else if (Constants.ZERO_INT.equals(merchant.getRelate())) {
                list = merchantService.listWithParents(merchant);
            }
        }
        if (list == null) {
            list = merchantService.selectMerchantList(merchant);
        }
        return getDataTable(list);
    }


    /**
     * 导出商家列表列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:export')")
    @Log(title = "商家列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Merchant merchant) {
        List<Merchant> list = null;
        if (merchant.getUid() != null || StringUtils.hasText(merchant.getAccount())) {
            if (Constants.ONE_INT.equals(merchant.getRelate())) {
                list = merchantService.listWithChildren(merchant);
            } else if (Constants.ZERO_INT.equals(merchant.getRelate())) {
                list = merchantService.listWithParents(merchant);
            }
        }
        if (list == null) {
            list = merchantService.selectMerchantList(merchant);
        }
        ExcelUtil<Merchant> util = new ExcelUtil<Merchant>(Merchant.class);
        util.exportExcel(response, list, "商家列表数据");
    }

    /**
     * 获取商家列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(merchantService.selectMerchantById(id));
    }

    /**
     * 新增商家列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:add')")
    @Log(title = "商家列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Merchant merchant) {
        return toAjax(merchantService.insertMerchant(merchant));
    }

    /**
     * 修改商家列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:edit')")
    @Log(title = "商家列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Merchant merchant) {
        return toAjax(merchantService.updateMerchant(merchant));
    }

    /**
     * 删除商家列表
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:remove')")
    @Log(title = "商家列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(merchantService.deleteMerchantByIds(ids));
    }


    /**
     * 取消甄选
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:cancelPick')")
    @Log(title = "商家列表", businessType = BusinessType.UPDATE)
    @PutMapping("/cancelPick")
    public AjaxResult cancelPick(@RequestBody BatchRequest req) {
        isNotNull(req.getIds(), "不能为空");
        expectNotEmpty(req.getIds(), "不能为空");
        Merchant merchant = new Merchant();
        merchant.setCurated(YesNoByteEnum.NO.getCode());
        return toAjax(merchantService.updateBatch(merchant, req.getIds()));
    }

    /**
     * 添加甄选
     */
    @PreAuthorize("@ss.hasPermi('business:merchant:addPick')")
    @Log(title = "商家列表", businessType = BusinessType.UPDATE)
    @PutMapping("/addPick")
    public AjaxResult addPick(@RequestBody BatchRequest req) {
        isNotNull(req.getIds(), "不能为空");
        expectNotEmpty(req.getIds(), "不能为空");
        Merchant merchant = new Merchant();
        merchant.setCurated(YesNoByteEnum.YES.getCode());
        return toAjax(merchantService.updateBatch(merchant, req.getIds()));
    }
}
