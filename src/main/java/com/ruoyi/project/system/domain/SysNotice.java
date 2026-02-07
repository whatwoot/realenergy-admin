package com.ruoyi.project.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.xss.Xss;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 通知公告表 sys_notice
 *
 * //
 * //    put("zh-CN", "ZhTw");
 * //    put("zh-TW", "ZhTw");
 * //    put("en-US", "EnUs");
 * //    put("ko-KR", "KoKr");
 * //    put("vi-VN", "ViVn");
 * //    put("ar-SA", "ArSa");
 *
 * EnUs
 * ZhTw
 * ZhCn
 * KoKr
 * RuRu
 * JaJp
 * DeDe
 * EsEs
 * ViVn
 * ArSA
 *
 * en_us
 * zh_tw
 * zh_cn
 * ko_kr
 * ru_ru
 * ja_jp
 * de_de
 * es_es
 * vi_vn
 * ar_sa
 * @author ruoyi
 */
@Data
public class SysNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Long noticeId;

    /** 公告标题 */
    private String noticeTitle;
    private String noticeTitleEnUs;
    private String noticeTitleZhTw;
    private String noticeTitleZhCn;
    private String noticeTitleKoKr;
    private String noticeTitleViVn;
    private String noticeTitleArSa;
    private String noticeTitleDeDe;
    private String noticeTitleEsEs;
    private String noticeTitleJaJp;
    private String noticeTitleRuRu;

    /** 公告类型（1通知 2公告） */
    private String noticeType;

    private String contentPrefix;
    private String contentPrefixEnUs;
    private String contentPrefixZhTw;
    private String contentPrefixZhCn;
    private String contentPrefixKoKr;
    private String contentPrefixViVn;
    private String contentPrefixArSa;
    private String contentPrefixDeDe;
    private String contentPrefixEsEs;
    private String contentPrefixJaJp;
    private String contentPrefixRuRu;

    private String coverUrl;
    private String coverUrlEnUs;
    private String coverUrlZhCn;
    private String coverUrlZhTw;
    private String coverUrlKoKr;
    private String coverUrlViVn;
    private String coverUrlArSa;
    private String coverUrlDeDe;
    private String coverUrlEsEs;
    private String coverUrlJaJp;
    private String coverUrlRuRu;

    /** 公告内容 */
    private String noticeContent;

    private String noticeContentEnUs;
    private String noticeContentZhTw;
    private String noticeContentZhCn;
    private String noticeContentKoKr;
    private String noticeContentDeDe;
    private String noticeContentEsEs;
    private String noticeContentJaJp;
    private String noticeContentRuRu;
    private String noticeContentViVn;
    private String noticeContentArSa;

    /** 公告状态（0正常 1关闭） */
    private String status;
}
