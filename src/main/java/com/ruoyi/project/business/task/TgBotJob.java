package com.ruoyi.project.business.task;

import com.github.pagehelper.PageHelper;
import com.ruoyi.project.business.config.TgBotHelper;
import com.ruoyi.project.business.config.TgNotifyEvent;
import com.ruoyi.project.business.domain.AssetFlow;
import com.ruoyi.project.business.domain.MerchantAssetFlow;
import com.ruoyi.project.business.dto.AssetFlowGroupDTO;
import com.ruoyi.project.business.dto.MerchantAssetFlowReportDTO;
import com.ruoyi.project.business.dto.TgNotifyDTO;
import com.ruoyi.project.business.service.IAssetFlowService;
import com.ruoyi.project.business.service.IMerchantAssetFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

/**
 * @authro fun
 * @date 2025/4/25 22:07
 */
@Component
public class TgBotJob {

    @Autowired
    private TgBotHelper tgBotHelper;

    @Autowired
    private IAssetFlowService assetFlowService;

    @Autowired
    private IMerchantAssetFlowService merchantAssetFlowService;

    @Autowired
    private Environment env;

    /**
     * 12点-24点每小时推
     */
    @Scheduled(cron = "0 0 12-23,0 * * ?")
    public void hourReport() {
        sendTgNotify();
    }

    @EventListener
    @Async
    public void send(TgNotifyEvent event) {
        TgNotifyDTO notify = event.getNotify();
        if ("hourReport".equals(notify.getOriented())) {
            sendTgNotify();
        }
    }

    private void sendTgNotify() {
        PageHelper.startPage(1, 2, null);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int ymd = year * 10000 + month * 100 + day;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        AssetFlow assetFlow = new AssetFlow();
        List<AssetFlowGroupDTO> flows = assetFlowService.selectDailyAssetFlowList(assetFlow);
        AssetFlowGroupDTO target = null;
        for (AssetFlowGroupDTO flow : flows) {
            // 0点
            if (hour == 0) {
                // 如果是0点找不是当天的
                if (!flow.getYmd().equals(ymd)) {
                    target = flow;
                }
            } else {
                // 非0点找当天的
                if (flow.getYmd().equals(ymd)) {
                    target = flow;
                }
            }
        }
        if (target != null) {
            MerchantAssetFlow query = new MerchantAssetFlow();
            query.getParams().put("beginDay", target.getYmd());
            query.getParams().put("endDay", target.getYmd());
            List<MerchantAssetFlowReportDTO> list = merchantAssetFlowService.listDailyReport(query);
            if (list.isEmpty()) {
                return;
            }
            MerchantAssetFlowReportDTO merchant = list.get(0);

            TgNotifyDTO tgNotifyDTO = new TgNotifyDTO();
            tgNotifyDTO.setTest(!env.acceptsProfiles(Profiles.of("prod")));
            tgNotifyDTO.setScene("业绩整点播报");
            tgNotifyDTO.setOriented("hourReport");

            tgNotifyDTO.setMember("日期：" + target.getYmd());
            tgNotifyDTO.setThings("总充值：" + target.getRecharge().abs().setScale(4, RoundingMode.FLOOR).stripTrailingZeros().toPlainString());
            tgNotifyDTO.setTx("用户提U：" + target.getWithdraw().abs().stripTrailingZeros().toPlainString());

            BigDecimal total = target.getWithdraw().abs();
            total = total.add(merchant.getWithdrawUsdt().abs());
            total = total.add(merchant.getWithdrawCny().abs().divide(BigDecimal.valueOf(7.12), 2, BigDecimal.ROUND_HALF_UP));

            tgNotifyDTO.setRisk(String.format("商户提U：%s \n商户提CNY: %s （≈%s U）\n总提现：%s",
                            merchant.getWithdrawUsdt().abs().stripTrailingZeros().toPlainString(),
                            merchant.getWithdrawCny().abs().stripTrailingZeros().toPlainString(),
                            merchant.getWithdrawCny().abs().divide(BigDecimal.valueOf(7.12), 2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString(),
                            total.stripTrailingZeros().toPlainString()
                            )
            );

            tgNotifyDTO.setCreateAt(System.currentTimeMillis());
            tgBotHelper.notifyTo(tgNotifyDTO);
        }
    }
}
