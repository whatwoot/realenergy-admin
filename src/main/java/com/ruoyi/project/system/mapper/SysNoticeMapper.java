package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.SysNotice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 通知公告表 数据层
 * 
 * @author ruoyi
 */
public interface SysNoticeMapper
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除公告
     * 
     * @param noticeId 公告ID
     * @return 结果
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] noticeIds);

    @Select({
            "<script>",
            "SELECT remark FROM sys_notice",
            "WHERE remark IN",
            "<foreach item='remark' collection='remarks' open='(' separator=',' close=')'>",
            "#{remark}",
            "</foreach>",
            "</script>"
    })
    List<String> selectByRemark(@Param("remarks") List<String> remarks);

    @Insert("INSERT INTO sys_notice (" +
            "notice_title, notice_type, notice_content, status, remark, create_by, create_time" +
            ") VALUES (" +
            "#{noticeTitle}, #{noticeType}, #{noticeContent}, #{status}, #{remark}, #{createBy}, #{createTime}" +
            ")")
    int insertOne(SysNotice sysNotice);
}