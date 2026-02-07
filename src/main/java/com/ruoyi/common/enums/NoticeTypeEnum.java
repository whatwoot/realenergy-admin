package com.ruoyi.common.enums;

/**
 * 通知类型
 */
public enum NoticeTypeEnum {
    Notice("1", "通知"),
    Announcement("2", "公告"),
    News("3", "新闻"),
    FlashNews("4", "快讯"),
    ;
    private final String code;
    private final String info;

    NoticeTypeEnum(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
