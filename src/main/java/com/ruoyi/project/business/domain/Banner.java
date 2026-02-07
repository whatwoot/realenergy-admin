package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 轮播图对象 s_banner
 *
 * //
 * //    put("zh-CN", "ZhTw");
 * //    put("zh-TW", "ZhTw");
 * //    put("en-US", "EnUs");
 * //    put("ko-KR", "KoKr");
 * //    put("vi-VN", "ViVn");
 * //    put("ar-SA", "ArSa");
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class Banner extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 位置 */
    @Excel(name = "位置")
    private String pos;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 标题-繁体 */
    @Excel(name = "标题-繁体")
    private String titleZhTw;

    /** 标题-英文 */
    @Excel(name = "标题-英文")
    private String titleEnUs;

    /** 标题-韩语 */
    @Excel(name = "标题-韩语")
    private String titleKoKr;



    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 内容-繁体 */
    @Excel(name = "内容-繁体")
    private String contentZhTw;

    /** 内容-英文 */
    @Excel(name = "内容-英文")
    private String contentEnUs;

    /** 内容-韩语 */
    @Excel(name = "内容-韩语")
    private String contentKoKr;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbUrl;

    /** 主图 */
    @Excel(name = "主图")
    private String imageUrl;

    /** 主图-繁体 */
    @Excel(name = "主图-繁体")
    private String imageUrlZhTw;

    /** 主图-英文 */
    @Excel(name = "主图-英文")
    private String imageUrlEnUs;

    /** 主图-韩语 */
    @Excel(name = "主图-韩语")
    private String imageUrlKoKr;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String jumpUrl;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 生效于 */
    @Excel(name = "生效于")
    private Long validAt;

    /** 失效于 */
    @Excel(name = "失效于")
    private Long invalidAt;

    /** 开始于 */
    @Excel(name = "开始于")
    private Long startAt;

    /** 结束于 */
    @Excel(name = "结束于")
    private Long endAt;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pos", getPos())
            .append("type", getType())
            .append("title", getTitle())
            .append("titleZhTw", getTitleZhTw())
            .append("titleEnUs", getTitleEnUs())
            .append("titleKoKr", getTitleKoKr())
            .append("content", getContent())
            .append("contentZhTw", getContentZhTw())
            .append("contentEnUs", getContentEnUs())
            .append("contentKoKr", getContentKoKr())
            .append("thumbUrl", getThumbUrl())
            .append("imageUrl", getImageUrl())
            .append("imageUrlZhTw", getImageUrlZhTw())
            .append("imageUrlEnUs", getImageUrlEnUs())
            .append("imageUrlKoKr", getImageUrlKoKr())
            .append("jumpUrl", getJumpUrl())
            .append("status", getStatus())
            .append("validAt", getValidAt())
            .append("invalidAt", getInvalidAt())
            .append("startAt", getStartAt())
            .append("endAt", getEndAt())
            .append("weight", getWeight())
            .append("memo", getMemo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
