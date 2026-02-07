package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Copyer;

/**
 * 用户跟单Service接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface ICopyerService {
    /**
     * 查询用户跟单
     *
     * @param id 用户跟单主键
     * @return 用户跟单
     */
    Copyer selectCopyerById(Long id);

    /**
     * 查询用户跟单列表
     *
     * @param copyer 用户跟单
     * @return 用户跟单集合
     */
    List<Copyer> selectCopyerList(Copyer copyer);

    /**
     * 新增用户跟单
     *
     * @param copyer 用户跟单
     * @return 结果
     */
     int insertCopyer(Copyer copyer);

    /**
     * 修改用户跟单
     *
     * @param copyer 用户跟单
     * @return 结果
     */
     int updateCopyer(Copyer copyer);

    /**
     * 批量删除用户跟单
     *
     * @param ids 需要删除的用户跟单主键集合
     * @return 结果
     */
     int deleteCopyerByIds(Long[] ids);

    /**
     * 删除用户跟单信息
     *
     * @param id 用户跟单主键
     * @return 结果
     */
     int deleteCopyerById(Long id);
}
