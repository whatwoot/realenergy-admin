package com.ruoyi.project.business.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.domain.Config;
import com.ruoyi.project.business.mapper.ConfigMapper;
import com.ruoyi.project.business.service.IConfigService;
import com.cs.sp.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 系统配置Service业务层处理
 *
 * @author gpthk
 * @date 2024-04-21
 */
@Service
public class ConfigServiceImpl implements IConfigService {
    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AppProperties appProperties;
    /**
     * 查询系统配置
     *
     * @param id 系统配置主键
     * @return 系统配置
     */
    @Override
    public Config selectConfigById(Long id) {
        return configMapper.selectConfigById(id);
    }

    /**
     * 查询系统配置列表
     *
     * @param config 系统配置
     * @return 系统配置
     */
    @Override
    public List<Config> selectConfigList(Config config) {
        return configMapper.selectConfigList(config);
    }

    /**
     * 新增系统配置
     *
     * @param config 系统配置
     * @return 结果
     */
    @Override
    public int insertConfig(Config config) {
        config.setCreateTime(null);
        int i = configMapper.insertConfig(config);
        String body = HttpRequest.get(appProperties.getPrefix() + AppApi.REFRESH_CONFIG).execute().body();
        JSONObject json = JSONObject.parseObject(body);
        if (!Constant.ZERO_STR.equals(json.getString("code"))) {
            throwBizException(json.getString("msg"));
        }
        return i;
    }

    /**
     * 修改系统配置
     *
     * @param config 系统配置
     * @return 结果
     */
    @Override
    public int updateConfig(Config config) {
        config.setUpdateTime(null);
        int i = configMapper.updateConfig(config);
        String body = HttpRequest.get(appProperties.getPrefix() + AppApi.REFRESH_CONFIG).execute().body();
        JSONObject json = JSONObject.parseObject(body);
        if (!Constant.ZERO_STR.equals(json.getString("code"))) {
            throwBizException(json.getString("msg"));
        }
        return i;
    }

    /**
     * 批量删除系统配置
     *
     * @param ids 需要删除的系统配置主键
     * @return 结果
     */
    @Override
    public int deleteConfigByIds(Long[] ids) {
        return configMapper.deleteConfigByIds(ids);
    }

    /**
     * 删除系统配置信息
     *
     * @param id 系统配置主键
     * @return 结果
     */
    @Override
    public int deleteConfigById(Long id) {
        return configMapper.deleteConfigById(id);
    }
}
