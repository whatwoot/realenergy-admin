package com.ruoyi.project.business.service.impl;

import cn.hutool.extra.spring.SpringUtil;
import com.ruoyi.project.business.domain.ReleaseVer;
import com.ruoyi.project.business.event.AppReleaseEvent;
import com.ruoyi.project.business.mapper.ReleaseVerMapper;
import com.ruoyi.project.business.service.IReleaseVerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * APP发版Service业务层处理
 *
 * @author gpthk
 * @date 2025-05-13
 */
@Service
public class ReleaseVerServiceImpl implements IReleaseVerService {
    @Autowired
    private ReleaseVerMapper releaseVerMapper;

    /**
     * 查询APP发版
     *
     * @param id APP发版主键
     * @return APP发版
     */
    @Override
    public ReleaseVer selectReleaseVerById(Long id) {
        return releaseVerMapper.selectReleaseVerById(id);
    }

    /**
     * 查询APP发版列表
     *
     * @param releaseVer APP发版
     * @return APP发版
     */
    @Override
    public List<ReleaseVer> selectReleaseVerList(ReleaseVer releaseVer) {
        return releaseVerMapper.selectReleaseVerList(releaseVer);
    }

    /**
     * 新增APP发版
     *
     * @param releaseVer APP发版
     * @return 结果
     */
    @Override
    public int insertReleaseVer(ReleaseVer releaseVer) {
        releaseVer.setCreateTime(null);
        releaseVer.setCreateAt(System.currentTimeMillis());
        int i = releaseVerMapper.insertReleaseVer(releaseVer);
        SpringUtil.publishEvent(new AppReleaseEvent(this, releaseVer));
        return i;
    }

    /**
     * 修改APP发版
     *
     * @param releaseVer APP发版
     * @return 结果
     */
    @Override
    public int updateReleaseVer(ReleaseVer releaseVer) {
        int i = releaseVerMapper.updateReleaseVer(releaseVer);
        SpringUtil.publishEvent(new AppReleaseEvent(this, releaseVer));
        return i;
    }

    /**
     * 批量删除APP发版
     *
     * @param ids 需要删除的APP发版主键
     * @return 结果
     */
    @Override
    public int deleteReleaseVerByIds(Long[] ids) {
        int i = releaseVerMapper.deleteReleaseVerByIds(ids);
        return i;
    }

    /**
     * 删除APP发版信息
     *
     * @param id APP发版主键
     * @return 结果
     */
    @Override
    public int deleteReleaseVerById(Long id) {
        return releaseVerMapper.deleteReleaseVerById(id);
    }
}
