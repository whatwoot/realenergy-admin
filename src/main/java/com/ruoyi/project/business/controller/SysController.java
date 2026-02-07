package com.ruoyi.project.business.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.business.config.TgNotifyEvent;
import com.ruoyi.project.business.dto.TgNotifyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户资产Controller
 *
 * @author gpthk
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/sys")
public class SysController extends BaseController {


    @GetMapping("/hourReport")
    public AjaxResult sendReport() {
        TgNotifyDTO notify = new TgNotifyDTO();
        notify.setOriented("hourReport");
        SpringUtil.publishEvent(new TgNotifyEvent(this, notify));
        return toAjax(1);
    }
}
