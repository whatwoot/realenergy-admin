package com.ruoyi.project.business.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseMemEntity;
import com.ruoyi.project.handler.LongTimeHandler;
/**
 * 商家申请对象 p_merchant_apply
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Data
public class MerchantApply extends BaseMemEntity{

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

    /** 法人姓名 */
    @Excel(name = "法人姓名")
    private String legalName;

    /** 营业执照号码 */
    @Excel(name = "营业执照号码")
    private String licenseNum;

    /** 营业执照图片 */
    @Excel(name = "营业执照图片")
    private String licenseUrl;

    /** 国家代号 */
    @Excel(name = "国家代号")
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

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    @Schema(description = "门店照片")
    private String photoUrl;

    @Excel(name = "业务类型")
    private String businessType;

    /** 描述 */
    @Excel(name = "描述")
    private String message;

    /** 创建于 */
    @Excel(name = "创建于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    /** 申请于 */
    @Excel(name = "申请于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long applyAt;

    /** 审核于 */
    @Excel(name = "审核于", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long auditAt;

    /** $column.columnComment */
    private Long deleted;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("pid", getPid())
            .append("name", getName())
            .append("legalName", getLegalName())
            .append("licenseNum", getLicenseNum())
            .append("licenseUrl", getLicenseUrl())
            .append("countryCode", getCountryCode())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("address", getAddress())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("contact", getContact())
            .append("status", getStatus())
            .append("message", getMessage())
            .append("createAt", getCreateAt())
            .append("applyAt", getApplyAt())
            .append("auditAt", getAuditAt())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .toString();
    }
}
