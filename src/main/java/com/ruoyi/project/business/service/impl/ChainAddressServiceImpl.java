package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.ChainAddressMapper;
import com.ruoyi.project.business.domain.ChainAddress;
import com.ruoyi.project.business.service.IChainAddressService;

/**
 * 钱包列表Service业务层处理
 *
 * @author gpthk
 * @date 2025-01-11
 */
@Service
public class ChainAddressServiceImpl implements IChainAddressService {
    @Autowired
    private ChainAddressMapper chainAddressMapper;

    /**
     * 查询钱包列表
     *
     * @param id 钱包列表主键
     * @return 钱包列表
     */
    @Override
    public ChainAddress selectChainAddressById(Long id)
    {
        return chainAddressMapper.selectChainAddressById(id);
    }

    /**
     * 查询钱包列表列表
     *
     * @param chainAddress 钱包列表
     * @return 钱包列表
     */
    @Override
    public List<ChainAddress> selectChainAddressList(ChainAddress chainAddress)
    {
        return chainAddressMapper.selectChainAddressList(chainAddress);
    }

    /**
     * 新增钱包列表
     *
     * @param chainAddress 钱包列表
     * @return 结果
     */
    @Override
    public int insertChainAddress(ChainAddress chainAddress) {
        chainAddress.setCreateTime(null);
        return chainAddressMapper.insertChainAddress(chainAddress);
    }

    /**
     * 修改钱包列表
     *
     * @param chainAddress 钱包列表
     * @return 结果
     */
    @Override
    public int updateChainAddress(ChainAddress chainAddress) {
        return chainAddressMapper.updateChainAddress(chainAddress);
    }

    /**
     * 批量删除钱包列表
     *
     * @param ids 需要删除的钱包列表主键
     * @return 结果
     */
    @Override
    public int deleteChainAddressByIds(Long[] ids)
    {
        return chainAddressMapper.deleteChainAddressByIds(ids);
    }

    /**
     * 删除钱包列表信息
     *
     * @param id 钱包列表主键
     * @return 结果
     */
    @Override
    public int deleteChainAddressById(Long id)
    {
        return chainAddressMapper.deleteChainAddressById(id);
    }
}
