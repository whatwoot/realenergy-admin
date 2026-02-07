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
import com.ruoyi.project.business.domain.Order;
import com.ruoyi.project.business.service.IOrderService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.util.StringUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 支付订单Controller
 *
 * @author gpthk
 * @date 2025-05-20
 */
@RestController
@RequestMapping("/business/order")
public class OrderController extends BaseController
{
    @Autowired
    private IOrderService orderService;

    /**
     * 查询支付订单列表
     */
    @PreAuthorize("@ss.hasPermi('business:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(Order order){
        startPage();
        List<Order> list = null;
        if (order.getUid() != null || StringUtils.hasText(order.getAccount())) {
            if (Constants.ONE_INT.equals(order.getRelate())) {
                list = orderService.listWithChildren(order);
            } else if (Constants.ZERO_INT.equals(order.getRelate())) {
                list = orderService.listWithParents(order);
            }
        }
        if (list == null) {
            list = orderService.selectOrderList(order);
        }
        return getDataTable(list);
    }


    /**
     * 导出支付订单列表
     */
    @PreAuthorize("@ss.hasPermi('business:order:export')")
    @Log(title = "支付订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order){
        List<Order> list = null;
        if (order.getUid() != null || StringUtils.hasText(order.getAccount())) {
            if (Constants.ONE_INT.equals(order.getRelate())) {
                list = orderService.listWithChildren(order);
            } else if (Constants.ZERO_INT.equals(order.getRelate())) {
                list = orderService.listWithParents(order);
            }
        }
        if (list == null) {
            list = orderService.selectOrderList(order);
        }
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "支付订单数据");
    }

    /**
     * 获取支付订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderService.selectOrderById(id));
    }

    /**
     * 新增支付订单
     */
    @PreAuthorize("@ss.hasPermi('business:order:add')")
    @Log(title = "支付订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Order order)
    {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改支付订单
     */
    @PreAuthorize("@ss.hasPermi('business:order:edit')")
    @Log(title = "支付订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Order order)
    {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除支付订单
     */
    @PreAuthorize("@ss.hasPermi('business:order:remove')")
    @Log(title = "支付订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderService.deleteOrderByIds(ids));
    }
}
