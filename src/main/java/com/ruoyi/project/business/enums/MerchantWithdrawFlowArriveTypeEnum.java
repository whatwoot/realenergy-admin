package com.ruoyi.project.business.enums;

import lombok.Getter;

/**
 * @authro fun
 * @date 2025/4/12 15:39
 */
@Getter
public enum MerchantWithdrawFlowArriveTypeEnum {
    WX(1,"微信"),
    ALIPAY(2,"支付宝"),
    BSC(3,"BSC"),
    UNION(4,"聚合码"),
    ;
    
    private Integer code;
    private String msg;
    
    MerchantWithdrawFlowArriveTypeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
     
    public static MerchantWithdrawFlowArriveTypeEnum of(Integer code){
        for(MerchantWithdrawFlowArriveTypeEnum value: values()){
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
