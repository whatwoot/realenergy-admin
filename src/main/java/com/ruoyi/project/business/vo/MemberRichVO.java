package com.ruoyi.project.business.vo;

import com.ruoyi.project.business.domain.Login;
import com.ruoyi.project.business.domain.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberRichVO extends Member {
    private List<Login> accounts;
}
