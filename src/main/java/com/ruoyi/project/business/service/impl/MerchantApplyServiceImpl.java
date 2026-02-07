package com.ruoyi.project.business.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.project.business.config.prop.AppApi;
import com.ruoyi.project.business.config.prop.AppProperties;
import com.ruoyi.project.business.domain.Merchant;
import com.ruoyi.project.business.domain.MerchantApply;
import com.ruoyi.project.business.mapper.MerchantApplyMapper;
import com.ruoyi.project.business.mapper.MerchantMapper;
import com.ruoyi.project.business.service.IMerchantApplyService;
import com.cs.sp.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.cs.sp.common.WebAssert.expectNotNull;
import static com.cs.sp.common.WebAssert.throwBizException;

/**
 * 商家申请Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-25
 */
@Slf4j
@Service
public class MerchantApplyServiceImpl implements IMerchantApplyService {
    @Autowired
    private MerchantApplyMapper merchantApplyMapper;

    @Autowired
    private AppProperties appProperties;
    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 查询商家申请
     *
     * @param id 商家申请主键
     * @return 商家申请
     */
    @Override
    public MerchantApply selectMerchantApplyById(Long id) {
        return merchantApplyMapper.selectMerchantApplyById(id);
    }

    /**
     * 查询商家申请列表
     *
     * @param merchantApply 商家申请
     * @return 商家申请
     */
    @Override
    public List<MerchantApply> selectMerchantApplyList(MerchantApply merchantApply) {
        return merchantApplyMapper.selectMerchantApplyList(merchantApply);
    }

    /**
     * 新增商家申请
     *
     * @param merchantApply 商家申请
     * @return 结果
     */
    @Override
    public int insertMerchantApply(MerchantApply merchantApply) {
        merchantApply.setCreateTime(null);
        return merchantApplyMapper.insertMerchantApply(merchantApply);
    }

    /**
     * 修改商家申请
     *
     * @param merchantApply 商家申请
     * @return 结果
     */
    @Override
    public int updateMerchantApply(MerchantApply merchantApply) {
        merchantApply.setUpdateTime(null);
        MerchantApply exists = merchantApplyMapper.selectMerchantApplyById(merchantApply.getId());
        expectNotNull(exists, "商户不存在");
        Long status = merchantApply.getStatus();
        String message = merchantApply.getMessage();
        boolean toAudit = Constant.ZERO_LONG.equals(exists.getStatus()) && Arrays.asList(Constant.ONE_LONG, 2L).contains(status);
        Merchant query = new Merchant();
        query.setUid(merchantApply.getUid());
        List<Merchant> merchants = merchantMapper.selectMerchantList(query);
        if (toAudit && merchants.isEmpty()) {
            // 本地只更新信息，往api提交状态审核
            merchantApply.setStatus(null);
            merchantApply.setMessage(null);
        }
        merchantApplyMapper.updateMerchantApply(merchantApply);

        // 如果有状态更新
        if (toAudit && merchants.isEmpty()) {
            String prefix = appProperties.getPrefix();
            String param = String.format("?id=%s&status=%s&memo=%s", exists.getId(), status, message);
            String body = HttpRequest.get(prefix + AppApi.MERCHANT_AUDIT + param)
                    .header("Accept-Language", "zh-CN")
                    .execute().body();
            JSONObject json = JSONObject.parseObject(body);
            if (!Constant.ZERO_STR.equals(json.getString("code"))) {
                throwBizException(json.getString("msg"));
            }
        }
        return 1;
    }

    @Override
    public int updateBatch(MerchantApply merchantApply, List<Long> ids) {
        Integer failNum = 0;
        for (Long id : ids) {
            try{
                String prefix = appProperties.getPrefix();
                String msg = merchantApply.getMessage() == null ? "" : merchantApply.getMessage();
                String param = String.format("?id=%s&status=%s&memo=%s", id, merchantApply.getStatus(), msg);
                log.info("MerchantAudit param: {}=>{}", id, param);
                String body = HttpRequest.get(prefix + AppApi.MERCHANT_AUDIT + param)
                        .header("Accept-Language", "zh-CN")
                        .execute().body();
                log.info("MerchantAudit {}:{}", id, body);
                JSONObject json = JSONObject.parseObject(body);
                if (!Constant.ZERO_STR.equals(json.getString("code"))) {
                    failNum++;
                }
            }catch (Throwable ex){
                log.warn(StrUtil.format("MerchantAudit fail {}", id), ex);
                failNum++;
            }
        }
        return failNum;
    }

    /**
     * 批量删除商家申请
     *
     * @param ids 需要删除的商家申请主键
     * @return 结果
     */
    @Override
    public int deleteMerchantApplyByIds(Long[] ids) {
        return merchantApplyMapper.deleteMerchantApplyByIds(ids);
    }

    /**
     * 删除商家申请信息
     *
     * @param id 商家申请主键
     * @return 结果
     */
    @Override
    public int deleteMerchantApplyById(Long id) {
        return merchantApplyMapper.deleteMerchantApplyById(id);
    }

    @Override
    public List<MerchantApply> listWithChildren(MerchantApply entity) {
        return merchantApplyMapper.listWithChildren(entity);
    }

    @Override
    public List<MerchantApply> listWithParents(MerchantApply entity) {
        return merchantApplyMapper.listWithParents(entity);
    }
}
