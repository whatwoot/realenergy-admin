package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.ReleaseVer;

/**
 * APP发版Service接口
 *
 * @author gpthk
 * @date 2025-05-13
 */
public interface IReleaseVerService {
    /**
     * 查询APP发版
     *
     * @param id APP发版主键
     * @return APP发版
     */
    ReleaseVer selectReleaseVerById(Long id);

    /**
     * 查询APP发版列表
     *
     * @param releaseVer APP发版
     * @return APP发版集合
     */
    List<ReleaseVer> selectReleaseVerList(ReleaseVer releaseVer);

    /**
     * 新增APP发版
     *
     * @param releaseVer APP发版
     * @return 结果
     */
     int insertReleaseVer(ReleaseVer releaseVer);

    /**
     * 修改APP发版
     *
     * @param releaseVer APP发版
     * @return 结果
     */
     int updateReleaseVer(ReleaseVer releaseVer);

    /**
     * 批量删除APP发版
     *
     * @param ids 需要删除的APP发版主键集合
     * @return 结果
     */
     int deleteReleaseVerByIds(Long[] ids);

    /**
     * 删除APP发版信息
     *
     * @param id APP发版主键
     * @return 结果
     */
     int deleteReleaseVerById(Long id);
}
