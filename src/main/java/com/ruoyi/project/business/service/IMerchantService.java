package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Merchant;

/**
 * 商家列表Service接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface IMerchantService {
    /**
     * 查询商家列表
     *
     * @param id 商家列表主键
     * @return 商家列表
     */
    Merchant selectMerchantById(Long id);

    /**
     * 查询商家列表列表
     *
     * @param merchant 商家列表
     * @return 商家列表集合
     */
    List<Merchant> selectMerchantList(Merchant merchant);

    /**
     * 新增商家列表
     *
     * @param merchant 商家列表
     * @return 结果
     */
     int insertMerchant(Merchant merchant);

    /**
     * 修改商家列表
     *
     * @param merchant 商家列表
     * @return 结果
     */
     int updateMerchant(Merchant merchant);

    /**
     * 批量删除商家列表
     *
     * @param ids 需要删除的商家列表主键集合
     * @return 结果
     */
     int deleteMerchantByIds(Long[] ids);

    /**
     * 删除商家列表信息
     *
     * @param id 商家列表主键
     * @return 结果
     */
     int deleteMerchantById(Long id);

     List<Merchant> listWithChildren(Merchant entity);

     List<Merchant> listWithParents(Merchant entity);

    int updateBatch(Merchant merchant, List<Long> ids);
}
