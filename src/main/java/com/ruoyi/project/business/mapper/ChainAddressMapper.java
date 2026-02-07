package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.ChainAddress;

/**
 * 钱包列表Mapper接口
 *
 * @author gpthk
 * @date 2025-01-11
 */
public interface ChainAddressMapper {
    /**
     * 查询钱包列表
     *
     * @param id 钱包列表主键
     * @return 钱包列表
     */
    ChainAddress selectChainAddressById(Long id);

    /**
     * 查询钱包列表列表
     *
     * @param chainAddress 钱包列表
     * @return 钱包列表集合
     */
    List<ChainAddress> selectChainAddressList(ChainAddress chainAddress);

    /**
     * 新增钱包列表
     *
     * @param chainAddress 钱包列表
     * @return 结果
     */
    int insertChainAddress(ChainAddress chainAddress);

    /**
     * 修改钱包列表
     *
     * @param chainAddress 钱包列表
     * @return 结果
     */
    int updateChainAddress(ChainAddress chainAddress);

    /**
     * 删除钱包列表
     *
     * @param id 钱包列表主键
     * @return 结果
     */
    int deleteChainAddressById(Long id);

    /**
     * 批量删除钱包列表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteChainAddressByIds(Long[] ids);
}
