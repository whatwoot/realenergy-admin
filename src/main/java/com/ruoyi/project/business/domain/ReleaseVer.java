package com.ruoyi.project.business.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * APP发版对象 app_release_ver
 *
 * @author gpthk
 * @date 2025-05-13
 */
@Data
public class ReleaseVer extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 平台 */
    @Excel(name = "平台")
    private String platform;

    /** 版本 */
    @Excel(name = "版本")
    private String ver;

    /** 最低版本要求 */
    @Excel(name = "最低版本要求")
    private String lowestVer;

    /** 强制更新 */
    @Excel(name = "强制更新")
    private Integer forceUpdate;

    /** 更新内容 */
    @Excel(name = "更新内容")
    private String updates;
    @Excel(name = "更新内容-繁体")
    private String updatesZhTw;
    @Excel(name = "更新内容-英语")
    private String updatesEnUs;
    @Excel(name = "更新内容-韩语")
    private String updatesKoKr;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    @Excel(name = "下载方式。file=直接下载,thdapi=三方api,appstore=跳转下载")
    private String downType;
    /** 直接下载链接 */
    @Excel(name = "直接下载链接")
    private String downloadUrl;

    /** 跳转下载页 */
    @Excel(name = "跳转下载页")
    private String jumpUrl;

    @Excel(name = "官方appStore下载地址")
    private String appStoreUrl;

    /** 创建于 */
    @Excel(name = "创建于")
    private Long createAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("platform", getPlatform())
            .append("ver", getVer())
            .append("lowestVer", getLowestVer())
            .append("forceUpdate", getForceUpdate())
            .append("updates", getUpdates())
            .append("status", getStatus())
            .append("downloadUrl", getDownloadUrl())
            .append("jumpUrl", getJumpUrl())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .toString();
    }
}
