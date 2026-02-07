package com.ruoyi.project.business.mapper;

import java.util.List;
import com.ruoyi.project.business.domain.MerchantApply;

/**
 * 商家申请Mapper接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface MerchantApplyMapper {
    /**
     * 查询商家申请
     *
     * @param id 商家申请主键
     * @return 商家申请
     */
    MerchantApply selectMerchantApplyById(Long id);

    /**
     * 查询商家申请列表
     *
     * @param merchantApply 商家申请
     * @return 商家申请集合
     */
    List<MerchantApply> selectMerchantApplyList(MerchantApply merchantApply);

    /**
     * 新增商家申请
     *
     * @param merchantApply 商家申请
     * @return 结果
     */
    int insertMerchantApply(MerchantApply merchantApply);

    /**
     * 修改商家申请
     *
     * @param merchantApply 商家申请
     * @return 结果
     */
    int updateMerchantApply(MerchantApply merchantApply);

    /**
     * 删除商家申请
     *
     * @param id 商家申请主键
     * @return 结果
     */
    int deleteMerchantApplyById(Long id);

    /**
     * 批量删除商家申请
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMerchantApplyByIds(Long[] ids);

    List<MerchantApply> listWithChildren(MerchantApply entity);

    List<MerchantApply> listWithParents(MerchantApply entity);
}
