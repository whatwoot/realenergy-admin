package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.Merchant;
import org.apache.ibatis.annotations.Param;

/**
 * 商家列表Mapper接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface MerchantMapper {
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
     * 删除商家列表
     *
     * @param id 商家列表主键
     * @return 结果
     */
    int deleteMerchantById(Long id);

    /**
     * 批量删除商家列表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMerchantByIds(Long[] ids);

    List<Merchant> listWithChildren(Merchant entity);

    List<Merchant> listWithParents(Merchant entity);

    int updateBatch(@Param("e") Merchant merchant, @Param("ids") List<Long> ids);
}
