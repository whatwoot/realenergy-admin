package com.ruoyi.project.business.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 商家列表对象 p_merchant
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class Merchant extends BaseMemEntity{

    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** UID */
    @Excel(name = "UID")
    private Long uid;

    /** 父UID */
    @Excel(name = "父UID")
    private Long pid;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String name;

    /** 编码 */
    @Excel(name = "编码")
    private String code;

    /** 法人姓名 */
    @Excel(name = "法人姓名")
    private String legalName;

    /** 营业执照号码 */
    @Excel(name = "营业执照号码")
    private String licenseNum;

    /** 营业执照图片 */
    @Excel(name = "营业执照图片")
    private String licenseUrl;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    /** 国家区号 */
    @Excel(name = "国家区号")
    private Long countryCode;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String district;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 经度 */
    @Excel(name = "经度")
    private Double lon;

    /** 纬度 */
    @Excel(name = "纬度")
    private Double lat;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    @Excel(name = "甄选" ,readConverterExp="1=是,0=否")
    private Byte curated;

    @Schema(description = "门店照片")
    private String photoUrl;

    @Excel(name = "业务类型")
    @Schema(description = "业务类型")
    private String businessType;

    /** 自动提现 */
    @Excel(name = "自动提现")
    private Long autoWithdraw;

    /** 商户密 */
    @Excel(name = "商户密")
    private String secretKey;

    /** 商户码顺序号 */
    @Excel(name = "商户码顺序号")
    private Long qrIndex;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("pid", getPid())
            .append("name", getName())
            .append("code", getCode())
            .append("legalName", getLegalName())
            .append("licenseNum", getLicenseNum())
            .append("licenseUrl", getLicenseUrl())
            .append("contact", getContact())
            .append("countryCode", getCountryCode())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("address", getAddress())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("status", getStatus())
            .append("autoWithdraw", getAutoWithdraw())
            .append("secretKey", getSecretKey())
            .append("qrIndex", getQrIndex())
            .append("createAt", getCreateAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
