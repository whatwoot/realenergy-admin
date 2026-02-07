package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.OrderMapper;
import com.ruoyi.project.business.domain.Order;
import com.ruoyi.project.business.service.IOrderService;

/**
 * 支付订单Service业务层处理
 *
 * @author gpthk
 * @date 2025-05-20
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询支付订单
     *
     * @param id 支付订单主键
     * @return 支付订单
     */
    @Override
    public Order selectOrderById(Long id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询支付订单列表
     *
     * @param order 支付订单
     * @return 支付订单
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增支付订单
     *
     * @param order 支付订单
     * @return 结果
     */
    @Override
    public int insertOrder(Order order) {
        order.setCreateTime(null);
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改支付订单
     *
     * @param order 支付订单
     * @return 结果
     */
    @Override
    public int updateOrder(Order order)
    {
        order.setUpdateTime(null);
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除支付订单
     *
     * @param ids 需要删除的支付订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(Long[] ids)
    {
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除支付订单信息
     *
     * @param id 支付订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderById(Long id)
    {
        return orderMapper.deleteOrderById(id);
    }

    @Override
    public List<Order> listWithChildren(Order entity) {
        return orderMapper.listWithChildren(entity);
    }

    @Override
    public List<Order> listWithParents(Order  entity) {
        return orderMapper.listWithParents(entity);
    }
}
