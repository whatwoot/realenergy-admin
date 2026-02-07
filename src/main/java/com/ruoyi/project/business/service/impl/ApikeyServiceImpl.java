package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.ApikeyMapper;
import com.ruoyi.project.business.domain.Apikey;
import com.ruoyi.project.business.service.IApikeyService;

/**
 * 平台APIService业务层处理
 *
 * @author gpthk
 * @date 2026-01-05
 */
@Service
public class ApikeyServiceImpl implements IApikeyService {
    @Autowired
    private ApikeyMapper apikeyMapper;

    /**
     * 查询平台API
     *
     * @param id 平台API主键
     * @return 平台API
     */
    @Override
    public Apikey selectApikeyById(Long id)
    {
        return apikeyMapper.selectApikeyById(id);
    }

    /**
     * 查询平台API列表
     *
     * @param apikey 平台API
     * @return 平台API
     */
    @Override
    public List<Apikey> selectApikeyList(Apikey apikey)
    {
        return apikeyMapper.selectApikeyList(apikey);
    }

    /**
     * 新增平台API
     *
     * @param apikey 平台API
     * @return 结果
     */
    @Override
    public int insertApikey(Apikey apikey) {
        apikey.setCreateTime(null);
        return apikeyMapper.insertApikey(apikey);
    }

    /**
     * 修改平台API
     *
     * @param apikey 平台API
     * @return 结果
     */
    @Override
    public int updateApikey(Apikey apikey) {
        apikey.setUpdateTime(null);
        return apikeyMapper.updateApikey(apikey);
    }

    /**
     * 批量删除平台API
     *
     * @param ids 需要删除的平台API主键
     * @return 结果
     */
    @Override
    public int deleteApikeyByIds(Long[] ids)
    {
        return apikeyMapper.deleteApikeyByIds(ids);
    }

    /**
     * 删除平台API信息
     *
     * @param id 平台API主键
     * @return 结果
     */
    @Override
    public int deleteApikeyById(Long id)
    {
        return apikeyMapper.deleteApikeyById(id);
    }
}
