package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Config;

/**
 * 系统配置Service接口
 *
 * @author gpthk
 * @date 2024-04-21
 */
public interface IConfigService {
    /**
     * 查询系统配置
     *
     * @param id 系统配置主键
     * @return 系统配置
     */
    Config selectConfigById(Long id);

    /**
     * 查询系统配置列表
     *
     * @param config 系统配置
     * @return 系统配置集合
     */
    List<Config> selectConfigList(Config config);

    /**
     * 新增系统配置
     *
     * @param config 系统配置
     * @return 结果
     */
     int insertConfig(Config config);

    /**
     * 修改系统配置
     *
     * @param config 系统配置
     * @return 结果
     */
     int updateConfig(Config config);

    /**
     * 批量删除系统配置
     *
     * @param ids 需要删除的系统配置主键集合
     * @return 结果
     */
     int deleteConfigByIds(Long[] ids);

    /**
     * 删除系统配置信息
     *
     * @param id 系统配置主键
     * @return 结果
     */
     int deleteConfigById(Long id);
}
