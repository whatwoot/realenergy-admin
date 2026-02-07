package com.ruoyi.project.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.enums.NoticeTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.domain.SysNotice;
import com.ruoyi.project.system.mapper.SysNoticeMapper;
import com.ruoyi.project.system.service.ISysNoticeService;

/**
 * 公告 服务层实现
 *
 * @author ruoyi
 */
@Slf4j
@Service
public class SysNoticeServiceImpl implements ISysNoticeService {
    @Autowired
    private SysNoticeMapper noticeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId) {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice) {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice) {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     *
     * @param noticeId 公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long noticeId) {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * 批量删除公告信息
     *
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] noticeIds) {
        return noticeMapper.deleteNoticeByIds(noticeIds);
    }

    @Override
    public void fetchNews() {
        List<SysNotice> noticeList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        String body = HttpRequest.get("https://api.jinse.cn/noah/v2/lives?limit=20&reading=false&source=web&flag=down&id=0&category=0")
                .header("Accept-Language", "zh-CN")
                .execute().body();
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        JSONObject item;
        JSONArray lives;
        JSONObject news;
        for (int i = 0; i < jsonArray.size(); i++) {
             item = jsonArray.getJSONObject(i);
             lives = item.getJSONArray("lives");
            for (int j = 0; j < lives.size(); j++) {
                news = lives.getJSONObject(j);
                String contentPrefix = news.getString("content_prefix");
                String content = news.getString("content");
                boolean hasRwa = contentPrefix.contains("RWA") || contentPrefix.contains("rwa")
                        || content.contains("RWA") || content.contains("rwa");
                if(!hasRwa){
                    continue;
                }
                String id = news.getString("id");
                long createdAt = news.getLong("created_at") * 1000;
                idList.add(id);
                SysNotice sysNotice = new SysNotice();
                sysNotice.setNoticeTitle(contentPrefix);
                sysNotice.setNoticeType(NoticeTypeEnum.FlashNews.getCode());
                sysNotice.setNoticeContent(content);
                sysNotice.setStatus("0");
                sysNotice.setCreateBy("金色财经");
                sysNotice.setCreateTime(new Date(createdAt));
                sysNotice.setRemark(String.valueOf(id));
                noticeList.add(sysNotice);
            }
        }
        List<String> longs = noticeMapper.selectByRemark(idList);
        List<SysNotice> collect = noticeList.parallelStream().filter(sysNotice -> !longs.contains(sysNotice.getRemark())).collect(Collectors.toList());
        for (SysNotice sysNotice : collect) {
            noticeMapper.insertOne(sysNotice);
        }
    }
}
