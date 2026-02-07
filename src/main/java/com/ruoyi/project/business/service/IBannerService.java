package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Banner;

/**
 * 轮播图Service接口
 *
 * @author gpthk
 * @date 2025-03-25
 */
public interface IBannerService {
    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    Banner selectBannerById(Long id);

    /**
     * 查询轮播图列表
     *
     * @param banner 轮播图
     * @return 轮播图集合
     */
    List<Banner> selectBannerList(Banner banner);

    /**
     * 新增轮播图
     *
     * @param banner 轮播图
     * @return 结果
     */
     int insertBanner(Banner banner);

    /**
     * 修改轮播图
     *
     * @param banner 轮播图
     * @return 结果
     */
     int updateBanner(Banner banner);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的轮播图主键集合
     * @return 结果
     */
     int deleteBannerByIds(Long[] ids);

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图主键
     * @return 结果
     */
     int deleteBannerById(Long id);
}
