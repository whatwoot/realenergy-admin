package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Apikey;

/**
 * 平台APIService接口
 *
 * @author gpthk
 * @date 2026-01-05
 */
public interface IApikeyService {
    /**
     * 查询平台API
     *
     * @param id 平台API主键
     * @return 平台API
     */
    Apikey selectApikeyById(Long id);

    /**
     * 查询平台API列表
     *
     * @param apikey 平台API
     * @return 平台API集合
     */
    List<Apikey> selectApikeyList(Apikey apikey);

    /**
     * 新增平台API
     *
     * @param apikey 平台API
     * @return 结果
     */
     int insertApikey(Apikey apikey);

    /**
     * 修改平台API
     *
     * @param apikey 平台API
     * @return 结果
     */
     int updateApikey(Apikey apikey);

    /**
     * 批量删除平台API
     *
     * @param ids 需要删除的平台API主键集合
     * @return 结果
     */
     int deleteApikeyByIds(Long[] ids);

    /**
     * 删除平台API信息
     *
     * @param id 平台API主键
     * @return 结果
     */
     int deleteApikeyById(Long id);
}
