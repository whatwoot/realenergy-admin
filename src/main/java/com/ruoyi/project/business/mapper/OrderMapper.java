package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.Order;

/**
 * 支付订单Mapper接口
 *
 * @author gpthk
 * @date 2025-05-20
 */
public interface OrderMapper {
    /**
     * 查询支付订单
     *
     * @param id 支付订单主键
     * @return 支付订单
     */
    Order selectOrderById(Long id);

    /**
     * 查询支付订单列表
     *
     * @param order 支付订单
     * @return 支付订单集合
     */
    List<Order> selectOrderList(Order order);

    /**
     * 新增支付订单
     *
     * @param order 支付订单
     * @return 结果
     */
    int insertOrder(Order order);

    /**
     * 修改支付订单
     *
     * @param order 支付订单
     * @return 结果
     */
    int updateOrder(Order order);

    /**
     * 删除支付订单
     *
     * @param id 支付订单主键
     * @return 结果
     */
    int deleteOrderById(Long id);

    /**
     * 批量删除支付订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOrderByIds(Long[] ids);

    List<Order> listWithChildren(Order entity);

    List<Order> listWithParents(Order entity);
}
