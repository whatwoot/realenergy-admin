package com.ruoyi.project.business.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.handler.LongTimeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户对象 u_member
 *
 * @author gpthk
 * @date 2024-07-08
 */
@Data
public class Member extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Excel(name = "id")
    private Long id;

    /**
     * 账号搜索，会关联所有允许的账户
     */
    @Excel(name = "账号")
    private String mainAccount;

    /**
     * 关联方式，1=下级，0=上级
     */
    private Integer relate;
    /**
     * 层级
     */
    private Integer n;

    /**
     * 邀请人id
     */
    @Excel(name = "邀请人id")
    private Long pid;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
    private String nickname;


    /**
     * 头像
     */
    private String photoUrl;

    /**
     * 有效用户
     */
    @Excel(name = "有效用户", dictType = "member_invalid")
    private Integer valid;

    @Excel(name = "有效时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long validAt;

    @Excel(name = "注册来源")
    private String regSource;

    /**
     * 级别
     */
    @Excel(name = "级别", prefix = "H")
    private Integer levelId;
    @Excel(name = "邀请数量")
    private Integer inviteLevelId;

    /**
     * 可提现
     */
    @Excel(name = "可提现", dictType = "member_can_withdraw")
    private Integer canWithdraw;
    @Excel(name = "可支付", dictType = "common_yes_no")
    private Integer canPay;

    /**
     * 邀请码
     */
    @Excel(name = "邀请码")
    private String inviteCode;

    /**
     * 邀请总人数
     */
    private Long inviteNum;

    /**
     * 状态
     */
    @Excel(name = "状态", dictType = "member_status")
    private Integer status;

    /**
     * 注册时间
     */
    @Excel(name = "注册时间", width = 18, handler = LongTimeHandler.class, args = "yyyy-MM-dd HH:mm:ss")
    private Long regAt;

    @Schema(description = "国家代码")
    private Integer countryCode;
    private String country;

    @Schema(description = "全名")
    private String fullName;
    @Schema(description = "姓")
    private String familyName;
    @Schema(description = "名")
    private String givenName;

    @Schema(description = "国家代码")
    private Integer mobileCode;
    @Excel(name = "手机")
    private String mobile;

    @Schema(description = "性别。1=男,0=女")
    @Excel(name = "性别", readConverterExp = "1=男,0=女")
    private Byte gender;

    @Schema(description = "家庭住址")
    private String address;

    @Schema(description = "生日")
    private Integer birthday;



    @Schema(description = "货币")
    private String currency;
    @Schema(description = "完成注册向导。1=是,0=否")
    private Byte wizardEnd;
    @Schema(description = "完成注册于")
    private Long wizardEndAt;

    @Schema(description = "个人业绩")
    @Excel(name = "个人业绩")
    private BigDecimal performance;
    @Schema(description = "冻结业绩")
    private BigDecimal frozenPerformance;
    @Schema(description = "团队业绩")
    @Excel(name = "团队业绩")
    private BigDecimal teamPerformance;
    @Schema(description = "业绩更新于")
    private Long performanceUpdateAt;
    @Schema(description = "个人奖池")
    @Excel(name = "个人奖池")
    private BigDecimal prizeAmount;
    @Schema(description = "最近奖池派发日")
    @Excel(name = "最近奖池派发日")
    private Integer prizeBonusDay;

    @Schema(description = "备注")
    @Excel(name = "备注")
    private String memo;

    /**
     * 代理地区
     */
    @Schema(description = "代理地区")
    private String agentCode;

    /**
     * im群id
     */
    @Schema(description = "im群id")
    private String imGroupId;

    /**
     * 是否创世节点
     */
    @Schema(description = "是否创世节点")
    @Excel(name = "节点", readConverterExp = "0=否,1=是")
    private Integer genesis;

    /**
     * 有效直推人数
     */
    @Schema(description = "有效直推人数")
    private Integer validDirectInviteNum;

    /**
     * 直推人数
     */
    @Schema(description = "直推人数")
    private Integer directInviteNum;

    /**
     * 是否代理
     */
    @Schema(description = "是否代理")
    private Integer agented;

    /**
     * 社区
     */
    @Schema(description = "社区")
    private String community;

    /**
     * 冷却时间
     */
    @Schema(description = "冷却时间")
    private Long coolDownAt;

    /**
     * 锁仓总值
     */
    @Schema(description = "锁仓总值")
    private BigDecimal lockAmount;


    private Long codeDownAt;

    /**
     * 是否删除
     */
    private Long deleted;
}
