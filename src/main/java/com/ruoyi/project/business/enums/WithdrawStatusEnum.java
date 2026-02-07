package com.ruoyi.project.business.enums;

import lombok.Getter;

/**
 * @author quzhimin
 * @date 2024/10/3 17:32
 */
@Getter
public enum WithdrawStatusEnum {
    /**
     * 状态。0=已提交，1=已完成，2=确认中
     */
    COMMIT(0, "已提交"),
    DONE(1, "已完成"),
    CONFIRMING(2, "进行中"),
    REFUND(3, "已退款"),
    TRANSFERING(4,"转账中"),
    AUDITED(5, "已审核")

    ;
    
    private Integer code;
    private String msg;
    
    WithdrawStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
     
    public static WithdrawStatusEnum of(Integer code){
        for(WithdrawStatusEnum value: values()){
            if(value.eq(code)){
                return value;            
            }
        }
        return null;
    }
    
    public boolean eq(Integer code){
        return this.getCode().equals(code);
    }
}
