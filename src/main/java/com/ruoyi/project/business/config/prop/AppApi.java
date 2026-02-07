package com.ruoyi.project.business.config.prop;

/**
 * @authro fun
 * @date 2025/3/27 16:21
 */
public interface AppApi {
    String MERCHANT_AUDIT = "/sapi/sys/auditMerchant";
    String MERCHANT_WITHDRAW_REFUND = "/sapi/sys/merchantWithdrawRefund";
    String WITHDRAW_REFUND = "/sapi/sys/withdrawRefund";
    String APP_RELEASE_REFRESH = "/sapi/appRelease/refreshAppRelease";
    String REFRESH_CONFIG = "/sapi/sys/refreshConfig";
    String WITHDRAW_AUDIT = "/sapi/sys/withdrawAudit";
    String APPLY_AUDIT = "/sapi/sys/applyFlow/audit";
    String PAYFLOW_REFUND = "/sapi/sys/payFlow/setToRefund";
    String PAYFLOW_OK = "/sapi/sys/payFlow/setToOk";


}
